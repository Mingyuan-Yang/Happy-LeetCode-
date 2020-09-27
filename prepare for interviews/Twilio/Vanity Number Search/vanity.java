import java.util.*;
/*
Twilio customers sometimes request to purchase vanity phone numbers.
These vanity numbers are designed to be unique to the customer's brand and
memorable to their end user. An example of this is 1-800-FLOWERS,
which translates to 1-800-3569377. Here, each letter in the vanity code
(FLOWERS) corresponds to a digit on the T9.keypad.map.F maps to 3, L to 5,
O to 6 and so on, giving us 3569377 Customers typically search Twilio's
phone number inventory for such vanity codes. Given an array of one or more
vanity codes and an array of phone numbers, write a function to find all
phone numbers that match one or more vanit codes. The output must be a sorted
array of unique phone numbers from the input array of numbers.
*/
public class vanity {

//    private static TrieNode root;
//
//    public static List<String> patternMatch(List<String> patterns, List<String> phoneNums){
//        List<String> res = new ArrayList<>();
//        root=new TrieNode();
//        for(String pattern:patterns){
//            buildTree(pattern);
//        }
//        for(String num:phoneNums){
//            for(int i=0;i<num.length();++i){
//                if(search(num.substring(i))){
//                    res.add(num);
//                    break;
//                }
//            }
//        }
//        if(res.size()>0)Collections.sort(res);
//        return res;
//
//    }
//
//    private static boolean search(String num){
//        TrieNode p = root;
//        for(char c:num.toCharArray()){
//            if(p.children[c-'0']==null)
//                return false;
//            p=p.children[c-'0'];
//            if(p.isEnd)
//                return true;
//        }
//        return false;
//    }
//
//    private static void buildTree(String s){
//        TrieNode p=root;
//        for(char c:s.toCharArray()){
//            if(p.children[c-'0']==null){
//                p.children[c-'0']= new TrieNode();
//            }
//            p=p.children[c-'0'];
//        }
//        p.isEnd=true;
//    }
//
//    private static class TrieNode{
//
//        TrieNode []children = new TrieNode[10];
//        boolean isEnd = false;
//        TrieNode(){
//        }
//    }

    public static class TrieNode {
        TrieNode[] children = new TrieNode[10];
        boolean flag = false;
        TrieNode(){}

    }
    public static TrieNode root;
    public static List<String> vanity(List<String> codes, List<String> numbers) {
        List<String> res = new ArrayList<>();
        root = new TrieNode();
        //HashSet<String> set = new HashSet<>();
        HashSet<String> code = new HashSet<>();

        for (String c : codes) {
            String str = "";
            for (char ch : c.toCharArray()) {
                if (ch == 'A' || ch == 'B' || ch == 'C') {
                    str += '2';
                } else if (ch == 'D' || ch == 'E' || ch == 'F') {
                    str += '3';
                } else if (ch == 'G' || ch == 'H' || ch == 'I') {
                    str += '4';
                } else if (ch == 'J' || ch == 'K' || ch == 'L') {
                    str += '5';
                } else if (ch == 'M' || ch == 'N' || ch == 'O') {
                    str += '6';
                } else if (ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S') {
                    str += '7';
                } else if (ch == 'T' || ch == 'U' || ch == 'V') {
                    str += '8';
                } else if (ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z') {
                    str += '9';
                }
            }
            code.add(str);
        }
        for (String s : code) {
            buildTree(s);
        }


        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                if (search(number.substring(i))) {
                    res.add(number);
                    break;
                }
            }
        }
        if (res.size() > 0) Collections.sort(res);
        return res;
    }
    public static boolean search(String s) {
        char[] arr = s.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            if (cur.children [arr[i] - '0'] == null) return false;
            cur = cur.children[arr[i] - '0'];
            if (cur.flag) return true;
        }
        return false;
    }
    public static void buildTree(String s) {
        char[] arr = s.toCharArray();
        TrieNode cur = root;
        for (int i = 1; i < arr.length; i++) {
            if (cur.children[arr[i] - '0'] == null) {
                cur.children[arr[i] - '0'] = new TrieNode();
            }
            cur = cur.children[arr[i] - '0'];
        }
        cur.flag = true;
    }
    public static void main(String[] args){

        List<String> pattern = new ArrayList<>();
        pattern.add("TWLO");
        pattern.add("CODE");
        pattern.add("HTCH");

        List<String> phoneNum = new ArrayList<>();
        phoneNum.add("+17474824380");
        phoneNum.add("+14157088956");
        phoneNum.add("+919810155555");
        phoneNum.add("+15109926333");
        phoneNum.add("+1415123456");

        List<String> rr = vanity(pattern,phoneNum);
        System.out.println(rr.size());
        for(String s:rr){
            System.out.println(s);
        }
    }
}
