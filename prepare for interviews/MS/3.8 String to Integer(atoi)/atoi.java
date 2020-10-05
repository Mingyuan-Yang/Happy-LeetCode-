public class atoi {
    public int myAtoi(String str) {
        int sign = 1;
        int res = 0;
        int check = 0;
        boolean hasSign = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && !hasSign) {
                sign = -1;
                hasSign = true;
                continue;
            } else if (str.charAt(i) == '+' && !hasSign) {
                sign = 1;
                hasSign = true;
                continue;
            } else if (str.charAt(i) == ' ' && !hasSign) {
                continue;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasSign = true;
                check = str.charAt(i) - '0';
                if (res * sign > Integer.MAX_VALUE / 10 || (res * sign == Integer.MAX_VALUE / 10 && check * sign > 7)) {
                    return Integer.MAX_VALUE;
                } else if (res * sign < Integer.MIN_VALUE / 10 || (res * sign == Integer.MIN_VALUE / 10 && check * sign < -8)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + check;
            } else {
                return res * sign;
            }
        }
        return res * sign;
    }
}
