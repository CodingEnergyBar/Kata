public class Solution {
    /**
     * @param x: a double
     * @return: the square root of x
     */

    // !!! double and integer is different
    public double sqrt(double x) {
        // Write your code here
        double l = 0;
        // using 1.0 instead of 1/x to get around belowOne stuff
        double r = Math.max(x, 1.0);
        double eps = 1e-12;

        while (l + eps < r) {
            double mid = l + (r - l) / 2;
            if (mid * mid < x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }
    // public double sqrt(double x) {
    // // write your code here

    // // feel about x
    // // scope
    // boolean belowOne = false;
    // if (x < 1) {
    // x = 1 / x;
    // belowOne = true;
    // }

    // double start = 1.0, end = x / 2 + 1;

    // final double PRECISON = 1e-10;
    // double mid = start;
    // while (Math.abs(end - start) > PRECISON) {
    // mid = (end + start) / 2;
    // if (mid * mid > x) {
    // end = mid;
    // } else if (mid * mid < x) {
    // start = mid;
    // } else {
    // if (belowOne)
    // return 1 / mid;
    // return mid;
    // }
    // }
    // if (belowOne) {
    // return 1 / mid;

    // }
    // return mid;
    // }
}