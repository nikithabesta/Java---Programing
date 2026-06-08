class solution{
    public int duplicates(int[] a){
        int i=0;
        for(int j=1;j<a.length;j++){
            if(a[i]!=a[j]){
                i++;
                a[i]=a[j];
            }
        }
        return i+1;
    }
}
public class removeDuplicate {
    public static void main(String[] args) {
        int[] a={1,1,1,2,2,3,4};
        solution obj=new solution();
        int k=obj.duplicates(a);
        System.out.println("count:"+" "+k);
        System.out.println("array of elements are:");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        
    }
    
}
