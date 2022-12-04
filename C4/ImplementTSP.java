package C4;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.*;

public class ImplementTSP {

    /** program to implement travelling salesman problem using dynamic programmming*/
    public static void main(String[] args) throws IOException {
File input= new File("C:\\Users\\91992\\Downloads\\UBC\\tsp.txt");
Scanner in= new Scanner(input);
int size=Integer.parseInt(in.next());
Location [] cities= new Location [size];
int i=0;
while(in.hasNext()){
    cities[i]=new Location(Double.parseDouble(in.next()),Double.parseDouble(in.next()));  i++; }
//print the 25 cities with its coordinates

//for(i=0;i<25;i++){
//        System.out.println(cities[i].get_x() + "\t \t" +cities[i].get_y());}

        /**An array that stores distances from each vertex to another in an n x n size matrix*/
    Double [][] Distances = new Double[size][size];
    for(int k=0;k<size;k++){
    for(int j=0;j<size;j++){
        Distances[k][j]=Math.sqrt(Math.pow((cities[k].get_x()-cities[j].get_x()),2) +
                                            Math.pow((cities[k].get_y()-cities[j].get_y()),2));}}
//        for(i=0;i<25;i++){
//            System.out.println();
//            for(int j=0;j<25;j++){
//            System.out.print(Distances[i][j] + "   ");}}
        TSP obj= new TSP();
        //obj.Comb(0);

    }


}
