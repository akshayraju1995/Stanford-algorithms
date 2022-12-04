import java.util.Random;
public class ImplementClosestPair{

    public static void main(String[] args) {
        Random re=new Random();
        int size=25000;
        double[][] a = new double[size][2];for(int i=0;i<size;i++){a[i][0]=i*4;a[i][1]=i+2;}
        ClosestPair c= new ClosestPair();
      float s1= System.nanoTime();
  c.printarray2d(c.NaiveClosestPair(a));
   float st1=System.nanoTime();
   c.printarray2d(c.DivideandConquerClosestPair(a));
float st2=System.nanoTime();

        System.out.println("Divide and conquer is "+((st1-s1)/(st2-st1)) +" times faster than naive ");
}

}

