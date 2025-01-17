public class numero06 {

    public static void main(String[] args) {
        //recursividad
        imprimira0(100);
        System.out.println(factorial(10));
        System.out.println(fibonachi(6));
    }
    public static int imprimira0(int a){
        if(a==0){
            return a;
        }
        System.out.println(a);
        return imprimira0(a-1);
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int fibonachi(int pocision){
        if(pocision==0){
            return 0;
        }else if(pocision==1){
            return 1;
        }
        return fibonachi(pocision-1) + fibonachi(pocision-2);
    }
}
