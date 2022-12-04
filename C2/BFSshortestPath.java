package C2;
import java.util.List;
public class BFSshortestPath {

    /**
     * using BFS to find shortest path distance in an undirected graph
     */
    static int[][] dist;  //Declare a distance array for all the vertex distances relative to the start vertex
    static int[][] explored;

    public int shortest_pathdist(List<List<Integer>> G, int s, int t) {
        dist = new int[G.size()][2];                         //Intialize the distance array
        for (int i = 0; i < dist.length; i++) {
            dist[i][0] = G.get(i).get(0); }
        Queue todo = new Queue();                            // instantiate a que for keeping track of vertices to be visited during BFS
        todo.enque(s);
        explored=new int[dist.length][2];                    //an array to keep track of explored vertices
        for(int y=0 ;y< dist.length;y++){explored[y][0]=dist[y][0];}
        for (int[] x : explored) {
            if (x[0] == s) { x[1] = 1; } }                  // mark vertex s as explored
              /**The BFS Loop*/
         while (!todo.isEmpty())                          //while queue contains vertices to be explored keep looping
        {   int c = 0;
            int k=todo.dequeue();
            for (int j = 0; j < G.size(); j++) {if (G.get(j).get(0) == k) { c = j; } }
            for (int i = 1; i < G.get(c).size(); i++) {
                if (!Explored(explored, G.get(c).get(i))) {
                    int p1 = 0;
                    for (int j = 0; j < G.size(); j++) {if (G.get(j).get(0) == G.get(c).get(i)) { p1 = j; } }
                    setExplored(p1);
                    setDistance(p1, G.get(c).get(0));
                    todo.enque(G.get(c).get(i)); }} }
        int finald = 99;                                           //setting to some random value to avoid compile error
        for (int[] x : dist) {if (x[0] == t) { finald = x[1]; }}
        return finald;
    }

    /**This method sets the distance of a newly found vertex*/
    private void setDistance(Integer p1, Integer from) {
        int g=0;for(int []x :dist){if(x[0]==from){g=x[1];} }
        this.dist[p1][1]=1+g;}

    /**This method sets a given vertex as explored*/
    private void setExplored(Integer p) { this.explored[p][1]=1;}

    /**Returns true if a vertex has been explored during any step of the BFS method execution else returns false*/
    private boolean Explored(int[][] explored, Integer tc) {for (int[] x : explored) {
            if (x[0] == tc && x[1] == 1) {
                return true; } }
        return false;}

}