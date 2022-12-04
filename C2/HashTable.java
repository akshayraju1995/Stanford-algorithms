package C2;

import java.math.BigInteger;
import java.util.Random;

import C2.Node;
/**Hash table implementation with chaining*/
public class HashTable {
    int a1, a2;                                     //variables that will be used in the hash function a1, a2 <
    public int n, m;                                  //n=size of hash table which is a prime number larger to take mod of a1*x+a2*x1 mod n
    long h;                                     //value of hash function
    long p2, p1;
    Node[] HashT;

    public HashTable(int size) {
        int s = size / 10;
        BigInteger b = new BigInteger(String.valueOf(s));
        n = b.nextProbablePrime().intValue();                //set n to a prime larger than m to reduce collision probability
        HashT = new Node[n];                                 //initialize hash table
        Random r = new Random();
        a1 = Math.abs(r.nextInt(n));                        //intializing a1 and a2 variables used in the hash function at random
        a2 = Math.abs(r.nextInt(n));
    }

    /** hash table primitives*/
    public void insert(BigInteger a) {
        if (lookup(a.longValue()) == false) {
            p2 = Math.abs(a.longValue() % 100000);
            p1 = (Math.abs(a.longValue()) - p2) / 100000;
            Node N = new Node(a.longValue());
            h = ((a1 * p1) + (a2 * p2)) % n;                //computes bucket to be placed in
            if (HashT[(int) h]==(null)) {    //if there is'nt any existing chains at the computed array location ,
                HashT[(int) h] = N;
            }            //insert the node as the first node
            else {
                Node temp;                      //if there is an existing chain of nodes at an array location,
                temp = HashT[(int) h];             //attach new node at the beginnig of the chain
                N.setHead(temp);
                HashT[(int) h] = N;
            } } }

    public boolean lookup(long key) {
        BigInteger KEY = new BigInteger(String.valueOf(key));
        p2 = Math.abs(KEY.longValue() % 100000);
        p1 = (Math.abs(KEY.longValue()) - p2) / 100000;
        h = ((a1 * p1) + (a2 * p2)) % n;
        if (HashT[(int) h]==( null)) {
            return false;}
        else {
            Node current= HashT[(int) h];
            if (current.value==key){return true;}
            while (current.getHead()!=null){
            current = current.getHead();
            if(current.value==key){return true;} }
            return false; } }

}
