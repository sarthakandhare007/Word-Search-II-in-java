🧩 Problem Statement:

You are given:

A 2D board of characters

A list of words

Return all the words that can be found in the board.
Each word must be constructed from letters of sequentially adjacent cells (up, down, left, right).
The same cell may not be used more than once per word.

Example:
Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

words = ["oath","pea","eat","rain"]

Output:
["eat","oath"]

💡 Approach (Trie + DFS Backtracking):

This is an optimized version of Word Search I, because instead of checking every word individually, we:

Build a Trie from the given list of words (prefix tree).

Use DFS from each cell of the board to explore possible word paths.

Stop early if current prefix doesn’t exist in Trie → prune the search.# Word-Search-II-in-java
