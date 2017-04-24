public class LongestReapter{
  public int characterReplacement(String s, int k) {
        int start=0,end=0;
        int maxLen=0;
        int span=0;
        int[] count=new int[26];
        for(;end<s.length();end++){
            span=Math.max(span,++count[s.charAt(end)-'A']);
            if(end-start+1-span>k){
                count[s.charAt(start)-'A']--;
                start++;
            }else{
                maxLen=Math.max(maxLen,end-start+1);
            }
            System.out.println("start "+start+", end "+end+", span "+span+", maxLen "+maxLen);
        }

        return maxLen;
    }
}
