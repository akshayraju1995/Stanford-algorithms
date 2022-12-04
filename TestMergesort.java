import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMergesort {
    MergeSort m;

    @Before
     public void setup() {
       m = new MergeSort();
    }
    @Test
    public void TestAddele(){
        int [] a1={1,4};
        int [] a2={3,6};
        int [] op={1,2,3,5};
        m.printArray(m.addele(a1,a2));
        Assert.assertEquals(m.addele(a1,a2).length,4);
    }
    @Test
    public void TestCombineArrays(){
        int [] a1={1,2,4,6,8};
        int [] a2={3,6,543543,645643,87686786};
        int [] op={1,3,4,6};
        m.printArray(m.combineArrays(a1,a2));
        Assert.assertEquals(m.combineArrays(a1,a2).length,10);
    }
    @Test
    public void TestFillArray(){
        int [] a1={1,2,4,6,8,423423,576,0,-1,-3};
        int [] a2={3,6};
        int [] op={1,3,4,6};
        m.printArray(m.fillarray(a2,op,0,2));
        Assert.assertEquals(m.fillarray(a2,op,0,2).length,2);
    }
    @Test
    public void TestMergesort(){
        int [] a1={1,2,4,6,8,423423,576,0,-1,-3};
        int[] a2={2,1,3,545,3,4,5};
        m.printArray(m.mergesort(a2));
      //  Assert.assertEquals(m.fillarray(a2,op,0,2).length,2);
    }
}
