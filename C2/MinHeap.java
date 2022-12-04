package C2;

public class MinHeap {
    //A heap implemenataion for integers with heap property that every parent node's key is less the or equal to child nodes key
    //{0,1,2,3,4,5,6,7,8} a child node is at position ((i+1)*2)-1 & another at ((i+1)*2) where i is an index in the array
    // parent node of a child note at indlex i is ((i+1)/2)-1 if i is odd and ((i/2)-1)if i is even
    int [] Minheap;
    int nextpos;
    int infinity=100000000;
    int size;
    //initialize the heap to a required size
    public MinHeap(int size){Minheap= new int[size];nextpos=0;this.size=size-1;
    for(int i=0;i< size;i++){Minheap[i]= infinity;}
    }

    // returns value of current minmum element in the heap
    public int CurrentMin(){return Minheap[0];}

    //returns minimum of the heap and deletes it from the heap while restoring heap property
    public int ExtractMin(){int min= CurrentMin();
     //swap min at index 0 with last index and bubble down the tree until heap property is restored
        nextpos--;Minheap[0]=Minheap[nextpos];Minheap[nextpos]=infinity;
        BubbleDown(0);
        return min;}

        private void BubbleDown(int i)
             //to add case to not exceed size of elements inserted
        {   if(((((i+1)*2)<=size) && Minheap[i]>Minheap[(i+1)*2] )||( ((((i+1)*2)-1)<=size) && Minheap[i]>Minheap[((i+1)*2)-1]))
        { int nextIndex=(i+1)*2;
            if((((i+1)*2)<=size) && (((i+1)*2 )<=size))                                                       //case 1 : both the indices are less than size
            {    if(Minheap[(i+1)*2]>Minheap[((i+1)*2)-1]){nextIndex--;}
                int temp= Minheap[nextIndex];Minheap[nextIndex]=Minheap[i];Minheap[i]=temp;
                BubbleDown(nextIndex);}

            else if(((i+1)*2)<=size){                                                                         //case 2 : right subchild is less than size
                int temp= Minheap[nextIndex];Minheap[nextIndex]=Minheap[i];Minheap[i]=temp;BubbleDown(nextIndex);  }

            else {nextIndex--;int temp= Minheap[nextIndex];Minheap[nextIndex]=Minheap[i];Minheap[i]=temp;    // case 3 : left subchild is less than size
                BubbleDown(nextIndex);}
        } }


        //inserts the given key in the heap preserving the heap property
    public void Insert(int n){Minheap[nextpos]=n; int currp= nextpos; nextpos++;
        InsertCheck(currp);
    }

    private void InsertCheck(int currp) {
        if (currp!=0) {                                                //if inserted node is not root node
            if ((currp) % 2 == 0) {                                   // if inserted node is in the even position
                  if (Minheap[((currp / 2) - 1)] > Minheap[currp]) { //swap if parent key > newly inserted child's key
                     int temp= Minheap[currp]; Minheap[currp]=Minheap[((currp / 2) - 1)]; Minheap[((currp / 2) - 1)]=temp;
                  currp = ((currp/2)-1);InsertCheck(currp);}
            } else {
                if (Minheap[(((currp+1) / 2) - 1)] > Minheap[currp]){
                    int temp= Minheap[currp]; Minheap[currp]=Minheap[(((currp+1) / 2) - 1)]; Minheap[(((currp+1) / 2) - 1)]=temp;
                    currp=(((currp+1) / 2) - 1);InsertCheck(currp);} } }
    }

   public void PrintHeap(){
        for(int x : Minheap){
            System.out.print(x + " ");  }}

            public int currentSize(){return nextpos;}



}
