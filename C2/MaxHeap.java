package C2;
import java.math.*;
public class MaxHeap {
    //A heap implementation which returns Maximum value in o(1) time
    // with heap property that every parent node's key is greater the or equal to children node keys
    //{0,1,2,3,4,5,6}
    int [] Maxheap;
    int nextpos,size;
    int negetiveInfinty=-10000000;
    public MaxHeap(int size){
        Maxheap= new int[size];this.size=size-1;
        for(int x=0;x<size;x++){Maxheap[x]=negetiveInfinty;}
        nextpos=0; }

        //method that returns the current maximum in the heap in o(1) time and restores the heap property in o(log n) time
    public int ExtractMax(){int max= currentMax();nextpos--;
    Maxheap[0]=Maxheap[nextpos];Maxheap[nextpos]=negetiveInfinty;
    BubbleDown(0);
    return max;
    }

    private void BubbleDown(int currPos){
        if(((((currPos+1)*2)<=size) && Maxheap[currPos]<Maxheap[(currPos+1)*2] )||( ((((currPos+1)*2)-1)<=size) && Maxheap[currPos]<Maxheap[((currPos+1)*2)-1]))
        { int nextIndex=(currPos+1)*2;
            if((((currPos+1)*2)<=size) && (((currPos+1)*2 )<=size))                                                //case 1 : both the indices are less than size
        {    if(Maxheap[(currPos+1)*2]<Maxheap[((currPos+1)*2)-1]){nextIndex--;}
            int temp= Maxheap[nextIndex];Maxheap[nextIndex]=Maxheap[currPos];Maxheap[currPos]=temp;
            BubbleDown(nextIndex);}

            else if(((currPos+1)*2)<=size){                                                                         //case 2 : right subchild is less than size
                int temp= Maxheap[nextIndex];Maxheap[nextIndex]=Maxheap[currPos];Maxheap[currPos]=temp;BubbleDown(nextIndex);  }

              else {nextIndex--;int temp= Maxheap[nextIndex];Maxheap[nextIndex]=Maxheap[currPos];Maxheap[currPos]=temp;// case 3 : left subchild is less than size
                BubbleDown(nextIndex);}
            } }



      //Method inserts an element into the MaxHeap and also maintains the heap property;
        public void Insert(int n){int currpos= nextpos;Maxheap[nextpos]=n;nextpos++;
        BubbleUp(currpos); }

    private void BubbleUp(int currpos)                                                  //if inserted node is greater than its parent node , swap them ,if required until the root
    {
        if (currpos!=0){
            if ((currpos) % 2 == 0) {                                   // if inserted node is in the even position
                if (Maxheap[((currpos / 2) - 1)] < Maxheap[currpos]) { //swap if parent key < newly inserted child's key
                    int temp= Maxheap[currpos]; Maxheap[currpos]=Maxheap[((currpos / 2) - 1)]; Maxheap[((currpos / 2) - 1)]=temp;
                    currpos = ((currpos/2)-1);BubbleUp(currpos);}
            } else {
                if (Maxheap[(((currpos+1) / 2) - 1)] < Maxheap[currpos]){
                    int temp= Maxheap[currpos]; Maxheap[currpos]=Maxheap[(((currpos+1) / 2) - 1)]; Maxheap[(((currpos+1) / 2) - 1)]=temp;
                    currpos=(((currpos+1) / 2) - 1);BubbleUp(currpos);} } }  }


    public int currentMax(){return Maxheap[0];}

    public int currentSize(){return nextpos;}

        public void printHeap(){for(int x: Maxheap){
            System.out.print(x+ " " );
        }}

        public int heapSize(){return size;}

}
