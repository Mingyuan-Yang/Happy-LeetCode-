import java.util.*;
public class flights {
    public int[] movies (List<Integer> movies, int d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < movies.size(); i++) {
            map.put(movies.get(i), i);
        }
        Collections.sort(movies);
        int i = 0;
        int j = movies.size() - 1;
        int resI = 0;
        int resJ = movies.size() - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            int sum = movies.get(i) + movies.get(j);
            if (sum <= d - 30) {
                if (sum == max) {
                    if (resJ < j) {
                        resJ = j;
                        resI = i;
                    }
                } else if (sum > max) {
                    max = sum;
                    resI = i;
                    resJ = j;
                }
                i++;
            } else {
                j--;
            }
        }
        return new int[]{map.get(movies.get(resI)), map.get(movies.get(resJ))};
    }
    public static void main(String[] args) {
        flights test = new flights();
        List<Integer> movies = new ArrayList<>(Arrays.asList(90, 70, 75, 60, 120, 150, 125));
        int d = 250;
        int[] res = test.movies(movies, d);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
