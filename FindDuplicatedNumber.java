public class FindDuplicatedNumber{
  /* If there is this condition nums[i]==i+1
    this method can't work*/
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    for(int i=0;i<nums.length;i++) nums[i]--;
    int slow = n-1;
    int fast = n-1;
    do{
        slow = nums[slow];
        fast = nums[nums[fast]];
    }while(slow != fast);
    slow = n-1;
    while(slow != fast){
        slow = nums[slow];
        fast = nums[fast];
    }
    return slow+1;
  }
  
  /*If nums[i-1]=i,this method can't work*/
  public int findDuplicate2(int[] nums) {
    int n = nums.length;
    int slow = n;
    int fast = n;
    do{
        slow = nums[slow-1];
        fast = nums[nums[fast-1]-1];
    }while(slow != fast);
    slow = n;
    while(slow != fast){
        slow = nums[slow-1];
        fast = nums[fast-1];
    }
    return slow;
  }
}
