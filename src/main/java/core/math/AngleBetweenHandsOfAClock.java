package core.math;

/**
 * LC 1344. Angle Between Hands of a Clock
 */
public class AngleBetweenHandsOfAClock {
    public static double angleClock(int hour, int minutes) {
        double hourDegree = 30 * (hour % 12) + (minutes / 60.0) * 30;
        double minuteDegree = (minutes / 60.0) * 360;
        double diff = Math.abs(minuteDegree - hourDegree);
        return diff > 180.0 ? 360 - diff : diff;
    }
    // TS: O(1)

    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(1, 57));
    }

}
