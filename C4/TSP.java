package C4;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;


public class TSP {

    static List<String> c= new ArrayList<>();
    static String [] combinations= new String [(int)Math.pow(2,25)];
    static Double [] a = new Double[(int) Math.pow(2,25)];static boolean [] covered= new boolean[25];
    static String [] store;
    List<String> s;
    public TSP(){
        combinations[0]="0000000000000000000000000";
        a[0] =22.2222;
        for(boolean i: covered){i=false;}
          store= new String[(int) Math.pow(2,25)];
          s=new ArrayList<>();s.add( "00000000000000000000000000");}

    /** This class implements TSP for 25 cities and calculates minimum cost tour based on euclidean distances between cities */
    /**for memoization , at any subproblem size we require 1 row and 2^n columns . Only the values computed for previous subproblem are required and values previous to that are not required to be stored

     Recurrence for the problem is -

     for every S that contains j and j!=1 (source vertex)
     A[S,j]=min(for every k in S  A[S-{j},k]+ Ckj )
     for every size of subproblems from m=1 to n
     for every S that is a subset of size m
     for every j = 2 to n  excluding source vertex

    Base Case A(S,1)  = 0 if  S = {1}
                      = infinity if S!={1}
     */


    //TODO:method to compute the TSP tour length
    public double TSP_tour(){return 0;}























//252423222120191817161514131211110987654321 0'1'2'3'    14

    private void combinationGen(){



    }



        //method that computes all possible permutaions of 2^N binary combinations of N bits
//        public void Comb(int i) throws IOException {
//            int j=2;
//        while(combinations[i].length()<23){
//            String  b =combinations[i]+"0";
//            String c= combinations[i]+"1";
//            combinations[j]=b;j++;combinations[j]=c;j++;
//            i++;}
//            File f = new File("C:\\Users\\91992\\Downloads\\UBC\\combination.txt");
//            FileWriter fw= new FileWriter(f);
//
//            for(int c=0;c<j;c++){ fw.write(combinations[c] +"\n"); }
//            fw.write(i + "\t" + j );
//            fw.close();

//    }



    }




//        //method that computes decimal value from binary representation
//        public long getVal(String binary){
//        long val=0;
//        for(int i=binary.length()-1;i>=0;i--){
//        if(Integer.parseInt(String.valueOf(binary.charAt(i)))==1){
//            val+=Math.pow(2,(binary.length()-1)-i);
//        }}return val;}


