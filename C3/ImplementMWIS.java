package C3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class ImplementMWIS {
    public static void main(String[] args) throws FileNotFoundException {
        File a = new File ("C:\\Users\\91992\\Downloads\\UBC\\mwis.txt");
        Scanner in= new Scanner(a);
        int [] pathGraph_array= new int[Integer.parseInt(in.next())+1];
        for(int i=1;i<pathGraph_array.length;i++){
            pathGraph_array[i]=Integer.parseInt(in.next()); }
MWIS m= new MWIS();
List<Integer>v=m.mwis(pathGraph_array);
for(int i=v.size()-1;i>=0;i--){
    System.out.println(v.get(i));}

    }
}
