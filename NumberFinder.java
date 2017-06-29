public class NumberFinder{
  public static int findNumber(String number,int n){
    int len=Math.max(n,biscuit.length()+1);
        long[] dp=new long[len];
        long[] tmp=new long[len];
        
        dp[0]=1;
        for(int i=1;i<=biscuit.length();i++){
            char curr=biscuit.charAt(i-1);
            for(int j=0;j<n;j++)
                for(int k=0;k<10;k++)
                    if(curr=='X'||curr=='0'+k)
                        tmp[(j*10+k)%n]+=dp[j];
            System.arraycopy(tmp,0,dp,0,n);
            
            for(int j=0;j<len;j++)
                tmp[j]=0;
        }
        return dp[0];
    }
}
