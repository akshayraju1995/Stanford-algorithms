package C2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

public class StronglyCC {
/**Strongly connected components using Kosaraju's 2 pass algorithm in time O(m+n)
 * Steps-
 * 1) Reverse graph and compute the finishing times of vertices in the reverse graph by DFS
 * 2) Apply DFS starting with descending order of vertex finishing times on non-reversed graph to compute SCCs
 * **/
int [] FVRevG;
Stack todo;
boolean [] ExploredVertices;
List<Integer> [] RGraph;                            //using a Graph variable to store the Reverse Graph for easy access to other methods in the class
List<Integer> [] Graph;                             //using a Graph variable to store the Graph for easy access to other methods in the class
List<List<Integer>> Scc;int fv;                     //using an integer list to store SCCs
List<Integer> Toadd;                                //contains one SCC which will be added List of SCCs at the end of each iteration of the second DFS loop
public List<List<Integer>> DirectedSCC(List<Integer>[] Graph,List<Integer>[] RevGraph)
{ FVRevG = new int[875715];     for(int x : FVRevG ){x=0;}                    //initialize an array to store the finishing times of the vertices computed in DFS first pass on the reverse graph
  fv= 1;                                                                      //initalize a counter to zero which will keep track of vertex finishing times in the first pass of the algorithm
     RGraph=RevGraph; Scc= new ArrayList<>();
     this.Graph=Graph;
          ExploredVertices = new boolean[875715];
          for(boolean x: ExploredVertices){x=false;}    //initialize the explored vertices as false in the beginning as none of the vertices are explored yet
        for(int i=0;i<RevGraph.length;i++){             //loop to compute finishing times of the vertices in the reverse Graph
            if(RevGraph[i].get(0)!=0)
            {if (notExplored(RevGraph[i].get(0))){
                markExplored(RevGraph[i].get(0));
              todo = new Stack();todo.push(RevGraph[i].get(0));
                DFSfirstPass();}}}
                for(int x=0;x< ExploredVertices.length;x++){ExploredVertices[x]=false;} //re initalize for DFS second pass
                for(int j=FVRevG.length-1;j>=1;j--)        // DFS loop 2 to compute SCCs
                {if (FVRevG[j]!=0){
                    if(notExplored(FVRevG[j])){
                        markExplored(FVRevG[j]);
                        todo= new Stack();todo.push(FVRevG[j]);
                      Toadd= new ArrayList<>();
                      DFSsecondPass();
                        Scc.add(Toadd);}
                }}
                return Scc; }

    /**DFS search to generate vertex numbering*/
    private void DFSfirstPass() {
        while (!todo.isEmpty()){
            int current= todo.pop();
            boolean exp=true;
            if(RGraph[current].size()==1){
                FVRevG[fv]=current;fv++;}
            else {for(int i=1;i<RGraph[current].size();i++){exp=exp && (ExploredVertices[RGraph[current].get(i)]);}
                if(exp){FVRevG[fv]=current;fv++;}
                else{todo.push(current);
                    for(int i=1;i<RGraph[current].size();i++){
                        if (notExplored(RGraph[current].get(i))){
                            markExplored(RGraph[current].get(i));
                            todo.push(RGraph[current].get(i));}}} } }
    }

                /** DFS search on original Graph to compute the SCCs*/
    private void DFSsecondPass() {
        while(!todo.isEmpty()){
            int current = todo.pop();
            Toadd.add(current);
            boolean exp= true;
            if(Graph[current].size()!=1){
                for(int i=1;i<Graph[current].size();i++){exp=exp&& (ExploredVertices[Graph[current].get(i)]);}
                if(!exp){for(int i=1;i<Graph[current].size();i++){if(notExplored(Graph[current].get(i)))
                {markExplored(Graph[current].get(i));todo.push(Graph[current].get(i));}}}
            }
        } }


    //method to mark a vertex as explored if it is visited
    private void markExplored(int integer){ExploredVertices[integer]=true; }


    private boolean notExplored(Integer integer) {
        if(ExploredVertices[integer]==true){return false;}
        return true; }
    }