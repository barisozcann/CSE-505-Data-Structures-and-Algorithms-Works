/**
 *
 * @author Baris
 */
import java.util.*;

public class DijkstrasAlgorithm {
    Graph graph;
    int start; //Starting Point
    int[] pred; //Predecessor
    double[] dist;

    /**
     * Constructor Method
     * @param graph
     * @param start
     */
    public DijkstrasAlgorithm(Graph graph, int start) {
        this.graph = graph;
        this.start = start;
    }


    /**
     * This method carry outs Dijkstras Algorithm
     * and print outs the results
     */
    public void getResults(){
        int numV = graph.getNumV();
        this.pred=new int[numV];
        this.dist=new double[numV];

        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
        //Initialize V - S
        for(int i = 0; i < numV; i++){
            if(i != start)
                vMinusS.add(i);
        }
        // Initialize pred and dist
        for(int v : vMinusS){
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        //Main loop
        while(vMinusS.size() != 0){
            //Find the value u in V - S with the smallest dist[u]
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for(int v : vMinusS){
                if(dist[v] < minDist){
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS
            vMinusS.remove(u);
            //Update the distances
            Iterator<Edge> edgeIter = graph.edgeIterator(u);
            while(edgeIter.hasNext()){
                Edge edge = edgeIter.next();
                int v = edge.getDest();
                if(vMinusS.contains(new Integer(v))){
                    double weight = edge.getWeight();
                    if(dist[u] + weight < dist[v]){
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
        System.out.println("For Graph:\nNode, Predecessor, and Distance:");
        for(int i = 0; i < pred.length; i++){
            System.out.println(i + ":\t" + pred[i] + "\t" + dist[i]);
        }
    }

}
