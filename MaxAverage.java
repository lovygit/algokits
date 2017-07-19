public class MaxAverage{
    public double findMaxAverage(int[] nums, int k) {
        double minValue=Integer.MAX_VALUE;
        double maxValue=Integer.MIN_VALUE;

        for(int num:nums){
            minValue=Math.min(minValue,num);
            maxValue=Math.max(maxValue,num);
        }

        double preMid=Integer.MIN_VALUE;

        double error=Integer.MAX_VALUE;
        while(error>1e-5){
            double mid=(minValue+maxValue)/2;

            if(check(nums,mid,k))
                minValue=mid;
            else
                maxValue=mid;

            error=Math.abs(mid-preMid);
            preMid=mid;
        }

        return minValue;
    }

    private boolean check(int[] nums,double mid,int k){
        double sum=0,preSum=0,minSum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i]-mid;
        if(sum>0)
            return true;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-mid;
            preSum+=nums[i-k]-mid;
            minSum=Math.min(minSum,preSum);

            if(sum>minSum)
                return true;
        }
        return false;
    }
}
