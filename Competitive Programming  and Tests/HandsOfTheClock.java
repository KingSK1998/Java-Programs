/*******************************************************************************
 * SOURCE: Appeared in Mindtree
 * AUTHOR: Shivam Kashyap - 28/Dec/2021
 * 
 * ---------------------------------------------------------------------------
 * PROBLEM: In C++, unable to get '.0' after obtaining non decimal place value.
 *          e.g. Sample Test case 1 & 2.
 *          cout << setprecision(1) << fixed; 
 *          doesn't work for me. 
 * ---------------------------------------------------------------------------
 * 
 * QUESTION: You are given a string input time='AB:CD' where AB denotes 
 * the hours from 00 to 12 and CD denotes the minutes from 00 to 59, 
 * in a 12-hours format Your task is to write a program to calculate 
 * the smallest angle between the hour hand and the minute hand of a 
 * clock, for the given time.
 * Note: Return your answer with upto 1 decimal place.
 * 
 * Sample Testcases
 * Input    Output      Output Description
 * ---------------------------------------------------------------
 * 09:06    123.0       123.0 degrees is the smallest angle formed 
 *                      between the hour hand and the minute hand 
 *                      at 09:06 a.m. or 09:06 p.m.
 * ----------------------------------------------------------------
 * 01:56    82.0        82.0 degrees is the smallest angle formed 
 *                      between the hour hand and the minute hand 
 *                      at 01:56 a.m. or 01:56 p.m.
 * ----------------------------------------------------------------
 * 11:07    68.5        68.5 degrees is the smallest angle formed 
 *                      between the hour hand and the minute hand 
 *                      at 11:07 a.m. or 11:07 p.m.
********************************************************************************/ 

public class HandsOfTheClock {
    static double angle(String time)
    {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        if (h == 12)
            h = 0;
        if (m == 60)
            m = 0;
        double hAngle = 0.5 * ((60 * h) + m);
        double mAngle = 6 * m;
        double ret = Math.abs(hAngle - mAngle);
        return Math.min(360 - ret, ret);
    }

    public static void main(String[] args) {
        System.out.println(angle("09:06"));
        System.out.println(angle("01:56"));
        System.out.println(angle("11:07"));
    }
}