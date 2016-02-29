package MaximumFlow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mandy on 2015/12/7.
 */
public class FordFulkerson {
    //mark marked vertices in every hasAugmentingPath call, after the last call , the mark array
    //can be used for minCut
    boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;

    /**
     *
     * @param G the flownetwork graph
     * @param s source vetex
     * @param t sink vertex
     */
    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0.0;
        double bottleneck = Double.POSITIVE_INFINITY;
        while (hasAugmentingPath(G, s, t)) {
            for (int v = t; v != s; v = edgeTo[v].other(v))
                bottleneck = Math.min(bottleneck, edgeTo[v].residualCapcityTo(v));
            for (int v = t; v != s; v = edgeTo[v].other(v))
                edgeTo[v].addResidualFlowTo(v, bottleneck);

            value += bottleneck;
        }

    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        marked = new boolean[G.V()];
        edgeTo = new FlowEdge[G.V()];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        marked[s] = true;
        while (queue.size() != 0) {
            int v = queue.poll();

            for (FlowEdge edge : G.adj(v)) {
                int w = edge.other(v);
                if (edge.residualCapcityTo(w) > 0 && !marked[w]) {
                    edgeTo[w] = edge;
                    marked[w] = true;
                    queue.add(w);
                }
            }

        }
        return marked[t];

    }

    public double value() {
        return value;
    }

    public boolean inMinCut(int vertex) {
        return marked[vertex];
    }

}
