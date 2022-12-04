package C2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MedainMaintenance {
    /** method returns sum of medians which are calculated at every step a new integer is provided along with previously provided integers */
    long sum;
    List<Integer> a;
    MinHeap minheap;MaxHeap maxheap;
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\91992\\Downloads\\UBC\\Median.txt");
        Scanner in = new Scanner(input);int [] array= new int [10000];int i=0;
        while(in.hasNext()){array[i]=Integer.parseInt(in.next());i++;}
        //for(int x: array){System.out.print(x+ " ");}
        MedainMaintenance m= new MedainMaintenance();
        double st=System.nanoTime();
        System.out.println(m.naiveImplementation(array));
        double sp=System.nanoTime();
       double st1=System.nanoTime();
        System.out.println(m.MedianSum(array));
        double sp1=System.nanoTime();
        System.out.println("Fast Implementation is "+ (sp-st)/(sp1-st1)+" times faster");

    }
    public  long MedianSum(int [] array)
    { minheap=new MinHeap(array.length); maxheap= new MaxHeap(array.length);
        maxheap.Insert(array[0]);sum=array[0];
    for(int i=1;i<array.length;i++)
    {  fillHeap(array, i);
        int t= maxheap.currentMax();int tmin=minheap.CurrentMin();
    if ((i+1)%2==0){sum+=t;}
    else{if (maxheap.currentSize()>minheap.currentSize()){sum+=t;}else{sum+=tmin;}}
    }
    return (sum);

    }

    public void fillHeap(int[] array, int i) {
        if (array[i]<=maxheap.currentMax()){
        if (maxheap.currentSize()<=minheap.currentSize()){
        maxheap.Insert(array[i]); }
        else{int temp= maxheap.ExtractMax();maxheap.Insert(array[i]);minheap.Insert(temp);}}
        else{
            if(minheap.currentSize()<=maxheap.currentSize()){minheap.Insert(array[i]);}
            else{if(array[i]<minheap.CurrentMin()){maxheap.Insert(array[i]);}
                else{int temp=minheap.ExtractMin(); maxheap.Insert(temp);minheap.Insert(array[i]); }}    }
    }

    public long naiveImplementation(int [] input )
    {   a= new ArrayList<>();
        sum=input[0];a.add(input[0]);
        for(int i=1;i<input.length;i++){
            a.add(input[i]);
            Collections.sort(a);
            if(((i+1)%2)==0){ sum+=a.get(((i+1)/2)-1);}
            else{sum+=a.get(i/2);}
        } return sum; }




}
