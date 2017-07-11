public class FractionShower{
   public String fractionToDecimal(int numerator, int denominator) {

        long numerator_=numerator;
        long denominator_=denominator;

        boolean sign=(numerator_*denominator_)>0? true:false;
        numerator_=Math.abs(numerator_);
        denominator_=Math.abs(denominator_);

        long integerPart=numerator_/denominator_;

        numerator_%=denominator_;
        if(numerator_%denominator_==0){
            if(sign)
                return String.valueOf(integerPart);
            else
                return "-"+String.valueOf(integerPart);
        }



        List<Long> middleResult=new ArrayList<>();
        List<Long> fraction=new ArrayList<>();
        while(!(middleResult.contains(numerator_)||numerator_==0)){
            middleResult.add(numerator_);
            numerator_*=10;
            fraction.add(numerator_/denominator_);
            numerator_%=denominator_;
        }
        StringBuilder builder=new StringBuilder(String.valueOf(integerPart));
        builder.append(".");
        if(numerator_==0){
            for(long fra:fraction)
                builder.append((char)(fra+'0'));
        }else{
            int startIndex=middleResult.indexOf(numerator_);
            for(int i=0;i<fraction.size();i++){
                if(i!=startIndex)
                    builder.append((char)(fraction.get(i)+'0'));
                else
                    builder.append("("+(char)(fraction.get(i)+'0'));
            }
            builder.append(")");
        }

        String expr=builder.toString();
        if(!sign)
            expr="-"+expr;
        return expr;
    }
}
