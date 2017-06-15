public class Trie {
    
    class TreeNode{
        char val;
        TreeNode[] children = new TreeNode[26];
        boolean isLeaf = false;
        
        public TreeNode(char val){
            this.val = val;
        }
    }
    
    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode('$');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        
        int k = 0;
        TreeNode node = root;
        
        for(char c : word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TreeNode(c);
            }
            
            node = node.children[c - 'a'];
        }
        
        node.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        
        return match(word.toCharArray(), 0, root, true);
    }
    
    private boolean match(char[] word, int k, TreeNode node, boolean isSearch){
        if(k == word.length){
            //which means we find a prefix or a word, if isSearch==false, which
            //means we just want to find a prefix, now we return true anyway
            //but if isSearch==true, we are finding a word, now we also need to
            //check isLeaf
            return !isSearch || node.isLeaf;
        }
        
        for(int i = 0; i < node.children.length; i++){
            if(node.children[i] != null && node.children[i].val == word[k]){
                return match(word, k + 1, node.children[i], isSearch);
            }
        }
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return false;
        }
        
        return match(prefix.toCharArray(), 0, root, false);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */