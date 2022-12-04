package C2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TargetValuesHashing {
    /** Program to calculate target values between the interval [-10000,10000] (inclusive)
     * such that x+y=t and x!=y and x ,y are elements of input
     *implementation using a hash table with chaining */
    public int CalulateTargetValues(BigInteger[] input){
        HashTable H= new HashTable(input.length);                 //initailize the hash table
      List<Long> z= new ArrayList<>();
        for(BigInteger x: input){                                 //insert the input values into the hash table
            if (H.lookup(x.longValue())==false){H.insert(x); z.add(x.longValue());} }
        int k=0;
        int c=-10000;

        while(c<10001){
            int j=0;
            while(j<z.size()){
                if (H.lookup(c-z.get(j))){k++;j=z.size();}
                else{j++;}
            }c++; }

            return k;}}
