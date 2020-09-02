import java.util.*;
public class calculator2 {
    public int cal2(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                int number = c - '0';
                while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
                    number = number * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * number;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    public static void main(String[] args) {
        calculator2 test = new calculator2();
        String s = "2+((8+2)+(3-9))";
        int res = test.cal2(s);
        System.out.println(res);
    }
}
