public class Inversions {
    public long count=0;

    public long naiveInversion(int[] a){
        for (int i=0 ; i<a.length-1; i++){
            for (int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){count ++;} } }    return count;}

    public void printarray(int []a){ for(int x :a ){ System.out.println(x);} }

    public long InversionsRecursive(int[] a) {count=0;
    mergesort(a);    return count;}

    public int[] mergesort(int[] a) {
        if (a.length==1){return a;}
        else{
            int m = a.length/2;
            int [] al=new int[m];
            int [] ah=new int [a.length-m];
            al=fillarray(al,a,0,m);
            ah=fillarray(ah,a,m,a.length);
            return combineArrays(mergesort(al),mergesort(ah));}
    }

    public int[] fillarray(int [] tbf ,int [] big, int si, int ei ){
        int j=0;
        for(int i = si ; i<ei ; i++){tbf[j]=big[i];j++; } return tbf; }

    public  int[] combineArrays(int[] al, int[] ah) {
        int [] comb=new int[ah.length+ al.length];
            int c_al=0; int c_ah=0; int c_comb=0;
            while(c_comb!=comb.length) {
                if (c_al == (al.length) || c_ah == (ah.length)) {
                    if(c_al==al.length){
                        while(c_ah!=ah.length){
                            comb[c_comb]=ah[c_ah];
                            c_comb++;c_ah++; }
                        c_comb=comb.length;}
                    else{
                        while(c_al!=al.length){
                            comb[c_comb]=al[c_al];
                            c_comb++;c_al++;  }
                        c_comb=comb.length;} }

                else {
                    if (ah[c_ah] < al[c_al]) {
                        comb[c_comb] = ah[c_ah];count+=al.length-c_al;
                        c_comb++; c_ah++;}
                    else {
                        comb[c_comb] = al[c_al];
                        c_comb++; c_al++;} } }
        return comb;
    }

    public int[] addele(int[] al, int[] ah) {
        int [] added= new int[al.length+ah.length];
        for(int i=0;i<al.length;i++){
            added[i]=al[i]; }
        for(int j=0;j<ah.length;j++){
            added[j+al.length]=ah[j];
        }return added;}

}