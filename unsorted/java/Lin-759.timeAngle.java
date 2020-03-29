public class Solution {
    /**
     * @param h: hours
     * @param m: minutes
     * @return: angle between hour hand and minute hand at X:Y in a clock
     */
    public float timeAngle(int h, int m) {
        // write your code here
        double minuteAngle = m / 60.0 * 360;
        double hourAngle = h / 12.0 * 360 + 360 / 12 * m / 60.0;
        double diff = Math.abs(hourAngle - minuteAngle);
        System.out.print(diff);
        if (diff - 180 > 0 || Math.abs(diff - 360) < 1e-6)
            diff = 360 - diff;
        return (float) diff;
    }
}