import java.util.*;
public class validateIp {
    public boolean validIPAddress(String IP) {
        return isValidIPV4(IP);
    }
    private boolean isValidIPV4(String IP) {
        String[] str = IP.split("\\.");
        if (str.length != 4) return false;
        for (String s : str) {
            if (s.isEmpty() || s.length() > 3 || s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            int value = Integer.parseInt(s);
            if (value < 0 || value > 255) return false;
        }
        return IP.charAt(IP.length()-1) != '.';
    }
    public static void main(String[] args) {
        validateIp test9 = new validateIp();
        String Ip = "172.16.254.05";
        boolean res = test9.isValidIPV4(Ip);
        System.out.print(res);
    }
}
