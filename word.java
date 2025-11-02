import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null; // store complete word at the end node
}

public class WordSearchII {
    private TrieNode root = new TrieNode();
    private Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[i][j] = '#'; // mark visited
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
                dfs(board, x, y, node);
        }
        board[i][j] = c; // backtrack
    }

    private void buildTrie(String[] words) {
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null)
                    node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.word = w;
        }
    }

    public static void main(String[] args) {
        WordSearchII solver = new WordSearchII();
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println("Found words: " + solver.findWords(board, words));
    }
}
