import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementMinCut {
    public static void main(String[] args) throws FileNotFoundException{
        List<Integer>edge ;
        GraphCut g = new GraphCut();
        List<List<Integer>> graph= new ArrayList<>();
        File file = new File ("C:\\Users\\91992\\Downloads\\UBC\\kargerMinCut.txt");
        Scanner in =new Scanner(file);Scanner f;
        String s= null;
    while(in.hasNextLine())
    {s=in.nextLine();
     edge= new ArrayList<>();
     f= new Scanner(s);
     while (f.hasNext()){edge.add(Integer.parseInt(f.next()));}
        graph.add(edge);}
    int size=1000;
        int [] results = new int [size];
    for (int i=0;i<size;i++){ results[i]=g.KargerMinCut(graph);}
    /**Bubble sort for one iteration to find the smallest element*/
    for(int j=0;j<size-1;j++){
        if (results[j]<results[j+1]){results[j+1]=results[j];}
    }
        System.out.println(results[size-1]);


    }













    public static void displayedge(List<Integer> a){for (int x : a){ System.out.print(x + " "); } }

    public static void displayedges(List<List<Integer>> a){
       for (List<Integer> s :a){ displayedge(s); System.out.print("\n"); }
    }
}
