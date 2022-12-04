package C2;

import java.util.ArrayList;
import java.util.List;

public class DFStopologicalOrder {
    static int counter;                                       // a counter for keeping track of ordering number of vertex to be assigned during ordering
    int [][] visited;
    Stack todo;                                                // a stack
    List <int []> ordering ;                                  // a  list to keep track of order assigned to the vertices during the DFS

    /** method returns the topological ordering of vertices in a given directed Graph by DFS  */

    public List<int []> topologicalsort(List<List<Integer>> Graph) {
        counter =  Graph.size();                                 // initialize counter to total number of vertices in the given Graph
         todo = new Stack();                                    //initialize a stack for storing the vertices to be visited
        visited = new int[Graph.size()][2];                     //initalize an array for keeping track of visited vertices during DFS
        ordering= new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            visited[i][0] = Graph.get(i).get(0); }

        for (int c = 0; c < Graph.size(); c++) {
            if (!IsVisited(Graph.get(c).get(0))) {
                todo.push(Graph.get(c).get(0));
               // markvisited(Graph.get(c).get(0));
                DFS(Graph,todo); } }
        return ordering; }


    private void DFS(List<List<Integer>> graph, Stack todo) {
    while(!todo.isEmpty()){
        int p=todo.pop(); int pos=898;
        for(int i=0;i<graph.size();i++)
        {if (graph.get(i).get(0)==p){pos=i;break;} }
        if (graph.get(pos).size()==1)                                                   //if the vertex is a sink vertex number it and mark it visited
        { int [] n = {p,counter}; ordering.add(n); counter--; //counter++;
            markvisited(graph.get(pos).get(0));
            DFS(graph,todo);}

        else{boolean visit=true;                                                       //if the vertices below a vertex are numbered then number itself
             for(int k=1; k<graph.get(pos).size();k++)                                 //else add non numbered vertices to the stack and proceed with DFS
             {visit=visit && IsVisited(graph.get(pos).get(k));}
             if(visit==true)
             { int [] n = {p,counter}; ordering.add(n); counter--; //counter++;
                 markvisited(graph.get(pos).get(0));
                 DFS(graph,todo);}
             else{
            todo.push(p);
            for(int j=1; j<graph.get(pos).size();j++)
            {if (!IsVisited(graph.get(pos).get(j)))
            todo.push(graph.get(pos).get(j));
            }DFS(graph,todo);}}

}
    }





    private boolean IsVisited(Integer integer) {
        for(int [] x :visited){if (x[0]==integer && x[1]==1){return true;}}
        return false; }


    private void markvisited(int i) {
        for(int [] x: visited ){if(x[0]==i){x[1]=1;break;}}}


}
