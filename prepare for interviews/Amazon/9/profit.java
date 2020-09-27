import java.util.*;
public class profit {
    public long max_profit (int numSuppliers, long[] inventory, long order) {
        Arrays.sort(inventory);
        long max = 0;
        int i = inventory.length - 1;
        long count = 1;
        long profit = inventory[i];
        while (i > 0 && order > 0) {
            profit = inventory[i];
            while (profit > inventory[i - 1] && order >= count) {
                max += profit * count;
                profit--;
                order -= count;
                System.out.println(max);
            }
            if (profit == inventory[i - 1]) {
                count++;
            } else {
                break;
            }
            i--;
        }
        while (order > count) {
            count = Math.min(count, order);
            max += count * profit;
            profit--;
            order -= count;
            System.out.println(max);
        }
        max += order * profit;
        return max;
    }
    public static void main (String[] args) {
        profit test = new profit();
        int num = 5;
        long[] inventory = new long[]{2,8,4,10,6};
        long order = 20;
        long res = test.max_profit(num, inventory, order);
        System.out.println(res);
    }
}
