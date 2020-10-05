import java.util.*;
public class reorganize {
    public String reorganizeString(String S) {
         HashMap<Character, Integer> map = new HashMap<>();
         for (int i = 0; i < S.length(); i++) {
             char c = S.charAt(i);
             map.put(c, map.getOrDefault(c, 0) + 1);
             if (map.get(c) > (S.length() + 1) / 2) return "";
         }
         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
         for (Map.Entry<Character, Integer> frequency : map.entrySet()) {
             pq.offer(frequency);
         }
         String s = "";
         while (!pq.isEmpty()) {
             Map.Entry<Character, Integer> entry = pq.poll();
             if (s.length() == 0 || s.charAt(s.length() - 1) != entry.getKey()) {
                 s += entry.getKey();
                 entry.setValue(entry.getValue() - 1);
                 if (entry.getValue() > 0) pq.offer(entry);
             } else {
                 Map.Entry<Character, Integer> second = pq.poll();
                 s += second.getKey();
                 second.setValue(second.getValue() - 1);
                 if (second.getValue() > 0) pq.offer(second);
                 pq.offer(entry);
             }
         }
         return s;
    }
}
