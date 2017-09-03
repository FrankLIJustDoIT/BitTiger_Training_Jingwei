class Solution {
    //the main idea is that we make a comparator, for each pair of nums a and b, 
    //compare the lexicographically of a+b and b+a, the smaller one means this two 
    //string should always be put in this order
    //front of the array
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }//corner case
        String[] str = new String[nums.length];
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(nums[i]);
        }//convert from integer to string
        
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String a, String b){
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);//compare the lexicographically
            }
        };
        
        Arrays.sort(str, comp);
        
        if(str[0].charAt(0) == '0'){
            return "0";
        }//means this is a set of "0"
        
        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }
        
        return sb.toString();
    }
}