package C2;
import java.util.ArrayList;
import java.util.List;
public class DijkstraShortestPath {
    int [][] distance ;List<Integer> completed;
    public int [] [] dijkstra(List<List<int []>> Graph)
    {distance= new int[Graph.size()+1][2];
     completed= new ArrayList<>();                                                //initialize a list to keep track of vertices which are covered
     for (int i=0 ; i< distance.length ;i++){distance[i][0]=i;} distance[1][1]=0; //initialize the distance matrix
     completed.add(Graph.get(0).get(0)[0]);                                       // mark first vertex as explored

        while (completed.size()!=Graph.size())
        {List<int []> distance_iteration= new ArrayList<>() ;                           //temporary arrayList to store values of shortest distances of all vertices going out of explored list to non explored list
            for(int x : completed)                                                      //compute distances for all outgoing edges from explored list to non-explored
         {
           for (int y=1;y<Graph.get(x-1).size();y++)
            {int [] currD={Graph.get(x-1).get(y)[0], (Graph.get(x-1).get(y)[1] + distance[x][1])}; // compute distances of all the edges in an iteration and store in list
             distance_iteration.add(currD);}
            } int [] smallest=distance_iteration.get(0);  for(int i=1; i< distance_iteration.size();i++){
            if (smallest[1]>distance_iteration.get(i)[1]){smallest=distance_iteration.get(i);}}
            int temp=smallest[0];
            for(int x : completed){for(int y=1;y<Graph.get(temp-1).size();y++){                     //loop to remove all edges corresponding to the chosen vertex which have already been explored
                if (Graph.get(temp-1).get(y)[0]==x){Graph.get(temp-1).remove(y);break;}}}
            for(int x : completed){for (int z =1 ; z<Graph.get(x-1).size();z++){                    // loop to remove the edges of newly chosen vertex from explored vertices
                if(Graph.get(x-1).get(z)[0]==temp){Graph.get(x-1).remove(z);}}}
            distance[temp][1]=smallest[1];
            completed.add(smallest[0]);}
    return distance;
    }



}
