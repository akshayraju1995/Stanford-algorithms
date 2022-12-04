package C2;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    /**A stack implementation for LIFO(last in First out) implementation of verices off a Graph for DFS */
        List<Integer> stack;
        public Stack(){stack= new ArrayList<>();}

        public void push(int i){stack.add(i);}

        public int pop(){
            int r = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return r;}
        public boolean contains(int i ){for (int j=0;j<stack.size();j++){if(i==stack.get(j)){return true;}}return false;}
        public boolean isEmpty(){return (stack.size()==0);}

        public int size(){return stack.size();}

}
