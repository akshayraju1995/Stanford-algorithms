package C3;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Scheduling {

    public static void main(String[] args) throws FileNotFoundException{
        File f = new File ("C:\\Users\\91992\\Downloads\\UBC\\jobs.txt");
        Scanner in = new Scanner (f);int c=0;
        Job [] input= new Job [10000];           //initialize a job array to store the jobs with their weights and lengths
         in.next();
         while(in.hasNext()){
             Job j= new Job(Integer.parseInt(in.next()),Integer.parseInt(in.next()));   //Create a new job with job weight and length
             input [c]=j;c++;   }                                                       //Store the job in the array and increment the array pointer
        System.out.println("Scheduling by difference "+differenceSchedule(input));
        System.out.println("Scheduling by ratio "+RatioSchedule(input));
    }

             public static long differenceSchedule(Job [] j){
        int [][] tab= new int[j.length][2];                                              //initialize a new array to keep tab  of the indices and the corresponding difference between job wt and job length of the repective entries in the job array
        for(int i=0;i<j.length;i++){
            tab[i][0]=i;tab[i][1]=j[i].jobwt-j[i].joblen;}
            SortRoutine s = new SortRoutine();
            tab=s.sortdiff(tab);                                                         //sort the array with difference in descending order of difference
        boolean check= true;
        for(int i=0;i<tab.length-1;i++){check=check&&(tab[i][1]<=tab[i+1][1]);}
       int i=0;int sp=i+1;
                 Job []sorted=new Job[j.length];
                  for(int k=0;k<sorted.length;k++)
                  {sorted[k]=j[tab[k][0]];}
               while (sp<j.length)                                        //break ties where difference is the same
               {while (tab[sp][1]==tab[i][1])
                    {sp++;
                    if(sp>=j.length){break;}}
               if((sp-1)!=i){
                   for(int m=i;m<sp-1;m++){                               //do a bubble sort to break ties
               for(int c=i;c<(sp-1);c++ ){
                if(sorted[c].jobwt<sorted[c+1].jobwt){
                    Job b =sorted[c];sorted[c]=sorted[c+1];sorted[c+1]=b; }          //swap if next job wt is larger than previous}
               }}}
               i=sp;sp++;
               }
                long sum=0;int ct=0;
                       for(int l=0;l<sorted.length;l++)                             //compute  the weighted sum
                        {ct+=(sorted[l].joblen);
                        sum+=(sorted[l].jobwt*ct);}
                       return sum;  }

    public static long RatioSchedule(Job [] j) {
        long sum=0;
        float [][] tab = new float[j.length][2];                                              //initialize a new array to keep tab  of the indices and the corresponding difference between job wt and job length of the repective entries in the job array
        for (int i = 0; i < j.length; i++) {
            tab[i][0] = i;
            tab[i][1] = (float)j[i].jobwt / (float)j[i].joblen;
        }
        SortRoutine s = new SortRoutine();
        tab = s.sortRatio(tab);
        Job []sorted=new Job[j.length];
        for(int k=0;k<sorted.length;k++)
        {sorted[k]=j[(int) tab[k][0]];}
        int ct=0;
        for(int l=0;l<sorted.length;l++)                             //compute  the weighted sum
        {ct+=(sorted[l].joblen);
            sum+=(sorted[l].jobwt*ct);}
        return sum;
    }





















        private static void displayJobs(Job [] a){
        for (Job i: a ){ System.out.println(i.jobwt + " "+ i.joblen);}
    System.out.println(a.length);
}

}
