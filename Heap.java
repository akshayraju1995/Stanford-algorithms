import C2.VertexPaths;

public class Heap {
    /**Implementation of Min heap
     * the min heap property - every key of child node of a parent node is <= key of parent node
     * - The heap is an array implementation with vertex struct containing the vertex name and distance from source vertex */

    VertexPaths [] V; int insert;
    public Heap(int size){ insert=0;
        V= new VertexPaths [size];}

        //TODO : expand methods

        public int ExtractMin(){int name = V[0].vertex ; return name ;}

        // public void Delete(int vertexName){}

        public void insert(VertexPaths v) { V[insert]=v;

        if (V[insert].distance<V[insert/2].distance){}
    }

}
