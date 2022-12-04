package C3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ImplementPrimMST {
    public static void main(String[] args) throws FileNotFoundException{
        File input= new File ("C:\\Users\\91992\\Downloads\\UBC\\edges.txt");
        Scanner in= new Scanner (input);
        Edge [] adjacencyList= new Edge[501];
        in.nextLine();int k=0;
        while (in.hasNextLine()){
           int i= Integer.parseInt(in.next());
           int i1=Integer.parseInt(in.next());
           int cost=Integer.parseInt(in.next());
            Edge e = new Edge(i1,cost);
            Edge e1= new Edge(i,cost);
            if(e!=null){
            if(adjacencyList[i]!=null){
               Edge current= adjacencyList[i];boolean inserted=false;
                while (inserted==false&&current!=null){
                    if(current.head==null){inserted=true;current.head=e;}
                    else{current = current.head;} }
            }else{adjacencyList[i]=e;}}
        if(e1!=null){
            if(adjacencyList[i1]!=null){
                Edge current1= adjacencyList[i1];boolean inserted=false;
                while (inserted==false&&current1!=null){
                    if(current1.head==null){inserted=true;current1.head=e1;}
                    else{current1 = current1.head;} }
            }else{adjacencyList[i1]=e1;}
        }k++;}
        PrimMST p= new PrimMST();

        System.out.println(p.MST(adjacencyList));


        }

}
