package C2.Test;
import C2.HashTable;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class TestHashTable {
    BigInteger[] data;
    HashTable ht;
    @Before
    public void Setup() throws FileNotFoundException {
    File f= new File("C:\\Users\\91992\\Downloads\\UBC\\algo1-programming_prob-2sum.txt");
    Scanner in = new Scanner(f);int c=0;
     data=new BigInteger[1000000];
    while(in.hasNext()){BigInteger temp= new BigInteger(String.valueOf(in.next()));
        data[c]=temp;c++;}
    ht= new HashTable(data.length);
        for(BigInteger x: data){                                 //insert the input values into the hash table
            if (ht.lookup(x.longValue())==false){  ht.insert(x); } }}
            @Test
            public void TestHT(){
        boolean check=true;
        for (int i=0;i<data.length;i++){
            boolean c=ht.lookup(data[i].longValue());
            check= check && c; }
        long x=data[0].longValue()-data[2].longValue();
//        long long z =11417698679;

                System.out.println(x);
        Assert.assertTrue(check);
            }
}
