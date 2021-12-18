//import java.util.Scanner
public class AlternateString {
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(System.in);
        int n = 3;
        int k = 2;
        String[] dict = {"piygu", "ezyfo", "rzotm"};
        String[][] words = 
        {
            {"piygu"}, 
            {"tefwz", "tefwz", "piygu", "ezyfo", "tefwz", "piygu"}
        };
        for (String d : dict) {
            var isUsed = false;
            for (String[] w : words) {
                for (String e : w) {
                    if (d.equals(e)) {
                        isUsed = true;
                        break;
                    }
                }
                if(isUsed)
                    break;
            }
            System.out.println(isUsed ? "Yes" : "No");
        }
        //sc.close();
    }
}
