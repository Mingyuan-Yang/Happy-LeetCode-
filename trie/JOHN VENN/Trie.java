import java.util.*;
public class Trie {
    public static class TrieNode {
        TrieNode[] children;
        boolean flag;
        TrieNode () {
            children = new TrieNode[26];
            flag = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    TrieNode root;
    public Trie () {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            if (cur.children[arr[i] - 'a'] == null) {
                cur.children[arr[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[arr[i] - 'a'];
        }
        cur.flag = true;
    }

    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            if (cur.children[arr[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[arr[i] - 'a'];
        }
        return cur.flag;
    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < arr.length; i++) {
            if (cur.children[arr[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[arr[i] - 'a'];
        }
        return true;
    }
    public static void main(String[] args) {
        trie test = new trie();
        //TrieNode root = new TrieNode();
        test.insert("abcd");
        boolean res1 = test.search("123ABC");
        boolean res2 = test.search("X");
        boolean res3 = test.startsWith("abd");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
