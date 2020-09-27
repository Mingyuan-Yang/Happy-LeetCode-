import java.util.*;
public class NEAR {
    public int getParent(int x, int[] parent) {
        if (parent[x] == x) return x;
        return getParent(parent[x], parent);
    }

    public  int minCost(int n, int[][] edges, int[][] newEdges) {
        // edge...

        // try union-find.
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // total connected graph
        int num = n;

        // apply current edges.
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            // if they belong to the same graph, don't change parent relationship.
            int px = getParent(x, parent);
            int py = getParent(y, parent);
            if (px != py) {
                // different parent. merge them.
                parent[y] = x;
                n--;
            }
        }

        // if currently one graph...
        if (n == 1) return 0;

        // sort newEdges.
        int cost = 0;
        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < newEdges.length && n > 1; i++) {
            int x = newEdges[i][0];
            int y = newEdges[i][1];
            int px = getParent(x, parent);
            int py = getParent(y, parent);
            if (px != py) {
                // different parent. merge them.
                parent[y] = x;
                n--;
                cost += newEdges[i][2];
            }
        }
        if (n == 1) return cost;
        else return -1;
    }

    public static void main(String[] args) {
        NEAR test = new NEAR();
        int n = 7;
        int[][] edges = {{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}, {3, 7, 8}};
        System.out.println(test.minCost(n, edges, newEdges));
    }
}
