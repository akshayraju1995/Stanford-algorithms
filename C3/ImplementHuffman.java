package C3;

import C2.HashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ImplementHuffman {
    public static void main(String[] args) throws FileNotFoundException {
        File input= new File ("C:\\Users\\91992\\Downloads\\UBC\\huffman.txt");
        Scanner in= new Scanner(input);
        String [] names= new String[1000];
        String [] contains={"a","b","c","d","e","f","g","h","i","j"};                       //an array contaiing alphabets which will help in generating unique a encoding for each vertex name
        names = Make(names,contains);                                                       // fill the array with unique 3 character Strings for each of the vertex
        Vertex [] a = new Vertex[Integer.parseInt(in.next())];                              // an array to store all the vertices
        for (int i=0;i<a.length;i++)
        {a[i]=new Vertex(names[i],Integer.parseInt(in.next()));}

        Huffman h= new Huffman();
        System.out.println(h.huffmanEncodingMax(a));
        System.out.println(h.huffmanEncodingMin());


    }
//method returns all possible values of the 3 character Strings generated with given 10 alphabets
// ie 10^3 unique vertex names for 10^3 given vertices
    private static String[] Make(String[] names, String[] contains) {int counter=0;
        for(int i=0;i<contains.length;i++){for (int j=0;j<contains.length;j++){for(int k=0;k<contains.length;k++){
            names[counter]=contains[i]+contains[j]+contains[k];counter++;}}}
        return names;
    }


}
