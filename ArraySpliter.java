public class ArraySpliter{
  public boolean canPartition(int[] nums) {
        int target=0;
        for(int val:nums)
            target+=val;
        if(target%2==1)
            return false;
        target/=2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;

        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=dp[j]||dp[j-nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }
}
