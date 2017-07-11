public class LongestValidParenthesis{
  public int longestValidParentheses(String s){
        List<Integer> leftRecorder=new ArrayList<>();
        int left=-1;//left marked the index of <em>left+1</em> is the valid parenthesis's start index
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                leftRecorder.add(i);
            else{
                if(leftRecorder.size()==0)left=i;//refresh the mark
                else{
                    leftRecorder.remove(leftRecorder.size()-1);//this index is the index of former '('
                    if(leftRecorder.size()==0)
                        maxLen=Math.max(maxLen,i-left);
                    else
                        maxLen=Math.max(maxLen,i-leftRecorder.get(leftRecorder.size()-1));
                }
            }
        }
        return maxLen;
    }
}
