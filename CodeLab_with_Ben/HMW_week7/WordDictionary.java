public class WordDictionary {
    //we design a trie tree to solve this problem
    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String word = "";
    }

    /** Initialize your data structure here. */
    TrieNode root = null;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        
        for(char x : word.toCharArray()){
            if(node.children[x - 'a'] == null){
                node.children[x - 'a'] = new TrieNode();
            }
            node = node.children[x - 'a'];
        }
        
        //we mark the word at the end char to show that this is the end of
        //the inputing word, otherwise if we search a word which is just a 
        //half part of the saved word, we will get a true returned which actually
        //should be false
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] word, int k, TrieNode node){
        if(k == word.length){
            //if this is also just the end of the saved word, then we can say that
            //we find this word, otherwise it maybe just a part of the saved word
            return !node.word.equals("");
        }
        
        if(word[k] == '.'){
            for(int i = 0; i < node.children.length; i++){
                if(node.children[i] != null){
                    if(match(word, k + 1, node.children[i])){
                        return true;
                    }
                }
            }
        }else{
            if(node.children[word[k] - 'a'] != null){
                return ( node.children[word[k] - 'a'] != null ) && ( match(word, k + 1, node.children[word[k] - 'a']) );
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */