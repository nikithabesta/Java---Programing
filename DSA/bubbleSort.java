class Bsort{
    public void bsort(int nums[]){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                }
                
            }
            System.out.println();
                System.out.println("Iterations = "+i);
                for(int n : nums){
                    
                    System.out.println(n);
                    
                }
        }
        System.out.println();
        System.out.println("After Sorting");
        for(int n : nums){
            System.out.println(n);
        }
    }
}
public class bubbleSort {
    public static void main(String[] args) {
        int [] nums = {12,45,87,95,67,34,56,78,23,54,70};
        Bsort obj = new Bsort();
        obj.bsort(nums);

    }
}
