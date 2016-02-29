package MaximumFlow;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lihao on 12/6/15.
 */
public class FlowNetwork {
    private int V; //number of vertices
    private int E;
    private List<FlowEdge>[] adj;


    public  FlowNetwork(int v){
        this.V = v;
        this.adj = (ArrayList<FlowEdge>[]) new ArrayList[v];
        for (int i = 0; i < V ; i++) {
            adj[i] = new ArrayList<FlowEdge>();
        }
    }
    public  FlowNetwork(InputStream in){
        Scanner scanner = new Scanner(in);
        this.V = scanner.nextInt();
        this.E = scanner.nextInt();
        this.adj = (ArrayList<FlowEdge>[]) new ArrayList[V];
        for (int i = 0; i < V ; i++) {
            adj[i] = new ArrayList<FlowEdge>();
        }
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            Double capacity = scanner.nextDouble();
            adj[v].add(new FlowEdge(v, w, capacity));

        }
    }
    //number of vertices
    public int V(){
        return V;
    }
    //number of edges
    public int E(){
        return E;
    }
    public void addEdge(FlowEdge edge){
        int v = edge.from();
        int w = edge.to();
        adj[v].add(edge);
        adj[w].add(edge);
    }
    public Iterable<FlowEdge> adj(int vertex){
        return adj[vertex];

    }

//    public Iterable<FlowEdge> edges(){
//
//    }


}
