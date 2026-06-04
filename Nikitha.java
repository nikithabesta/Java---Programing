class Bsearch{
    public void bsearch(int []nums,int key){
        int low = 0;
        int high = nums.length;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]==key){
                System.out.println("Key found at"+mid);
                break;
            }
            else if (nums[mid]>key){
                low = mid+1;
            }
            else if(nums[mid]<key){
                high = mid-1;
            }
            else
                System.out.println("Element not found");
        }
    }
}
public class Nikitha {
    public static void main(String[] args) {
        int nums [] = {1,2,3,4,5,6,7,8,9,10};
        int key = 10;
        Bsearch obj = new Bsearch();
        obj.bsearch(nums, key);
        System.out.println("Hi iam Sairam");
    }
}
