package C3;

public class KnapsackLarge {

    /** A large knapsack problem with knapsack capacity of 2000000 and 2000 items
     * solving using dynamic programming . Recurrence relation is A[i,j]=max {A[i-1,j-wi]+vi,A[i-1,j]} */
static Hash ht;

public long knapsack(Item [] a ,int capacity)
{ht = new Hash(a.length*10);                                                             //instantiate the hash table
knapsackLong(a,a.length-1,capacity-1);                                                   //call the recursive procedure to find result

return ht.returnval(a.length-1,capacity-1);                                              //return result
}



public void knapsackLong(Item [] a ,int i ,long j)                                              //items are of the form - item.weight ,item.value
{

        if(i==0){if (j<a[i].weight){ht.insert(new HashObj(0,j,0));}                    //if only one item is considered and if its weight is > capacity value of knapsack is 0,
                  else{ht.insert(new HashObj(0,j-a[0].weight,a[0].value));} }              // else it is value of 1st item
        else{
             if (j<a[i].weight){if(ht.exists(i-1,j)){ht.insert(new HashObj(i,j,ht.returnval(i-1,j)));}            //if more than 1 item is considered and item weight > knapsack capacity ,recurse on i-1 items for same capcity of knapsack
                                else{knapsackLong(a,i-1,j);ht.insert(new HashObj(i,j,ht.returnval(i-1,j)));}    }
            else{
              boolean exists1=ht.exists(i-1,(j-a[i].weight));                                  //check if values to be recursed on are already hashed
              boolean exists2=ht.exists(i-1,j);
              if(exists1&&exists2){
                  ht.insert(new HashObj(i,j,Math.max(ht.returnval(i-1,j-a[i].weight)+a[i].value,ht.returnval(i-1,j))));}          //if both cases are hashed , insert into hash table object for i and j and value=max of 1 and 2
              else if (exists1){knapsackLong(a,i-1,j);
                  ht.insert(new HashObj(i,j,Math.max(ht.returnval(i-1,j-a[i].weight)+a[i].value,ht.returnval(i-1,j))));}          //if 1 is hashed , recurse on case 2 to get value for case 2 and insert into hash table object for i and j and value=max of 1 and 2
              else if(exists2){knapsackLong(a,i-1,j-a[i].weight);
                  ht.insert(new HashObj(i,j,Math.max(ht.returnval(i-1,j-a[i].weight)+a[i].value,ht.returnval(i-1,j))));}          //if 2 is hashed , recurse on case 1 to get value for case 1 and insert into hash table object for i and j and value=max of 1 and 2
              else{knapsackLong(a,i-1,j-a[i].weight);knapsackLong(a,i-1,j);
                  ht.insert(new HashObj(i,j,Math.max(ht.returnval(i-1,j-a[i].weight)+a[i].value,ht.returnval(i-1,j))));}}         // recurse on case 1 and 2 to get value for case 1 and 2 and insert into hash table object for i and j and value=max of 1 and 2
        }}


  }



