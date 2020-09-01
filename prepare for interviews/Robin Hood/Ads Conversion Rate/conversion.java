import java.util.*;
public class conversion {
    public List<String> customer(List<String> purchase, List<String> ad_clicks, List<String> user_ip) {
        List<String> res = new ArrayList<>();
        HashMap<String, String> ip_text = new HashMap<>();
        HashMap<String, Integer> text_count = new HashMap<>();
        HashSet<String> id = new HashSet<>();
        for (String s : purchase) {
            id.add(s);
        }
        for (String ad : ad_clicks) {
            String[] a = ad.split(",");
            ip_text.put(a[0], a[2]);
            text_count.put(a[2], text_count.getOrDefault(a[2], 0) + 1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String ip : user_ip) {
            String[] b = ip.split(",");
            if (id.contains(b[0])) {
                String address = b[1];
                String text = ip_text.get(address);
                map.put(text, map.getOrDefault(text, 0) + 1);
            }
        }
        for (String text : text_count.keySet()) {
            if (!map.containsKey(text)) {
                map.put(text, 0);
            }
        }
        for (String key : map.keySet()) {
            int count = map.get(key);
            int totalNumber = text_count.get(key);
            String s = count + " of" +  " " + totalNumber + " " + key;
            res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        conversion test = new conversion();
        List<String> purchase = new ArrayList<>();
        List<String> ad_clicks = new ArrayList<>();
        List<String> user_ip = new ArrayList<>();
        Collections.addAll(purchase, "3123122444","234111110", "8321125440", "99911063");
        Collections.addAll(ad_clicks, "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                                                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                                                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                                                 "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                                                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                                                 "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens");
        Collections.addAll(user_ip, "2339985511,122.121.0.155", "234111110,122.121.0.1",
                                               "3123122444,92.130.6.145", "99911063,92.130.6.144",
                                     "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000", "8321125440,82.1.106.8");
        List<String> res = test.customer(purchase, ad_clicks, user_ip);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
