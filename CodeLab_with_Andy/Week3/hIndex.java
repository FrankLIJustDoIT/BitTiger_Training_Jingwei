public class Solution {
    //Because citations array are sorted in ascending order, so the basic idea can be binary search
    //if the citation of the mid paper is >= the number of papers with citations higher than it(len - mid), it means
    //there are at least len - mid papers received at least len - mid citations, if citations[mid - 1] >= len - mid, this is
    //a wrong answer, but never mind we can let right=mid-1 to try larger len-mid and smaller citations[mid - 1], a right answer
    //can always be found out.
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1){
            return 0;
        }//corner case
        
        int maxH = 0;
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(citations[mid] >= len - mid){
                //this citations[mid] can be a canditate of H-index, see if this is larger than the H-index we
                //got before
                maxH = Math.max(maxH, len - mid);
                System.out.println(maxH);
                //in this condition, len -mid may be a wrong answer or maybe a larger right index exist, so we 
                //try to increase len - mid and decrease citations[mid - 1], so we can always find out the largest
                //H-index
                right = mid - 1;
            }else{
                //in this condition citations[mid + 1] may still smaller than len - mid, so we need to decrease len -mid
                //and increase citaions[mid]
                left = mid + 1;
            }
            
        }
        
        return maxH;
    }
}