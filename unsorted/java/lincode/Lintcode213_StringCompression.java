public class Lintcode213_StringCompression {


    public String compress(String originalString) {
        // write your code here'
        if(originalString == null || originalString.length() ==1)
            return originalString;
        String newString = new String();

        int i=1;
        while(i<originalString.length()){

            newString = newString + originalString.charAt(i-1);
            int num = 1;
            while(originalString.charAt(i) == originalString.charAt(i-1) && i< originalString.length()){
                num++;
                i++;
            }
            newString = newString + num;
            i++;
        }




        if(newString.length() >= originalString.length())
            return originalString;
        else
            return newString;
    }


        public static void main(String[] args) {
        Lintcode213_StringCompression test = new Lintcode213_StringCompression();

        int []nums = new int[]{1, 2,3};

        System.out.println(test.compress("acca"));

    }
}
