import java.util.*;
public class restoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;
        backtrack(res, "", 0, s, 0);
        return res;
    }
    private void backtrack(List<String> res, String str, int index, String s, int section) {
        if (section > 4) return;
        if (section == 4 && str.length() == s.length() + 3) {
            res.add(str);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            String sec = s.substring(index, index + i);
            if (sec.length() > 1 && sec.startsWith("0") || Integer.parseInt(sec) > 255) break;
            backtrack(res, section == 0 ? sec : str + "." + sec, index + i, s, section + 1);
        }
    }
}
