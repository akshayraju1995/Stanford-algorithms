package C2;

import java.util.ArrayList;
import java.util.List;

public class BFSconnectedComponents {
    static List<List<Integer>> connected;
    int [][] explored ;
     static List<Integer> toadd;                                                         // a list vertices of a single connected component


    /**Returns the connected components in an unidrected Graph*/

    public List<List<Integer>> ConnectedComponents(List<List<Integer>> Graph){
        connected= new ArrayList<>();                                                   //array that stores the Connected components
        explored= new int[Graph.size()][2];                                            // array keeps track of explored vertices during BFS calls
    for(int i=0 ; i< explored.length;i++) {explored[i][0]= Graph.get(i).get(0) ;}     //initaialize the explored array to not explored for all the vertices
        Queue todo = new Queue();                                                    // initialize a que for next vetices to be visited in the BFS procedure
      /**Start the loop for finding the connected components*/
        for(int s=0; s<Graph.size();s++){
            if(!Explored(Graph.get(s).get(0))){
                markExplored(Graph.get(s).get(0));
                todo.enque(Graph.get(s).get(0));
                toadd=new ArrayList<>();
                toadd.add(Graph.get(s).get(0));
                /**Start the BFS loop*/
        while(!todo.isEmpty()){
          int t=todo.dequeue();int p=100;
          for(int x=0;x< Graph.size();x++){                                          //Finds position of next queued vertex to be visited
              if(Graph.get(x).get(0)==t){p=x;break;} }                               // in the Graph adjacency list  to help operate on it
            for(int j=1;j<Graph.get(p).size();j++){
                if (!Explored(Graph.get(p).get(j))){
                    todo.enque(Graph.get(p).get(j));markExplored(Graph.get(p).get(j));
                    toadd.add(Graph.get(p).get(j));} }
        }connected.add(toadd);
        }}
        return connected;
    }




    /**Helper functions */

    private void markExplored(Integer integer) {
        for (int [] x: explored){if (x[0]==integer){x[1]=1;break;}}}


    private boolean Explored(Integer integer) {
    for(int [] x:explored ){if(x[0]==integer && x[1]==1){return true;}} return false;}


}
