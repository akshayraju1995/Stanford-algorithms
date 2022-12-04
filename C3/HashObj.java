package C3;

public class HashObj {
    //object which is stored in the hash table for the large knapsack problem
    public long i,j ;public long value;public HashObj root=null;
    public HashObj(long i ,long j,long value){this.i=i;this.j=j;this.value=value;}
    public void setRoot(HashObj root){this.root=root;}
}
