import java.util.*;

import java.util.*;
public class find {
    // 只能朝单一方向搜索，而不是每一次都是四个方向搜索。
//    public List<String> exist(char[][] board, List<String> word) {
//        List<String> res = new ArrayList<String>();
//        if(board == null) return res;
//        int row = board.length;
//        int column = board[0].length;
//        //boolean[][] visited = new boolean[row][column];
//        HashSet<String> set = new HashSet<>();
//        int count = 0;
//        for (String str : word) {
//            for (int i = 0; i < row; i++) {
//                for (int j = 0; j < column; j++) {
//                    //if (board[i][j] != str.charAt(0)) continue;
//                    if (board[i][j] == str.charAt(0) && backtrack(board, i, j, str, 0)) {
//                        set.add(str);
//                    }
//                }
//            }
//        }
//        for (String str : word) {
//            if (set.contains(str)) {
//                res.add("yes");
//            } else {
//                res.add("no");
//            }
//        }
//        return res;
//        //System.out.println(res);
//    }
//    private boolean backtrack(char[][] board, int i, int j, String word, int index){
//        if(index == word.length()) return true;
//        int row = board.length;
//        int column = board[0].length;
//        if(i < 0 || i >= row || j < 0 || j >= column) return false;
//        if(board[i][j] == '.' || board[i][j] != word.charAt(index)) return false;
//        char temp = board[i][j];
//        board[i][j] = '.';
//        if (backtrack(board, i + 1, j, word, index + 1)){
//            return true;
//        } else if (backtrack(board, i - 1, j, word, index + 1)) {
//            return true;
//        } else if (backtrack(board, i, j + 1, word, index + 1)) {
//            return true;
//        } else if (backtrack(board, i, j - 1,  word, index + 1)){
//            return true;
//        }
//        board[i][j] = temp;
//        return false;
//    }
//
//    public static void main(String[] args) {
//        find test9 = new find();
//        List<String> word = new ArrayList<String>();
//        word.add("CAT");
//        word.add("MOM");
//        word.add("CID");
//        word.add("MOD");
//        word.add("ODA");
//        word.add("MOT");
//        word.add("ABC");
//        char[][] board = new char[][]{{'C','A','T'}, {'I','D','O'}, {'M','O','M'}};
//        List<String> res = test9.exist(board, word);
//        System.out.print(res);
//    }

    public static boolean wordSearch(char[][]map, String s){

        char[] array = s.toCharArray();

        int n=map.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(dfs(map,array,i,j,0,0,1)||
                        dfs(map,array,i,j,0,0,-1)||
                        dfs(map,array,i,j,0,1,0)||
                        dfs(map,array,i,j,0,-1,0)
                )
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][]map, char[]array, int i, int j,int index,int dir_x, int dir_y){
        int n=map.length;
        if(index==array.length)
            return true;
        if(i<0||i>=n||j<0||j>=n||array[index]!=map[i][j])
            return false;
        return dfs(map,array,i+dir_x,j+dir_y,index+1,dir_x,dir_y);
    }

    public static void main(String[] args){

        char[][] map= new char[][]{{'M','O','M','A'},{'E','X','P','O'},{'T','E','M','P'},{'T','O','Y','S'}};

        String s="OPS";
        System.out.println(s+" : "+wordSearch(map,s));

        String s1="MET";
        System.out.println(s1+" : "+wordSearch(map,s1));

        String s2="MXMS";
        System.out.println(s2+" : "+wordSearch(map,s2));

        String s3="APS";
        System.out.println(s3+" :"+wordSearch(map,s3));


    }

}
