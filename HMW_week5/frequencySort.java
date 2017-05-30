public class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() < 3){
            return s;
        }//corner case
        
        int[] count = new int[256];
        int maxFre = 0;
        //we at first count the frequency of each char in s, we also maintain
        //the max frequency throughout the input s so we can know the size of
        //array we are gonna use later
        for(char c : s.toCharArray()){
            count[c]++;
            maxFre = Math.max(maxFre, count[c]);
        }
        
        //now we compute for each possible frequency, from 0 to maxFre, what chars
        //in the input s have it, and for chars have same frequency m, we concatenate
        //them into a string and save it in strSave[m].
        String[] strSave = new String[maxFre + 1];
        int m = 0;
        for(int i = 0; i < 256; i++){
            if(count[i] != 0){
                String temp = strSave[count[i]];
                strSave[count[i]] = (temp == null) ? (char)i + "" : temp + (char)i;    
            }
        }
        
        //now things left are easy, as chars have high frequency locates in a high 
        //index in strSave, we traverse them from tail to head, add them in sb
        StringBuilder sb = new StringBuilder();
        for(int i = maxFre; i >= 0; i--){
            if(strSave[i] != null){
                for(char c : strSave[i].toCharArray()){
                    for(int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}