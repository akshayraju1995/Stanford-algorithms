package C2;

public class Node {
  public  long value ; Node head;
    public Node(long n){value=n; head= null; }  //initalize node value with given integer n and set head node to null
    public void setHead(Node t){head= t;}     //set a given node as the head node
    public Node getHead(){return head;}       //return a head node
}
