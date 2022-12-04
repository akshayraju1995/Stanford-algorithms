//package C2;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.w3c.dom.ls.LSOutput;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestDFSconnected {
//
//    @Test
//    public void TestmakeRevG(){
//        DFSconnectedComp d= new DFSconnectedComp();
//        List<List<Integer>> graph= new ArrayList<>();
//        List<Integer> toadd;
//        for (int i=0; i<5;i++)
//        {  toadd= new ArrayList<>(); toadd.add(i);toadd.add(i+1);
//        graph.add(toadd);}toadd= new ArrayList<>();toadd.add(0);toadd.add(4);graph.add(toadd);printDG(graph);
//        System.out.println(" ");
//       // Assert.assertEquals(graph.size(),5);
//        //Assert.assertEquals(graph.get(0).size(),2);
//        //System.out.println(d.makeRevGraph(graph).size());
//       // printDG(d.makeRevGraph(graph));
//    }
//    @Test
////    public void TestDFSfirstPass()
////    {DFSconnectedComp d= new DFSconnectedComp();
////        List<List<Integer>> Graph = Setup();
////      //  List<int []> g=d.DFSFirstPass(Graph);
////        for(int [] x : g){System.out.println(x[0]+ " " +x[1]);}
////    }
//
//    public List<List<Integer>> Setup() {
//        List<List<Integer>> Graph= new ArrayList<>();
//        List<Integer> n1=new ArrayList<>(); n1.add(1); n1.add(2);
//        List<Integer> n2=new ArrayList<>(); n2.add(2); n2.add(3);
//        List<Integer> n3=new ArrayList<>();n3.add(3); n3.add(1);
//        List<Integer> n4=new ArrayList<>(); n4.add(4); n4.add(5);
//        List<Integer> n8= new ArrayList<>();n8.add(2);n8.add(4);
//        List<Integer> n5=new ArrayList<>();  n5.add(5);   n5.add(6);
//        List<Integer> n6=new ArrayList<>();  n6.add(6);n6.add(4);
//        Graph.add(n1); Graph.add(n2);Graph.add(n3);  Graph.add(n4); Graph.add(n5);Graph.add(n6);Graph.add(n8);
//        return Graph;
//    }
//
//
//
//    @Test
//    public void TestmakeFVGraph()
//    {
//        DFSconnectedComp d= new DFSconnectedComp();
//        DFSconnectedComp g= new DFSconnectedComp();
//        List<List<Integer>> Graph= new ArrayList<>();
//        List<Integer> n1=new ArrayList<>(); n1.add(1); n1.add(2);
//        List<Integer> n2=new ArrayList<>(); n2.add(2); n2.add(3);n2.add(4);
//        List<Integer> n3=new ArrayList<>();n3.add(3); n3.add(1);
//        List<Integer> n4=new ArrayList<>(); n4.add(4); n4.add(5);
//        List<Integer> n5=new ArrayList<>();  n5.add(5);   n5.add(6);
//        List<Integer> n6=new ArrayList<>();  n6.add(6);n6.add(4);
//        Graph.add(n1); Graph.add(n2);Graph.add(n3);  Graph.add(n4); Graph.add(n5);Graph.add(n6);
//        List<List<Integer>> graph = Setup();
//       // printDG(g.makeFVGraph(Graph,d.DFSFirstPass(d.makeRevGraph(graph) )));
//        //  printDG(d.makeFVGraph(Graph,d.DFSFirstPass(d.makeRevGraph(graph))));
//    }
//    //@Test
////    public void TestSCCdirected()
////    { List<List<Integer>> Graph = Setup();
////    DFSconnectedComp f= new DFSconnectedComp();
////
////    printDG(f.(Graph));}
//
//    @Test
//    public void TestArrayList(){
//      ArrayList<Integer> [] a1= new ArrayList[10];
//        System.out.println(a1.length);
//    }
//
//
//
//public void printDGFv(List<int []> Graph)
//{for (int[ ] x: Graph){
//    System.out.println(x[0]+" "+x[1]);}}
//
//
//    public void printDG(List<List<Integer>> graph){
//        for (List<Integer> x : graph)
//        { for (int y: x){System.out.print(y);}
//            System.out.println(" "); } }
//
//}
