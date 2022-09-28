package com.liuliu.outstanding.common;

class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPre(word);
        return trie != null && trie.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        Trie trie = searchPre(prefix);
        return trie != null;
    }

    public Trie searchPre(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            } else {
                node = node.children[index];
            }
        }
        return node;
    }

}