//package C2;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ImplementCC_DFS {
//
//    public static void main(String[] args) throws FileNotFoundException {
//        File SCC= new File("C:\\Users\\91992\\Downloads\\UBC\\SCC.txt");
//        Scanner in= new Scanner(SCC); List<Integer> l1;List <List <Integer>>Edges= new ArrayList<>();List<List <Integer>> Graph= new ArrayList<>();
//        DFSconnectedComp f=new DFSconnectedComp();
//        while (in.hasNextLine())
//        {Scanner in1=new Scanner(in.nextLine()); l1= new ArrayList<>();
//            while(in1.hasNext()){
//              l1.add(Integer.parseInt(in1.next()));
//            }Edges.add(l1); }
//        //System.out.println(f.sort2ndList(f.makeFVGraph(f.makeAdjacencyList(Edges),f.DFSFirstPass(f.makeRevGraph(Edges)))).length);
//
////        int [] g= f.DFSFirstPass(f.makeRevGraph(Edges));
////        int j=0;
////        while(j < g.length-1){if (g[j] > g[j+1]){g[j+1]=g[j];}j++;}
////        System.out.println(g[g.length-1]);
//    }
//
//
//
//    public static void PrintArray(int [] a){for (int x:a ){System.out.println(x);}}
//
//
//    public static void displayedge(List<Integer> a){for (int x : a){ System.out.print(x + " "); } }
//
//    public static void displayedges(List<List<Integer>> a){
//        for (List<Integer> s :a){ displayedge(s); System.out.print("\n"); }}}
//
//
