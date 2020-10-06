import java.util.*;
public class ReverseWordsinString {
    public String reverseWords(String s) {
        if (s == null) return null;
        char[] c = s.toCharArray();
        reverseLetters(c, c.length);
        reverse(c, 0, c.length - 1);
        return removeSpaces(c, c.length);
    }
    public void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[j];
            c[j] = c[i];
            c[i] = temp;
            i++;
            j--;
        }
    }
    public String removeSpaces(char[] c, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && c[j] == ' ') j++;
            while (j < len && c[j] != ' ') c[i++] = c[j++];
            while (j < len && c[j] == ' ') j++;
            if (j < len) c[i++] = ' ';
        }
        return new String(c).substring(0, i);
    }
    public void reverseLetters(char[] c, int len) {
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < j || i < len && c[i] == ' ') i++;
            while (j < i || j < len && c[j] != ' ') j++;
            reverse(c, i, j);
        }
    }
}
