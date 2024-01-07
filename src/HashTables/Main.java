package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static char findFirstNonRepeatingChar(String str){
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()){
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
    public static char findFirstRepeatingChar(String str){
        Map<Character, Integer> characterOccurences = new HashMap<>();
        var stringArray = str.toCharArray();
        char ch;
        for (char chr : stringArray) {
          var count = characterOccurences.containsKey(chr) ? characterOccurences.get(chr) : 0;
          characterOccurences.put(chr, count + 1);
        }
        for(char chr : stringArray){
            if (characterOccurences.get(chr) == 1)
                return chr;
        }
        return Character.MIN_VALUE;
    }
    public static void main(String[] args) {
        // Map<Integer, String> family = new HashMap<>();

        // family.put(1, "Adrian");
        // family.put(2, "Rodney");
        // family.put(3, "Erick");
        // family.put(4, "Arthur");
        // family.put(5, "Ben");
        // family.put(6, "Maria");

        // System.out.println(family.remove("Rodney"))
        System.out.println(findFirstNonRepeatingChar("a green apple"));
    }
}
