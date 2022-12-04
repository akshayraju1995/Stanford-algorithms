package C2.Test;
import C2.MinHeap;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import java.util.Random;

public class TestMinHeap {
    MinHeap testHeap;
    int size=100;
    @ Before
    public void setup(){
    testHeap=new MinHeap(size); }
@Test
    public void TestMethods(){
    Random r= new Random();
    for(int i= 0;i<size;i++){testHeap.Insert(r.nextInt(size));}
    while (testHeap.currentSize()!=0){System.out.print(testHeap.ExtractMin()+ " ");} }
    }


