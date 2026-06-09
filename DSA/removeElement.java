class solution{
    public int duplicates(int[] a,int val){
        int i=0;
        int temp=0;
        for(int j=0;j<a.length;j++){
            if(a[j]!=val){
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
            }
        }
        return i;   
    }
}
public class removeElement {
    public static void main(String[] args) {
        int[] a={3,2,3,2};
        int value=3;    
        solution obj=new solution();
        int k=obj.duplicates(a,value);
        System.out.println("count:"+" "+k);
        System.out.println("array of elements are:");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        
    }
    
}

