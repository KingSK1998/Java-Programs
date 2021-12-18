import java.util.*;

public class CharacterCountUsingMap {
    static char characterCount(String str){
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        char[] strArray = str.toCharArray();

        for (char c : strArray) {
            if (charCountMap.containsKey(c))
                charCountMap.put(c, charCountMap.get(c) + 1);
            else
                charCountMap.put(c, 1);
        }
        int maxOccurInt = 0;
        char c = '\0';
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if(c == '\0')
                c = entry.getKey();
            if(maxOccurInt < Integer.parseInt(entry.getValue().toString())){
                maxOccurInt = Integer.parseInt(entry.getValue().toString());
                c = entry.getKey();
            }
        }
        return c;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = characterCount(str);
        int r = 0;
        int q = 0;
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c)
                r++;
            else
                q++;
        }
        if(r==q)
            System.out.println("Yes");
        else
            System.out.println("No");
        sc.close();
    }
}
