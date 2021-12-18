import java.util.Arrays;
import java.util.Scanner;

interface IMinMoves {
    int sortArray(int[] arr, int n);
}

class MySol implements IMinMoves {

    @Override
    public int sortArray(int[] arr, int n) {
        int moves = 0;
        for (int j = 0; j < n; j++) {
            
            for (int i = j; i < n-1; i++) {
                if(arr[i] < arr[i++]) {
                int temp = arr[i];
                arr[i] = arr[i++];
                arr[i++] = temp;
                moves++;
            }
        }
    }
        System.out.println(Arrays.toString(arr));   
        return moves;
    }
}

public class Sort_Array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MySol sol = new MySol();
        int answer = sol.sortArray(arr, n);
        System.out.println(answer);
        sc.close();
    }
}
