import java.util.*;
public class palindromic {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int maxLen = 0;
        int start = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || isPalindrome[i + 1][j - 1]);
                if (isPalindrome[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
