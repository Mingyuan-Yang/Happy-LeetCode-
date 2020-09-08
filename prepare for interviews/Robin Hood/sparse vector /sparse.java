import java.util.*;
public class sparse {
    public static class sparseVector {
        HashMap<Integer, Integer> map;
        int size;
        sparseVector(int size) {
            this.size = size;
            map = new HashMap<>();
        }
        sparseVector(int size, HashMap<Integer, Integer> map) {
            this.size = size;
            this.map = map;
        }
        public void setVector(int index, int value) {
            map.put(index, value);
        }
        public sparseVector add(sparseVector v2) {
            if (size != v2.size) {
                throw new IllegalStateException("length doesn't match");
            }
            HashMap<Integer, Integer> res = new HashMap<>(map);
            for (Integer key : v2.map.keySet()) {
                res.put(key, res.getOrDefault(key, 0) + v2.map.get(key));
            }
            sparseVector r = new sparseVector(size, res);
            printSparseVector(r);
            return r;
        }
        public int dot(sparseVector v2) {
            if (size != v2.size) {
                throw new IllegalStateException("length doesn't match");
            }
            int res = 0;
            for (Integer key : v2.map.keySet()) {
                res += map.getOrDefault(key, 0) + v2.map.get(key);
            }
            System.out.println("dot value :" + res);
            return res;
        }

        public double norm() {

            double norm = 0;
            for (Integer key : map.keySet()) {
                norm += map.get(key) * map.get(key);
            }
            norm = Math.sqrt(norm);
            return norm;
        }
        public double cosine(sparseVector v2) {
            if (size != v2.size) {
                throw new IllegalStateException("longth doesn't match");
            }
            double res = dot(v2) / (norm() *  v2.norm());
            System.out.println("consine value :" + res);
            return res;
        }
    }
    public static void printSparseVector(sparseVector v) {
        System.out.println("after adding: ");
        System.out.println("size : " + v.size);
        for (Integer i : v.map.keySet()) {
            System.out.println("key: " + i + "," + "value:" + v.map.get(i));
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        sparseVector v1 = new sparseVector(10);
        v1.setVector(0, 10);
        v1.setVector(3,8);
        v1.setVector(8, -9);
        sparseVector v2 = new sparseVector(10);
        v2.setVector(2, 1);
        v2.setVector(0, 1);
        sparseVector v3 = new sparseVector(12);
        try {
            v1.add(v2);
            v1.dot(v2);
            v1.cosine(v2);
            v1.add(v3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
