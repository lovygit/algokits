public class NumberReader{
  public static void read(int number){
    String[] radix={"十","百","千","万","亿"};
    String[] data={"零","一","二","三","四","五","六","七","八","九"};
    
    if(numbe==0){
      System.out.println(data[0]);
      return;
    }
    boolean sign=number<0;
    if(sign)
        number=-number;
    StringBuilder builder=new StringBuilder();

    int time=0;

    int partA=number%10000;
    int partB=((number-partA)/10000)%10000;
    int partC=number/100000000;

    while(partA>0){
        time++;
        if(partA%10!=0){
            if(time>1)
                builder.append(radix[time-2]);
            builder.append(data[partA%10]);
        }

        partA/=10;
    }

    if(partB>0){
        builder.append(radix[3]);
        time=0;
        while(partB>0){
            time++;
            if(partB%10!=0){
                if(time>1)
                    builder.append(radix[time-2]);
                builder.append(data[partB%10]);
            }

            partB/=10;
        }
    }

    if(partC>0){
        builder.append(radix[4]);
        time=0;
        while(partC>0){
            time++;
            if(partC%10!=0){
                if(time>1)
                    builder.append(radix[time-2]);
                builder.append(data[partC%10]);
            }
            partC/=10;
        }
    }
    System.out.println((sign? "负":"")+builder.reverse());
  }
}
