import java.util.*;
public class nextgreater {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        if (ch.length == 1) return -1;
        int index = ch.length - 1;
        int next = index;
        for (int i = ch.length - 2; i >= 0; i--) {
            int left = ch[i] - '0';
            int right = ch[i + 1] - '0';
            if (left < right) {
                index = i;
                break;
            }
            if (left > ch[next] - '0') next = i;
        }
        if (index == ch.length - 1) return -1;
        for (int i = ch.length - 1; i > index; i--) {
            if (ch[i] > ch[index] && ch[i] <= ch[next]) {
                next = i;
            }
        }
        swap(ch, index, next);
        quicksort(ch, index + 1, ch.length - 1);
        String str = "";
        for ( char c : ch) {
            str += c;
        }
        long res = Long.valueOf(str);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return -1;
        int r = (int)res;
        return r;
    }
    private void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
    private void quicksort(char[] ch, int left, int right) {
        int i = left;
        int j = right;
        char pivot = ch[i];
        while (i < j) {
            while (i < j && ch[j] > pivot) {
                j--;
            }
            if (i < j) {
                ch[i++] = ch[j];
            }
            while (i < j && ch[i] < pivot) {
                i++;
            }
            if (i < j) {
                ch[j--] = ch[i];
            }
        }
        ch[i] = pivot;
        if (i - 1 > left) quicksort(ch, left, i - 1);
        if (i + 1 < right) quicksort(ch, i + 1, right);
    }
    public static void main(String[] args) {
        nextgreater test = new nextgreater();
        int n = 1999999999;
        int res = test.nextGreaterElement(n);
        System.out.print(res);
    }
}

