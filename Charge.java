public class ChargeMoney{
  public int charge(int amount,int[] coins){
    int[] dp=new int[amount+1];
        List<String>[] comb=new ArrayList[amount+1];
        dp[0]=1;
        comb[0]=new ArrayList<>();
        comb[0].add("0");
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]+=dp[i-coin];
                if(dp[i-coin]>0){
                    if(comb[i]==null){
                        comb[i]=new ArrayList<>();
                    }
                    if(dp[i-coin]==1&&comb[i-coin].get(0).contains("0"))
                        comb[i].add(coin+"+"+(i-coin));
                    else{
                        for(String str:comb[i-coin])
                            comb[i].add(coin+"+"+str);
                    }
                }
            }
        }
        System.out.println("There are "+comb[amount].size()+" combinations...");
        for(String str:comb[amount]){
            System.out.println(str);
        }
        return dp[amount];
   }
}
