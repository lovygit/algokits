pubic class RemoveDuplicatedNumber{
   //this method can remove duplicated number exceeding 2 times
  private static int removeDuplicated(int[] nums){
        int k=1;
        int numA=nums[0];
        int numB=nums[1];
        boolean button;
        for(int i=2;i<nums.length;i++){
            button=false;
            if(!(numA==numB&&nums[i]==numB)){
                k++;
                if(i>k){
                    numA=nums[i-1];
                    numB=nums[i];
                    nums[k]=nums[i];
                    button=true;
                }
            }
            if(!button){
                numA=nums[i-1];
                numB=nums[i];
            }
        }
        return k+1;
    }
}
