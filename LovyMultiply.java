public class LovyMultiply{
  public String plus(String num1, String num2) {
        int len=num1.length()+num2.length();
        int i=0,j=0;
        boolean carry=false;
        char[] result=new char[len+1];
        int index=0;

        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();



        while(i<num1.length()&&j<num2.length()){
            int middle=num1.charAt(i)-'0'+num2.charAt(j)-'0';
            if(carry)
                middle+=1;
            if(middle>9){
                middle%=10;
                carry=true;
            }else
                carry=false;

            result[index++]=(char)(middle+'0');

            i++;
            j++;
        }

        if(i==num1.length()){
            num1=num2;
            i=j;
        }

        while(i<num1.length()){
            int middle=num1.charAt(i)-'0';
            if(carry)
                middle+=1;

            if(middle>9){
                middle%=10;
                carry=true;
            }else{
                carry=false;
            }
            result[index++]=(char)(middle+'0');

            i++;
        }

        if(carry)
            result[index]='1';

        return new StringBuilder(new String(result)).reverse().toString().trim();
    }
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();

        String result="0";
        for(int i=0;i<len2;i++){
            int time=num2.charAt(i)-'0';
            String middle="0";
            for(int k=0;k<time;k++)
                middle=plus(middle,num1);

            String tmp=plus(result,result);
            result=plus(result,result);
            result=plus(result,result);
            result=plus(result,result);
            result=plus(result,tmp);
            result=plus(result,middle);
        }
        return result;
    }


    public int trailingZeroes(int n) {
        int count2=0;
        int count5=0;
        int count10=0;
        for(int i=2;i<n;i++){
            if(i%10==0){
                count10+=i/10;
            }
            else if(i%5==0)
                count5++;
            else if(i%2==0)
                count2++;
        }
        return count10+Math.min(count2,count5);
    }
}
