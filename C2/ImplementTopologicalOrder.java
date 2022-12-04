package C2;

import java.util.ArrayList;
import java.util.List;

public class ImplementTopologicalOrder {
    public static void main(String[] args) {
       List<List<Integer>> Graph= new ArrayList<>();
       DFStopologicalOrder d= new DFStopologicalOrder();
//        List<Integer> n1=new ArrayList<>();n1.add(1);n1.add(2);n1.add(3);
//        List<Integer> n2=new ArrayList<>();n2.add(2);n2.add(4);
//        List<Integer> n3=new ArrayList<>();n3.add(3);n3.add(4);
//        List<Integer> n4=new ArrayList<>();n4.add(4);
//        List<Integer> n5=new ArrayList<>();n5.add(5);n5.add(4);
//       Graph.add(n1);Graph.add(n2);Graph.add(n3);Graph.add(n4);Graph.add(n5);

        List<Integer> n1=new ArrayList<>();n1.add(1);n1.add(3);
        List<Integer> n2=new ArrayList<>();n2.add(2);n2.add(1);
        List<Integer> n3=new ArrayList<>();n3.add(3);n3.add(2);
        List<Integer> n4=new ArrayList<>();n4.add(4);n4.add(2);n4.add(6);
        List<Integer> n5=new ArrayList<>();n5.add(5);n5.add(4);
        List<Integer> n6=new ArrayList<>();n6.add(6);n6.add(5);
       Graph.add(n1);Graph.add(n2);Graph.add(n3);Graph.add(n4);Graph.add(n5);Graph.add(n6);



       printOrdering(d.topologicalsort(Graph));
        System.out.println(d.topologicalsort(Graph).size());

    }

    private static void printOrdering(List<int[]> order) {
      for (int i=0;i<order.size();i++)
      { System.out.println(order.get(i)[0]+ " " + order.get(i)[1] ); }  }


}
