import java.util.*;

public class website {
    public List<String> name (int numOfItems, HashMap<String, List<Integer>> map, int sortParameter,
                              int sortOrder, int itemsPerPage, int pageNumber) {
        List<Map.Entry<String, List<Integer>>> list = new ArrayList<Map.Entry<String, List<Integer>>>(map.entrySet());
        if (sortOrder == 0) {
            Collections.sort(list, new Comparator<Map.Entry<String, List<Integer>>>() {
                public int compare(Map.Entry<String, List<Integer>> l1, Map.Entry<String, List<Integer>> l2) {
                    return l1.getValue().get(sortParameter - 1) - l2.getValue().get(sortParameter - 1);
                }
            });
        } else {
            Collections.sort(list, new Comparator<Map.Entry<String, List<Integer>>>() {
                public int compare(Map.Entry<String, List<Integer>> l1, Map.Entry<String, List<Integer>> l2) {
                    return l2.getValue().get(sortParameter - 1) - l1.getValue().get(sortParameter - 1);
                }
            });
        }

        int index = pageNumber * itemsPerPage;
        int count = itemsPerPage;
        List<String> res = new ArrayList<>();
        while (index < list.size() && count > 0) {
            res.add(list.get(index).getKey());
            index++;
            count--;
        }
        return res;
    }
    public static void main(String[] args) {
        website test = new website();
        int num = 3;
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put("item", Arrays.asList(10, 15));
        map.put("item2", Arrays.asList(3, 4));
        map.put("item3", Arrays.asList(17, 8));
        int sortParameter = 1;
        int sortOrder = 1;
        int itemsPerPage = 2;
        int pageNumber = 0;
        List<String> res = test.name(num, map, sortParameter, sortOrder, itemsPerPage, pageNumber);
        System.out.print(res);
    }
}



