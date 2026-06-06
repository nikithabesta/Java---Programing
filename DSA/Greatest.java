public class Greatest {
    public static void main(String[] args) {
        int a[]={2,4,5,7,1,8};
        int greatest=0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]>a[i]){
                    greatest=j;
                }
            }
        }
        System.out.println("the greatest element in the given array is :"+a[greatest]);
    }
}
