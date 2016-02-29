package MaximumFlow;

import java.util.IllegalFormatCodePointException;

/**
 * Created by lihao on 12/6/15.
 */
public class FlowEdge {
    private final int from ; //edge source
    private final int to ; //edge target
    private final double capacity;//capacity
    private double flow; //current flow
    public FlowEdge(int from, int to, double cap){
        this.from =from;
        this.to =to;
        this.capacity =cap;
        this.flow = 0;

    }
    public int from(){
        return from;
    }
    public int to(){
        return to;
    }
    public int other(int vertex){
        if( vertex == from) return  to ;
        else if(vertex == to) return  from ;
        else throw  new IllegalArgumentException("Illegal endpoint");

    }
    //capacity of this edge
    public double capacity(){
        return capacity;
    }
    //flow in this edge
    public double flow(){
        return  flow;
    }
    // residual capacity toward v
    double residualCapcityTo(int vertex){
        if(vertex== from) return flow;   // backward edge
        else if(vertex == to) return capacity - flow; //forward edge
        else throw new IllegalArgumentException("inconsistent edge");
    }
    // add delta flow toward v
    public void addResidualFlowTo(int vertex, double delta){
       if (vertex == from) flow -= delta;
        else if (vertex == to) flow += delta;
        else throw new IllegalArgumentException("illegal vertex");

    }
    // string representation
    public String toString(){
        return String.format("%d->%d %.2f %.2f", from, to, capacity, flow);
    }
}
