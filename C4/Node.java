package C4;
//Node for a tree
public class Node {
    String parent;
    String name;
    int level;
    Node [] chidren;
    public Node (int name ,Node parent){
        this.parent=parent.parent+","+parent.name;
    this.name=Integer.toString(name);
    this.level=parent.level+1;
    chidren=null;
        if(level>25)
        {chidren= new Node[25-level];
          int [] children=new int [25];for(int i=0;i<25;i++){children[i]=-1;}int k=0;
            int i=0;
             while(i<this.parent.length()){
              String [] temp=new String[2]; temp[2]="-1";
               temp[1]=String.valueOf(this.parent.charAt(i));i++;
                 if (String.valueOf(this.parent.charAt(i))!=","){
                  temp[2]=String.valueOf(this.parent.charAt(i));i++;
                   children[k]=Integer.parseInt(temp[1]+temp[2]);k++; }
                    else{children[k]=Integer.parseInt(temp[1]);k++;} }

        }


    }
}
