class Sum{
    public void sum(int a[],int key){
        boolean flag=true;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]+a[j]==key){
                    System.out.println("sum of these two elements gives key:"+" "+i+" "+j);
                    flag=true;
                }
            }
        }
        if(flag==false){
            System.out.println("not found");
        }
        
    }
}
public class twoSum {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        int key=9;
        Sum obj=new Sum();
        obj.sum(a, key);
    }
}
