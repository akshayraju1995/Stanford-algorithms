import java.util.ArrayList;

public class ClosestPair  {
int mode;
double [][]cp;double[][]xsort,ysort,cpl,cpr;
double distance,distanceDC,distanceright;

public double[][] NaiveClosestPair(double[][] a){cp= new double[2][2];
    distance=Math.sqrt(Math.pow((a[1][0]-a[0][0]),2)+(Math.pow((a[1][1]-a[0][1]),2)));
    cp[0]=a[0];cp[1]=a[1];
    for (int i=1;i<=a.length-1;i++ ){for(int j=i+1;j<a.length;j++){
            double tempd= Math.sqrt(Math.pow((a[j][0]-a[i][0]),2)+(Math.pow((a[j][1]-a[i][1]),2)));
           if (tempd<=distance){distance=tempd; cp[0]=a[j];cp[1]=a[i];}
        } }return cp;}


public double[][] DivideandConquerClosestPair(double[][] xsort){
    if(xsort.length<=4){double [][]dist=NaiveClosestPair(xsort);return dist;}

    int m=xsort.length/2; double [][]L=new double[m][2];double [][]R=new double [xsort.length-m][2];
    L=fillarray(L,xsort,0,m); R=fillarray(R,xsort,m,xsort.length);
    double [][]ld=DivideandConquerClosestPair(L);
    double [][]rd=DivideandConquerClosestPair(R);
    double [][]currentpos=findcurrenthigh(ld,rd);
    double [][]splitzonel=makesplitzonel(L,ld,rd);
    double [][]splitzoner=makesplitzoner(L,R,ld,rd);


    return splitpairDistance(splitzonel,splitzoner,currentpos);

}

    public double[][] splitpairDistance(double[][] splitzonel, double[][] splitzoner, double[][] currentpos) {
    double d= dist(currentpos);
   if(splitzonel.length==1 && splitzoner.length==0){return currentpos;}splitzoner=mergesort0forx1fory(splitzoner,1);
   for(int i=0;i<splitzonel.length;i++){int [] range=calculaterange(splitzonel[i][1],d,splitzoner);for(int j=range[0];j<range[1]+1;j++){if(
          Math.sqrt (Math.pow((splitzonel[i][0]-splitzoner[j][0]),2)+Math.pow((splitzonel[i][1]-splitzoner[j][1]),2))<d)
   {currentpos[0]=splitzonel[i];currentpos[1]=splitzoner[j];d=dist(currentpos) ;}
   }   }
return currentpos;}






    public int[] calculaterange(double v, double d, double[][] splitzoner) {int c=0;int [] range=new int[2];int i=0;
    while(c==0 && i<splitzoner.length){ if(Math.pow((splitzoner[i][1]-v),2)<=(d*d)){range[0]=i;c=1;}i++; }range[1]=range[0];
    while(c==1 && i<splitzoner.length){ if(Math.pow((splitzoner[i][1]-v),2)>(d*d)){c=0;}else{range[1]=i;}i++;}return range;    }




    public double[][] findcurrenthigh(double[][] ld, double[][] rd) {if (dist(ld)<dist(rd)){return ld;}return rd; }

    public double[][] makesplitzonel(double[][] l, double[][] ld, double[][] rd) {
    double delta=Math.max(dist(ld),dist(rd));
        ArrayList<double[]> splitempl=new ArrayList<>();
        double xref=l[l.length-1][0];for(int i=0 ;i<l.length-1;i++){if((xref-l[i][0])<=delta){splitempl.add(l[i]);}}splitempl.add(l[l.length-1]);
        double[][]left=new double [splitempl.size()][2];for(int j=0;j<left.length;j++){left[j]=splitempl.get(j);}return left;
}

public double[][] makesplitzoner(double[][] l, double[][] r, double[][] ld, double[][] rd) {
    double delta=Math.max(dist(ld),dist(rd));
     ArrayList<double[]> splitempr=new ArrayList<>();    double xref=l[l.length-1][0];
     for(int i=0 ;i<l.length;i++){if((-xref+r[i][0])<=delta){splitempr.add(r[i]);}}
    double[][]right=new double [splitempr.size()][2];for(int j=0;j<right.length;j++){right[j]=splitempr.get(j);}return right;
}


    public double dist(double [][]a){return Math.sqrt(Math.pow((a[0][0]-a[1][0]),2)+Math.pow((a[0][1]-a[1][1]),2));}



    public void printarray2d(double[][]a){for ( double[]x :a){
        System.out.println(x[0] +" "+ x[1]);
    }}













    public double[][] mergesort0forx1fory(double[][] a, int mode) {
        this.mode=mode;
        if (a.length==1){return a;}
        else{
            int m = a.length/2;
            double [][] al=new double[m][2];
            double [][] ah=new double [a.length-m][2];
            al=fillarray(al,a,0,m);
            ah=fillarray(ah,a,m,a.length);
            return combineArrays(mergesort0forx1fory(al,mode),mergesort0forx1fory(ah,mode));}
    }

    public double[][] fillarray(double [][] tbf ,double [][] big, int si, int ei ){
        int j=0;
        for(int i = si ; i<ei ; i++){tbf[j]=big[i];j++; } return tbf; }

    public  double[][] combineArrays(double[][] al, double[][] ah) {
        double [][] comb=new double[ah.length + al.length][2];
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
                if (ah[c_ah][mode] < al[c_al][mode]) {
                    comb[c_comb] = ah[c_ah];
                    c_comb++; c_ah++;}
                else {
                    comb[c_comb] = al[c_al];
                    c_comb++; c_al++;} } }
        return comb;
    }



}
