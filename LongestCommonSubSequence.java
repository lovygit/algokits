public class LongestCommonSubSequence{
  public String minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        String[][] dpStr=new String[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();i++)
            for(int j=1;j<=word2.length();j++)
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    dpStr[i][j]=(dpStr[i-1][j-1]==null? "":dpStr[i-1][j-1])+word1.charAt(i-1);
                }else if(dp[i-1][j]>=dp[i][j-1]){
                    dp[i][j]=dp[i-1][j];
                    dpStr[i][j]=(dpStr[i-1][j]==null? "":dpStr[i-1][j]);
                }else{
                    dp[i][j]=dp[i][j-1];
                    dpStr[i][j]=(dpStr[i][j-1]==null? "":dpStr[i][j-1]);
                }
        return dpStr[word1.length()][word2.length()];
    }
}
