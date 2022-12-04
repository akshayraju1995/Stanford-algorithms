package C2;
import java.io.File; import java.io.FileNotFoundException; import java.util.ArrayList; import java.util.List; import java.util.Scanner;

public class ImplementDijkstra {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\91992\\Downloads\\UBC\\dijkstraData.txt");
        Scanner readFile = new Scanner(input);DijkstraShortestPath d= new DijkstraShortestPath();
        List<List<int [] >> Data = new ArrayList();
        while (readFile.hasNextLine())
        {
            Scanner s1 = new Scanner(readFile.nextLine());
            List<int []> row= new ArrayList<>();
            int [] one = {Integer.parseInt(s1.next()),0};row.add(one);
            while(s1.hasNext())
            {String [] s =s1.next().split(",");
             int [] td= {Integer.parseInt(s[0]),Integer.parseInt(s[1])};
             row.add(td); }  Data.add(row); }
      int [][] distances=d.dijkstra(Data);
        System.out.println(distances[7][1]+","+distances[37][1]+","+distances[59][1]+","+distances[82][1]+","+distances[99][1]+","+
                distances[115][1]+","+distances[133][1]+","+distances[165][1]+","+distances[188][1]+","+distances[197][1]);

//    printDistance(distances);
    }

    public static void printDistance(int [] [] g){for (int [] x : g){
        System.out.println(x[0] +" " +x[1]);
    }}
        public static void printList(List<List<int []>> GraphEL) {
            for(List <int []> x : GraphEL){for(int[] y :x){
                System.out.print(y[0] +" "+ y[1] +" ");
            }
                System.out.println(""); }
        }
}