public class wordDictionary {
    public class TrieNode {
        boolean flag;
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[26];
            flag = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    TrieNode root;
    public wordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
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
        return helpSearch(word, root);
    }
    public boolean helpSearch(String word, TrieNode root) {
        char[] c = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (helpSearch(word.substring(i + 1) ,cur)) {
                            return true;
                        }
                    }
                }
            } else if (cur.children[c[i] - 'a'] == null) return false;
            cur = cur.children[c[i] - 'a'];
        }
        return cur.flag;
    }
}
