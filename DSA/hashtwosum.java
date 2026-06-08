
import java.util.HashMap;

class hash{
    public int[] twosum(int[] a,int key){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<a.length;i++){
            int complement=key-a[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(a[i], i);
        }
        return new int[]{};
    }
}
public class hashtwosum {
    public static void main(String[] args) {
        hash obj=new hash();
        int[] a={1,2,3,5,6,8,9};
        int key=7;
        int[] result=obj.twosum(a, key);
        System.out.println(result[0]+" "+result[1]);
    }
    
}
