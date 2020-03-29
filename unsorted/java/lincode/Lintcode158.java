public class Lintcode158 {


    public boolean isPalindrome(String s) {
        // write your code here
        int i = 0, j = s.length() - 1;


        while (i < j) {
            while (i < j && !isValid(s.charAt(i)))
                i++;
            if (i == s.length())
                return true;
            while (i < j && !isValid(s.charAt(j)))
                j--;

            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }

        }
        return true;
    }


    public boolean isPalindrome2(String s) {
        // write your code here
        String validString = "";
        for (int i=0; i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))
                validString =  validString + s.charAt(i);

        }
        System.out.println("man");
        System.out.println(validString);
        int i = 0, j = validString.length()-1;
        while(i < j){

            if(Character.toUpperCase(validString.charAt(i)) != Character.toUpperCase(validString.charAt(j)))
                return false;
            i++;
            j--;
        }


        return true;
    }
    public boolean isValid(char a) {

        if (Character.isLetter(a) || Character.isDigit(a))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Lintcode158 test = new Lintcode158();
        Boolean result = test.isPalindrome2("A man, a plan, a canal: Panama");
        System.out.println((char)('A' + 1));

    }
}
