// this file describes an access to verify if the array can be reached to the last element.
public class Jump{
  public boolean canJump(int[] A) {
    int max = 0;
    for(int i=0;i<A.length;i++){
        if(i>max) {return false;}
      //A[i]+i is the max step to the next element,for the current element A[i],max marks we can skip the farest element when we are in 'i'
        max = Math.max(A[i]+i,max);
    }
    return true;
  }
}
