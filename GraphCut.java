import java.security.spec.MGF1ParameterSpec;
import java.util.List;
import java.util.Random;

public class GraphCut {
    Random r= new Random();
   /** 1) picks a vertex from a graph at random
    *  2) picks an edge adjacent to the vertex at random
    *  3) contracts the edge by removing self loops from chosen vertex and adjacent vertex of the edge chosen
    *  4) add remaining edges from the chosen adjacent vertex to the tail vertex
    *  5) remove adjacent vertex and pass graph recursively to the function until 2 vertices are left , return min cut */
    public int KargerMinCut(List<List<Integer>> graph){
    if (graph.size()==2){
        return graph.get(0).size()-1;}
    else{int r0 = r.nextInt(graph.size());
         int r1 = 1 + r.nextInt(graph.get(r0).size()-1);
         int t=graph.get(r0).get(0);
        int e = graph.get(r0).get(r1);
        /**removes self loops and head element if chosen edge is same*/
        for (int x=graph.get(r0).size()-1 ; x > 0 ;x--)
        {if (graph.get(r0).get(x).equals(e)){graph.get(r0).remove(x);}}
        /**compute the vertex postion in the arraylist for chosen endpoint of edge*/
        int vp=computeVP(graph, e);
        /**removes self loops and tail element */
        for (int y=graph.get(vp).size()-1 ; y > 0 ;y--){if (graph.get(vp).get(y).equals(t)){graph.get(vp).remove(y);}}
        /**add remaining edges from chosen head vertex to the tail*/
        for(int j=1 ; j<graph.get(vp).size();j++){graph.get(r0).add(graph.get(vp).get(j));}
        /** replace all the edges corresponding to the head vertices to point to the tail vertex*/
        graph=repalaceVertices(graph,vp, t);
        graph.remove(vp);
        return KargerMinCut(graph);
    }}

    /** a procedure to go to all the vertices mentioned in the head vertex as edges and
     * replace head vertex with tail vertex in those vertices*/
    private List<List<Integer>> repalaceVertices(List<List<Integer>> graph, int vp,int tr) {
        int comp= graph.get(vp).get(0);
        for (int i=1;i< graph.get(vp).size();i++){
            int j=computeVP(graph,graph.get(vp).get(i));
            for(int k=1; k< graph.get(j).size();k++){ if (graph.get(j).get(k).equals(comp)){graph.get(j).set(k,tr);}}
        }return graph;}

    private int computeVP(List<List<Integer>> graph, int e) {
        for (int x=0 ;x<graph.size();x++)
        {if (graph.get(x).get(0).equals(e)){
            return x;}}return 0;}


}
