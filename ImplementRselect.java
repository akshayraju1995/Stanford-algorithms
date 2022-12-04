import java.util.Random;

public class ImplementRselect {
    public static void main(String[] args) {
        int []a={1,32,3,4,6,0,-2,5,60};Random n1= new Random();
        Rselect r= new Rselect();int c=0;
    //  while (c<20)  {System.out.println(n1.nextInt(6));c++;}
        System.out.println(r.ithelement(a,a.length,8));
    }
}
