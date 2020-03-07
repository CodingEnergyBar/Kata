public class AddDigit {
    public int addDigits(int num) {
        // write your code here
        int res = Integer.MAX_VALUE;
        while(res > 9){
            res = 0;
            while(num > 0){
                res = num % 10 + res;
                num = num / 10;
            }
            num = res;
        }
        return res;
    }

    public static void main(String[] args) {
        AddDigit test = new AddDigit();
        int res = test.addDigits(38);
        System.out.println(res);

    }
}

