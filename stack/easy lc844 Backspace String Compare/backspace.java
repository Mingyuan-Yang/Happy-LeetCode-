import java.util.*;
public class backspace {
    public boolean backspaceCompare(String S, String T) {
        // Solution1
//        Stack<Character> stack1 = new Stack<>();
//        Stack<Character> stack2 = new Stack<>();
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//            if (c != '#') {
//                stack1.push(c);
//            } else {
//                if (!stack1.isEmpty()) {
//                    stack1.pop();
//                }
//            }
//        }
//        for (int i = 0; i < T.length(); i++) {
//            char c = T.charAt(i);
//            if (c != '#') {
//                stack2.push(c);
//            } else {
//                if (!stack2.isEmpty()) {
//                    stack2.pop();
//                }
//            }
//        }
//        if (stack1.size() != stack2.size()) return false;
//        while (!stack1.isEmpty() && !stack2.isEmpty()) {
//            char x = stack1.pop();
//            char y = stack2.pop();
//            if (x != y) return false;
//        }
//        return stack1.isEmpty() && stack2.isEmpty();


        // Solution2
        if (S == null && T == null) return true;
        if (S == null || T == null) return false;
        int sIndex = S.length() - 1;
        int tIndex = T.length() - 1;
        int sCount = 0; // count number of '#' in string S
        int tCount = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0 && (S.charAt(sIndex) == '#' || sCount > 0)) {
                if (S.charAt(sIndex) == '#') {
                    sCount++;
                } else {
                    sCount--;
                }
                sIndex--;
            }
            while (tIndex >= 0 && (T.charAt(tIndex) == '#' || tCount > 0)) {
                if (T.charAt(tIndex) == '#') {
                    tCount++;
                } else {
                    tCount--;
                }
                tIndex--;
            }
            if (tIndex >= 0 && sIndex >= 0 && S.charAt(sIndex) == T.charAt(tIndex)) {
                sIndex--;
                tIndex--;
            } else {
                return tIndex == -1 && sIndex == -1;
            }
        }
        return true;
    }
}
