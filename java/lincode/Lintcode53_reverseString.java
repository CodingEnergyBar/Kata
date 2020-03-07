public class Lintcode53_reverseString {


    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.length() == 0)
            return "";
        String[] sentence = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String news = new String();

        for (int i = sentence.length - 1; i >= 0; i--) {
            // take care of the case: space
            if (sentence[i] != "")
                news = news + sentence[i] + " ";
        }
        return news;
    }





        public static void main(String[] args) {
        Lintcode53_reverseString test = new Lintcode53_reverseString();

        int []nums = new int[]{1, 2,3};

        System.out.println(test.reverseWords("blue is  sky the"));

    }
}
