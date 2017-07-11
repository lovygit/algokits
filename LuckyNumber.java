public class LuckyNumber{
  public static int dfs(int pos,int[] data,int sum,long pi){
        int count=0;
        for(int i=pos;i<data.length;i++){
            sum+=data[i];
            pi*=data[i];
            if(sum>pi)
                count=1+dfs(i+1,data,sum,pi);
            else if(data[i]==1){
                count=dfs(i+1,data,sum,pi);
            }
            else
                break;
            sum-=data[i];
            pi/=data[i];
            while(i+1<data.length&&data[i]==data[i+1])
                i++;
        }
        return count;
    }
}
