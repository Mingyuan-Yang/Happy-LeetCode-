import java.util.*;
public class decodeways {
    public int numDecodings(String s) {
        // for this problem, we must create a new integer array whose length equals to the input string length plus 1.
        // because if the last 2 index element can be composed to a qualified integer[10,26], the new qualified integer
        // will as an entire number, to combine with the previous number.
        // base case : if there are only 2 elements
        // induction rule : if (last element != 0) M[i] = M[i-1]
        //                  if (last 2 elements can be a qualified integer) M[i] += M[i-2]
        // M[i] represents from the 0th element to ith element, the maximal possible decode ways
        if (s == null || s.length() == 0) return 0;
        int[] M = new int[s.length() + 1];
        M[0] = 1;
        M[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            char c1 = s.charAt(i - 1);
            if (c1 != '0') {
                M[i] = M[i - 1];
            }
            char c2 = s.charAt(i - 2);
            if (c2 == '1' || (c2 == '2' && c1 >= '0' && c1 <= '6')) {
                M[i] += M[i - 2];
            }
        }
        return M[s.length()];
    }
    public static void main(String[] args) {
        decodeways test = new decodeways();
        String s = "226";
        int res = test.numDecodings(s);
        System.out.print(res);
    }
}
