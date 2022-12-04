package C2;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    List<Integer> que;
    public Queue(){ que= new ArrayList<>();}
    public boolean isEmpty(){if (que.size()==0){return true;}else{return false;} }
    public void enque(int a){que.add(a);}
    public int dequeue(){int r= que.get(0);
    que.remove(0);return r;}
    public  int size(){return que.size();}

}
