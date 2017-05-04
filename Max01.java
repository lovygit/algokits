public class Max01{
  public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        
        for(int i=0;i<strs.length;i++){
            int count0=0;
            int count1=0;
            for(int j=0;j<strs[i].length();j++)
                if(strs[i].charAt(j)=='0')
                count0++;
                else
                count1++;
            
            if(count0>m||count1>n)
            continue;
            
            for(int x=m;x>=count0;x--){
                for(int y=n;y>=count1;y--){
                    dp[x][y]=Math.max(dp[x][y],dp[x-count0][y-count1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
