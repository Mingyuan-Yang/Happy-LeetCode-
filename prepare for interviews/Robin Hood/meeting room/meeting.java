import java.util.*;
public class meeting {
    //problem1
    // O(n) n is the length of meetings array. O(1)
    public boolean meetingroom1(int[][] meetings, int start, int end) {
        for (int[] meeting : meetings) {
            if ((meeting[0] < start && meeting[1] > start) || (meeting[0] < end && meeting[1] > end) ||
                    (meeting[0] > start && meeting[1] < end)) {
                return false;
            }
        }
        return true;
    }

    //problem2
    //O(nlogn)
    //O(n)
    public List<List<Integer>> meetingroom2(int[][] meetings) {
        List<List<Integer>> res = new ArrayList<>();
        int[] start = new int[meetings.length];
        int[] end = new int[meetings.length];
        for (int i = 0; i < meetings.length; i++) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(start); //O(nlogn)
        Arrays.sort(end);
        List<Integer> l1 = new ArrayList<>();
        Collections.addAll(l1, 0, start[0]);
        res.add(l1);
        int i = 0;
        for (int j = 1; j < end.length; j++) {
            if (start[j] > end[j - 1]) {
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, end[j - 1], start[j]);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        meeting test = new meeting();
        int[][] meetings = new int[][]{{1300,1500},{930,1200},{830,845}};
        int start = 1450;
        int end = 1550;
        boolean res = test.meetingroom1(meetings, start, end);
        //System.out.print(res);

        int[][] meetings2 = new int[][]{{1300,1500},{930,1200},{830,845}};
        List<List<Integer>> res2 = test.meetingroom2(meetings2);
        for (int i = 0; i < res2.size(); i++) {
            System.out.println(res2.get(i).get(0) + "," + res2.get(i).get(1));
        }
    }
}

//830 930 1300
//854 1200 1500