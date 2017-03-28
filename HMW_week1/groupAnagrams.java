public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<List<String>>();
        if(strs==null || strs.length<1){ return resList; }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s:strs){
            char[] sChar = s.toCharArray();
            Arrays.sort(sChar);
            String key = String.valueOf(sChar);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<String>();
                map.put(key,list);
            }
            map.get(key).add(s);
        }
        for(String k:map.keySet()){
            resList.add(map.get(k));
        }
        return resList;
    }
}