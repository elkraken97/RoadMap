public class numero02 {
    public static void main(String[] args) {
        ejecutar();
        imprimeTodo(10,"xddd\n");


        //Dificultad Extra
        String primerParametro = "que";
        String segundoParametro = "so";
        int a = fizzbuzz(primerParametro, segundoParametro);
        System.out.println("veces que no se imprimio ningun string:"+a);

    }
    public static void ejecutar(){
      System.out.println("sonso");  
    }
    public static String[] imprimeTodo(int veces,String a){
        String[] retornar = new String[veces]; 
               for (int i = 0; i < veces; i++) {
            
                System.out.println(a);
                retornar[i] = a;
            }
            return retornar;
    }


    public static int fizzbuzz(String primerString,String segundoString){
        int suma = 0;
        for (int i = 1; i <= 100; i++) {
            if(i%5==0&&i%3==0){
                System.out.println(primerString+segundoString);
            }else if(i%3==0){
                System.out.println(primerString);
            }else if(i%5==0){
                System.out.println(segundoString);
            }else{
                System.out.println(i);
                suma++;
            }
        }
        return suma;
    }
    
}
