package C2.Test;
import C2.MaxHeap;import C2.MinHeap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.Random;
public class TestMaxHeap {
MaxHeap max;MinHeap min;
int size=1000;
   @Before
    public void setup()
    {max= new MaxHeap(size);min = new MinHeap(size);}

   @Test
   public void TestMethods(){
    Random r= new Random();
       for(int i= 0;i<size;i++){
           int iterNum=r.nextInt(size);max.Insert(iterNum);min.Insert(iterNum);}
       int []MAXHeapSort= new int[size];int [] MINHeapSort= new int [size];

       for (int i = size-1; i>=0;i-- )
       {MINHeapSort[i]=min.ExtractMin();MAXHeapSort[(size-1)-i]=max.ExtractMax();}

       for(int i=0;i<size;i++ )
       { System.out.print(MAXHeapSort[i]+ " ");}
   }
   @Test
    public void TestMaxHeap(){

   }


}
