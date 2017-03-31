public class SplitString2PalindromesCombination{
   private List<String> currentList=new ArrayList<>();
    private List<List<String>> comb=new ArrayList<>();
    
    private boolean isPalindromic(String s,int left,int right){
        if(left==right)
        return true;
        
        int len=left+right+1;
        int m,n;
        if(len%2==0){
            m=len/2-1;
            n=m+1;
        }else{
            m=len/2-1;
            n=m+2;
        }
        while(m>=left){
            if(s.charAt(m)!=s.charAt(n))
            return false;
            m--;
            n++;
        }
        return true;
    }
    
    private void backTrace(String s,int depth){
        if(currentList.size()>0&&depth>=s.length()){//it means that we can't go deeplier
            List<String> newList=new ArrayList<>(currentList);
            comb.add(newList);
        }else{
            for(int i=depth;i<s.length();i++){
                if(isPalindromic(s,depth,i)){
                    currentList.add(s.substring(depth,i+1));
                    backTrace(s,i+1);
                    currentList.remove(currentList.size()-1);
                }
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        backTrace(s,0);
        return comb;
    }
}
