package C2;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import C2.Node;
public class ImplementTargetValues {
    public static void main(String[] args) throws FileNotFoundException {
        File f= new File("C:\\Users\\91992\\Downloads\\UBC\\algo1-programming_prob-2sum.txt");
        Scanner in = new Scanner(f);int c=0;
        BigInteger [] data= new BigInteger[1000000];
        while(in.hasNext()){BigInteger temp= new BigInteger(String.valueOf(in.next()));
        data[c]=temp;c++;}
        TargetValuesHashing t= new TargetValuesHashing();
        System.out.println(t.CalulateTargetValues(data));

    }
    private static void printArray(BigInteger [] a){
        for(BigInteger x : a){
            System.out.println(x.longValue());
        }
    }

}
