class logic{
    public boolean check(int a){
        int rev=0;
        int n=a;
        while(n>0){
            int d=n%10;
            rev=rev*10+d;
            n=n/10;
        }
        if(rev==a){
            return true;
        }
        else{
            return false;
        }

    }
}
public class palindrome {
    public static void main(String[] args) {
        logic obj=new logic();
        int a=120;
        if( obj.check(a)){
            System.out.println("palindrome");
        }
        else{
            System.out.println("not a palindrome");
        }
        
    }
}
