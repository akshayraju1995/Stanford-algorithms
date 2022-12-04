package C3;

public class HeapVertex {
    public static Vertex [] heap;
    private static int p=0;
    public  HeapVertex(int size){heap= new Vertex [size];}
    //Insert method
    public  void insert(Vertex v){                    //method inserts a vertex into the heap by bubbling up in O(lon n) time
                                                           //parent at i has children at ((i+1)*2) and ((i+1)*2)-1
        heap[p]= v;p++;
        bubbleup(p-1);
    }

    private static void bubbleup(int i) {
        if(i!=0){
        int parent= ((i+1)/2)-1;
        if(i%2==0){parent=(i/2)-1;}
        if (heap[i].size<heap[parent].size)
        {Vertex swap= heap[i];heap[i]=heap[parent];heap[parent]=swap;
        bubbleup(parent);}
        }
    }

        //Extract min method

    public  Vertex extractMin()
    {Vertex v= heap[0];
    heap[0]=heap[p-1];p--;
    bubbledown(0);
    return v;
    }

    private static void bubbledown(int pos){
        if(((pos+1)*2)<=p-1 ){
        if (heap[pos].size>heap[(pos+1)*2].size|| heap[pos].size>heap[((pos+1)*2)-1].size )
        {    int index1 = (pos+1)*2; int index2 =((pos+1)*2 )-1;int exch=index2;
             if(heap[index1].size <=heap[index2].size){exch=index1;}
             Vertex temp=heap[exch];heap[exch]=heap[pos];heap[pos]=temp;
             bubbledown(exch);
        }}
           else if((((pos+1)*2)-1)<=p-1){
               if ( heap[pos].size>heap[((pos+1)*2)-1].size ){int exch=((pos+1)*2)-1;
                   Vertex temp=heap[exch];heap[exch]=heap[pos];heap[pos]=temp;
                   bubbledown(exch);
               }} }

               public int getSize(){return p;}


}
