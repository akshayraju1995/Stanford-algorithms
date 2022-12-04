import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTruthInput {
    public static void main(String[] args) {
        displayedges(truth_values(13));

    }

    static Random r = new Random();

    private static List<List<Integer>> truth_values(int n) {
        List<List<Integer>> mega = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b;
        for (int i = 0; i < n; i++) {
            a.add(r.nextInt(2));}
        mega.add(a);
        while (mega.size() != Math.pow(2,n)) {b = new ArrayList<>();
            for (int i = 0; i < n; i++) { b.add(r.nextInt(2));}
            if (!mega.contains(b)) { mega.add(b); }}
        return mega;}


    public static void displayedge(List<Integer> a) {
        for (int x : a) {
            System.out.print(x + " "); }}

    public static void displayedges(List<List<Integer>> a) {
        for (List<Integer> s : a) { displayedge(s);
            System.out.print("\n"); } }
}