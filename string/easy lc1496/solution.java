import java.util.HashSet;

public class solution {
    public static boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(x + "#" + y);
        System.out.println(x + "#" + y);
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'W') {
                x--;
            } else {
                x++;
            }
            String s = x + "#" + y;
            if (set.contains(s)) {
               // System.out.println(s.charAt(0));
                return true;
            }
            set.add(s);
        }
        return false;
    }
    public static void main(String[] args) {
        solution s = new solution();
        String path = "ENWSSSNWEEEESN";
        boolean res = s.isPathCrossing(path);
        System.out.println(res);
    }
}
