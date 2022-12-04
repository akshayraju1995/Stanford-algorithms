package C3;
import java.util.List;
import java.util.ArrayList;
public class PrimMST {

    public static int MST(Edge [] l){
        boolean [] V= new boolean [501];
        for(boolean x : V){x=false;}                          //initailize a boolean array to keep track of all the vertices added  to the MST in each iteration of Prim's Algorithm
        int sum=0; boolean completed=false;
             V[1]=true;                                       //start vertex = vertex number 1 for Prim's Algorithm
int c=0;

        while(completed==false)
        {   MinimumEdge Minimum= new MinimumEdge();
            Minimum.min=new Edge(2,111111111);
            for(int i=1;i<V.length;i++){if (V[i]==true){boolean flag=false;Edge min=l[i];
                while(min!=null){if(V[min.endpt]==true){min=min.head;}                      //checks if the adjacent vertices corresponding to the chosen vertex are covered
                                  else{break;}  }
                if(min!=null)                                                               //if all the adjacent vertices are not covered ,perform min edge length computation for the chosen vertex
                {
                int index=i;Edge current =l[i];
            while(current.head!=null){
                if(current.head.cost<min.cost&&(V[current.head.endpt]!=true)){min=current.head;} //Check in the adjacency list row for the lowest cost edge and set it as the minimum
                current=current.head;}
                if(min.cost<Minimum.min.cost){Minimum.min=min;Minimum.i=index;}                  //Check with the minimum edge computed in this round with the minimum computed in this iteration and set the round winner edge as the one with the minimum cost and proceed till all eligible edges are explored
            }}}
         V[Minimum.min.endpt]=true;                                                 //set vertex corresponding to minimum edge length as covered
            sum+=Minimum.min.cost;                                                  //add edge cost of the current minimum edge to spanning tree cost
c++;
            completed =true; for(int x=1;x<V.length;x++){completed=completed && V[x];}  //check if all vertices are covered , if not repeat MST algorithm until all vertices are covered
        }
        return sum;
    }
}
