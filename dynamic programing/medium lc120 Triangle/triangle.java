import java.util.*;
public class triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> pre = triangle.get(i - 1);
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    list.set(j, pre.get(0) + list.get(j));
                } else if (j == list.size() - 1) {
                    list.set(j, pre.get(pre.size() - 1) + list.get(j));
                } else {
                    list.set(j, Math.min(pre.get(j -1), pre.get(j)) + list.get(j));
                }
            }
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        int min = Integer.MAX_VALUE;
        for (Integer l : last) {
            min = Math.min(l, min);
        }
        return min;
    }
    public static void main(String[] args) {
        triangle test = new triangle();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3,4));
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(6,5,7));
        ArrayList<Integer> list4 = new ArrayList<Integer>(Arrays.asList(4,1,8,7));
        Collections.addAll(triangle, list1, list2, list3, list4);
        int res = test.minimumTotal(triangle);
        System.out.print(res);
    }
}
