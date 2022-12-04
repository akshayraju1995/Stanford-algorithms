package C3;

public class Huffman {
    String [][] encoding;
    HeapVertex h;
    private static String [] value={"a","b","c","d","e","f","g","h","i","j"};           //an array where an alphabets value is ithe index its stored in .For eg "b" has the value 1 as it is at index 1
                                                                                        //used for quick refencing for where a vertex's huffman code is to be stored
    public int huffmanEncodingMax(Vertex[] a) {
        encoding =new String [a.length][2];
        for(int i=0;i<a.length;i++){encoding[i][0]=a[i].name;}                          //initiliaize an array to store the huffman encoding for all the given vertices
         h= new HeapVertex(a.length);                                                   //initialize a heap to store all the vertices with the key being their frequency
         for(Vertex j: a){h.insert(j);}                                                 //insert all the vertices in the heap
        huffmanEncoding();                                                              // perform huffman encoding of the given vertices
        int size=0;
        for (String[] x: encoding )
        {if (x[1].length()>size){size=x[1].length();}}
        return size; }                                                                  //return size of highest encoding

    public int huffmanEncodingMin() {
        int size=encoding[0][1].length();
        for (String[] x: encoding )
        {if (x[1].length()<size){size=x[1].length();}}
        return size; }                                                                 //return size of lowest encoding


        private void huffmanEncoding() {
        //Base case : if 2 vertices are remaining ,split and encode
        if(h.getSize()==2){  huffmanBreakdown("0",h.extractMin().name);huffmanBreakdown("1",h.extractMin().name);   }
        else{
            Vertex min1 =h.extractMin();  Vertex min2 =h.extractMin();          //extract from heap 2 vertices which have lowest frequency
            int search=0;int i=0;String s =min1.name+min2.name;int j=i;
            while(i<s.length()){                                               //search for the highest number in the combined strings
                if(Character.isDigit(s.charAt(i))){
                    j=i;while(Character.isDigit(s.charAt(i))){i++;}
                    int temp= Integer.parseInt(s,j,i,10);
                    if(temp>search){search=temp;} }
            else{i++;}}
                String name=min1.name+Integer.toString(search+1)+min2.name; //add 1 to the highest number searched in the strings and merge strings and their frequenices
                Vertex add= new Vertex(name,min1.size+min2.size);         // to form a new meta vertex.
                h.insert(add);                                                 // reinsert the meta vertex into the heap
                huffmanEncoding();                                             //using numbers while merging 2 vertices help to keeo track while splittnig
                                                                                //as it is easy to split vertices in the string where the number is the highest,
                                                                                //meaning nodes have merged most recently at that point
        } }

        private void huffmanBreakdown(String code,String sequence){
        boolean flag=true;
        for(int f=0;f<sequence.length();f++){flag&=(!Character.isDigit(sequence.charAt(f)));}  //check if any numbers are there in the given string ,if not it is lone vertex hence no further splitting is required
        if (flag==true){
            int index=Search(sequence);
            encoding[index][1]=code;}                       //add the huffman code to the encoding array for the lone vertex
        else{
            int search=0;int i=0,j=i;
            while(i<sequence.length()){
                if(Character.isDigit(sequence.charAt(i))){
                    j=i;while(Character.isDigit(sequence.charAt(i))){i++;}   //search for the highest number in the combined strings
                    int temp= Integer.parseInt(sequence,j,i,10);
                    if(temp>search){search=temp;} }
                else{i++;}}
                String [] s = sequence.split(Integer.toString(search),0);       //split the meta vertice into two at the highest number
                huffmanBreakdown(code+"0",s[0]);                                //recurse on both the subvertices until it is a lone vertex
                huffmanBreakdown(code+"1",s[1]) ;
}
        }


        //method returns the index of a sequence in the encoding array
    private int Search(String sequence) {int [] val=new int[3];int j=0;
    while(j<val.length)
    {for(int i=0;i<value.length;i++){if (sequence.charAt(j)==value[i].charAt(0)){val[j]=i;j++;break;}}
    } return (val[0]*100)+(val[1]*10)+val[2];}
}
