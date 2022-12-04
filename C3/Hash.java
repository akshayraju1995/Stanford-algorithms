package C3;

public class Hash {
    /**a hash table implementation with chaining for the Large knapsack problem */
    public HashObj [] table;int size;
    public Hash(int size){table= new HashObj[size];this.size=size;}
    int a= 3;int b =7;                                                  //2 constants for the hash functions

    public void insert(HashObj a){
        long key=(a.i*this.a)+(a.j*b) ;                                  //compute the key
        key=key%(size-1);
        if(table[(int)key]==null){table[(int)key]=a;}                  //if no other object present at the location ,insert as is
        else {HashObj current=table[(int)key];                         //else traverse the root pointer until null and then insert
             while(current.root!=null){
             current=current.root;
            }current.root=a;  }

    }
    public boolean exists(long i,long j){
        if(j<0){return false;}
        else{
        long key=(i*a )+(j*b);                                              //compute key for positive values of j and i
        key=key%(size-1);
        HashObj current = table[(int)key];
        while(current!=null)
        {if (current.i==i&&current.j==j){return true;}                       // if object found ,return true
        current=current.root;}                                              //if root is reached ,return false
        return false; }
}

    public long returnval(long i,long j){
        long value=0;
        long key=(i*a )+(j*b);                                              //compute key
        key=key%(size-1);
        HashObj current = table[(int)key];
        while(current!=null)
        {if (current.i==i&&current.j==j){value= current.value;}             //return value of the object
            current=current.root;}
return value;
    }

}
