import java.util.HashMap;
import java.util.Map;
class Solution{
    public void sum(int [] nums, int key){
        boolean flag=false;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = key - nums[i];
            if(map.containsKey(compliment)){
                System.out.println("Values found at"+map.get(compliment)+" "+i);
                flag = true;
                return;
            }
            map.put(nums[i], i);
            
        }
        // if(flag==false){
             System.out.println("No such values");
        // }
    }
}
public class twoSumHash {
    public static void main(String[] args) {
        int key = 12;
        int [] nums = {1,2,3,4,5,6,7,8,9};
        Solution obj = new Solution();
        obj.sum(nums, key);

    }
}
