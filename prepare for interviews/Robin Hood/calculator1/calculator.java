public class calculator {
    public int cal(String s) {
        if (s == null || s.length() == 0) return 0;
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                int number = c - '0';
                while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
                    number = number * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res += sign * number;
            } else if (c == '+') {
                sign = 1;
            } else {
                sign = -1;
            }
        }
        return res;
    }
    private boolean isNumber (char c) {
        return c >= '0' && c <= '9';
    }
    public static void main(String[] args) {
        calculator test = new calculator();
        String s = "2+3-999+0";
        int res = test.cal(s);
        System.out.print(res);
    }
}
