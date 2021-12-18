import java.io.*;

public class SumOfSquareInArray {
    public static void main(String[] args) {
        int[] arr = {16, 7, 81, 24, 36, 40};
        System.err.println( sumofSquare(arr, arr.length));     
    }

    static int sumofSquare(int[] arr, int n) {
        if(arr.length == 0)
            return 0;
        int sum = 0;
        for (int i : arr) {
            if (checkPerfectSquare(i)){
                sum = sum + (int)Math.sqrt(i);
            }
        }
        if (sum == 0)
            return 0;
        return sum;
    }

    static boolean checkPerfectSquare(double number)    
    {     
        double sqrt=Math.sqrt(number);     
        return ((sqrt - Math.floor(sqrt)) == 0);   
    } 
}