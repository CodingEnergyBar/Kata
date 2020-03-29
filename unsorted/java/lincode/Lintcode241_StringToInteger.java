public class Lintcode241_StringToInteger {


    public int stringToInteger(String str) {
        // write your code here
        int res = 0;
        boolean neg = false;
        String s = str;

        if(str.charAt(0) == '-'){
            s = str.substring(1, str.length()-1);
            neg = true;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int integer = Character.getNumericValue(c);
            res = res*10 + integer;
        }
        return neg? -res: res;
    }



    public static void main(String[] args) {
        Lintcode241_StringToInteger test = new Lintcode241_StringToInteger();

        int []nums = new int[]{1,4,4,5,7,7,8,9,9,10};

        System.out.println(test.stringToInteger("-1"));

    }
}
