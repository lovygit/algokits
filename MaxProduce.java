public class MaxProduct{
  //we select k number from data array,and each number's index absolute difference is not bigger than d
  public long maxProduct(int[] data,int k,int d){
        long[][][] dp=new long[data.length+1][k+1][2];
        dp[0][0][0]=dp[0][0][1]=1;

        long r=data[0];
        for(int i=1;i<=data.length;i++){
            dp[i][1][0]=dp[i][1][1]=data[i-1];
            for(int j=2;j<=k;j++)
                for(int x=i-1;x>=Math.max(1,i-d);x--){
                    long maxVal=Math.max(data[i-1]*dp[x][j-1][0],data[i-1]*dp[x][j-1][1]);
                    long minVal=Math.min(data[i-1]*dp[x][j-1][0],data[i-1]*dp[x][j-1][1]);
                    dp[i][j][0]=Math.max(dp[i][j][0],maxVal);
                    dp[i][j][1]=Math.min(dp[i][j][1],minVal);
                }
            /*
            for(int j=2;j<=kk;++j){
            for(int k=i-1;k>=max(i-d,1);--k){
                f[i][j][0]=max(f[i][j][0],max(f[k][j-1][0]*a[i],f[k][j-1][1]*a[i]));
                f[i][j][1]=min(f[i][j][1],min(f[k][j-1][0]*a[i],f[k][j-1][1]*a[i]));
            }
             */
            r=Math.max(r,Math.max(dp[i][k][0],dp[i][k][1]));
        }

        return r;
    }
