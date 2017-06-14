public class Solution {
    //to solve this question, from tail to head in the array, we build a tree, for each node in the tree,
    //its right subtree is the node before it in the array and with a value bigger than it, while its 
    //left subtree if the one smaller than it
    class Node{
        Node left;
        Node right;
        
        int dupNum = 1;
        int numLeft = 0;
        int val;
        
        public Node(int val){
            this.val = val;
        }
    }
    public List<Integer> countSmaller_BST(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for(int i = nums.length - 1; i >= 0; i--){
            root = insert(nums[i], root, res, i, 0);
        }
        
        return Arrays.asList(res);
    }
    //it's like from the tail node to the head node in nums, every node will be compare to the nodes before
    //until a good pos was found.
    private Node insert(int num, Node node, Integer[] res, int i, int preSum){
        if(node == null){
            //in this position, we are gonna add a new node
            node = new Node(num);
            res[i] = preSum;
        }else if(node.val == num){
            node.dupNum++;
            res[i] = preSum + node.numLeft;
        }else if(node.val > num){
            node.numLeft++;
            node.left = insert(num, node.left, res, i, preSum);
        }else{
            node.right = insert(num, node.right, res, i, preSum + node.numLeft + node.dupNum);
        }
        
        return node;
    }
}