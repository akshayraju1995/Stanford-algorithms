import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
public class TestClosestPair {
    ClosestPair c;double[][]a;double[][] l;double[][]r;double [][]x;
@Before
    public void Setup(){   c=new ClosestPair(); a= new double[2][2];  l= new double[][]{{1, 2}, {2, 4}, {6, 5}, {7, 3}};
r=new double[][]{{8,0},{9,1},{10,-1},{11,-2}};
x=new double[][]{{1, 2}, {2, 30}, {6, 5}, {7, 3},{8,0},{9,1},{10,-1}};
}

@Test
public void Testdist(){float d=1;
    a[1]= new double[]{1, 1};
    a[0]=new double[]{1,2};
   Assert.assertEquals(c.dist(a),d,0);}
@Test
public void Testmakesplitzonel(){
c.printarray2d(c.makesplitzonel(l,new double[][]{{1,2},{2,4}},new double[][]{{8,2},{9,1}}));
}
@Test
public void Testmakesplitzoner(){
    c.printarray2d(c.makesplitzoner(l,r,new double[][]{{1,2},{2,4}},new double[][]{{8,2},{9,1}}));
}
@Test
public void TestCalculateRange(){
    c.xsort=x;
    printA(c.calculaterange(3, Math.sqrt(2),r));
}
    @Test
    public void TestSplitPairDistance(){
    double [][] Lz=c.makesplitzonel(l,new double[][]{{1,2},{2,4}},new double[][]{{8,0},{9,1}});
    double [][] Rz=c.makesplitzoner(l,r,new double[][]{{1,2},{2,4}},new double[][]{{8,0},{9,1}});
    double[][] high=c.findcurrenthigh(new double[][]{{1,2},{2,4}},new double[][]{{8,0},{9,1}});
    c.ysort=c.mergesort0forx1fory(x,1);
      //  c.printarray2d(c.splitpairDistance(Lz,Rz,high));
   c.printarray2d(c.DivideandConquerClosestPair(x));
        System.out.println("\n");
   c.printarray2d(c.NaiveClosestPair(x));
    }



public void printA(int[]a){for(int x:a) System.out.println(x);}
}
