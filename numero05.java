public class numero05 {
    public static void main(String[] args) {




                
                int a = 5, b = 10;
                System.out.println("Antes del intercambio por valor:");
                System.out.println("a = " + a + ", b = " + b);
        
                int[] resultado = intercambioPorValor(a, b);
                System.out.println("Después del intercambio por valor:");
                System.out.println("a = " + a + ", b = " + b);
                System.out.println("Nuevos valores: nuevoA = " + resultado[0] + ", nuevoB = " + resultado[1]);
        
  
                int[] valores = {5, 10,0};
                System.out.println("\nAntes del intercambio por referencia:");
                System.out.println("valores[0] = " + valores[0] + ", valores[1] = " + valores[1]+ ", valores[2] = " + valores[2]);
        
                intercambioPorReferencia(valores);
                System.out.println("Después del intercambio por referencia:");
                System.out.println("valores[0] = " + valores[0] + ", valores[1] = " + valores[1] + ", valores[2] = " + valores[2]);
            }
        
       
            public static int[] intercambioPorValor(int x, int y) {
                int temp = x;
                x = y;
                y = temp;
     
                return new int[]{x, y};
            }
    
            public static void intercambioPorReferencia(int[] array) {
                int temp = array[0];
                array[0] = array[1];
                array[2]=   70;
                array[1] = temp;
            }
        
}
