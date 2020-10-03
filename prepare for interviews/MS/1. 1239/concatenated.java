import java.util.*;
public class concatenated {
    public int maxLength(String[] arr) {
        int[] max = new int[1];
        HashSet<Character> set = new HashSet<>();
        helper(arr, max, set, "", 0);
        return max[0];
    }
    private void helper(String[] arr, int[] max, HashSet<Character> set, String s, int index) {
        if (index > arr.length) return;
        max[0] = Math.max(max[0], s.length());
        for (int i = index; i < arr.length; i++) {
            String check = arr[i];
            if (isValid(check, set)) {
                add(check, set);
                helper(arr, max, set, s + check, i + 1);
                remove(check, set);
            }
        }
    }
    private void add(String check, HashSet<Character> set) {
        for (int i = 0; i < check.length(); i++) {
            set.add(check.charAt(i));
        }
    }
    private void remove(String check, HashSet<Character> set) {
        for (int i = 0; i < check.length(); i++) {
            set.remove(check.charAt(i));
        }
    }
    private boolean isValid(String check, HashSet<Character> set) {
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < check.length(); i++) {
            if (set.contains(check.charAt(i)) || set2.contains(check.charAt(i))) return false;
            set2.add(check.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        concatenated test = new concatenated();
        String[] arr = new String[]{"cha","r","act","ers"};
        System.out.println(test.maxLength(arr));
    }
}

