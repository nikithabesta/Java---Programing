class Executer{
    public void twoSum(int nums[],int key){
        Boolean flag = false;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==key){
                    System.out.println("The elements that add up to the given key are at :"+i+" "+j);
                    flag = true;
                }
            }
            // if(flag == false){
            //     System.out.println("No such elements exist in the array");
            // }
        }
         if(flag == false){
                System.out.println("No such elements exist in the array");
            }

    }
}
public class twoSumSai {
    public static void main(String[] args) {
        Executer obj = new Executer();
        int [] nums = {1,2,3,4,5,6,7,8,9};
        int key = 310;
        obj.twoSum(nums, key);
    }
}
