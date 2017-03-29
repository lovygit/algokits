public class InOutStack{
  private static <T> void inAndOutSeq(T[] seq, int i, List<T> stack,T[] output,int index,List<List<T>> outputSeqs){
       if(i<seq.length){
           stack.add(seq[i]);
           if(i+1==seq.length){
               while(stack.size()>0){
                   output[index++]=stack.remove(stack.size()-1);
               }
               outputSeqs.add(new ArrayList<T>(Arrays.asList(output)));
           }else{

               inAndOutSeq(seq,i+1,new ArrayList<T>(stack),output,index,outputSeqs);
               while(stack.size()>0) {
                   output[index++] = stack.remove(stack.size()-1);
                   inAndOutSeq(seq, i + 1, new ArrayList<T>(stack), output, index, outputSeqs);
               }
           }
       }
    }
    private static void main(String[] args){
        Integer[] seq={1,2,3};
        List<Integer> stack=new ArrayList<>();
        Integer[] output=new Integer[seq.length];
        List<List<Integer>> outputSeqs=new ArrayList<>();
        inAndOutSeq(seq,0,stack,output,0,outputSeqs);
        for(List<Integer> seqItem:outputSeqs){
            System.out.println(seqItem);
        }
    }
}
