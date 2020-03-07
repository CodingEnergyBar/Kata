public class Main {


    public  int strStr(String source, String target) {
        // Write your code here

        for(int i=0; i<source.length() - target.length()+1; i++){
            int j = 0;
            while(j < target.length()){
                if(source.charAt(i+j) != target.charAt(j))
                    break;
                j++;
            }

            if(j == target.length())
                return i;
        }
        return -1;
    }


    public static void main(String[] args)
    {
        Main test = new Main();
        int result  = test.strStr("abcdabcdefg", "bcd");
        System.out.println(result);

    }
}
