import java.util.*;
/* The string word is an occurrence of the string sequence if sequence contains word as a substring.
   The string word is a k-occurrence of the string sequence if sequence contains word repeated k times as a substring.
   eg : input : sequence = "ababcbabac" words = ["ab", "babc", "bca"]
        output: maxKOccurrences = [2,2,0]
  */


public class max {
    public int[] maxKOccurrence(String sequence, String[] words) {
        int[] res = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int sequenceIndex = 0;
            int sIndex = 0;
            while (sequenceIndex < sequence.length()) {
                int count = 0;
                int sequenceCurr = sequenceIndex;
                while (sequenceCurr < sequence.length() && s.charAt(sIndex) == sequence.charAt(sequenceCurr)) {
                    sIndex++;
                    sequenceCurr++;
                    if (sIndex == s.length()) {
                        count++;
                        max = Math.max(count, max);
                        sIndex = 0;
                    }
                }
                sIndex = 0;
                sequenceIndex++;
            }
            res[i] = max;
            max = 0;
            System.out.println(res[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        max test = new max();
        String s = "ababcbabc";
        String[] words = new String[]{"ab", "babc", "bca"};
        int[] res = test.maxKOccurrence(s, words);
        System.out.println(res);
    }
}