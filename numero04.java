public class numero04 {
    public static void main(String[] args) {
        
        /*
         *  DIFICULTAD EXTRA (opcional):
        * Crea un programa que analice dos palabras diferentes y realice comprobaciones
        * para descubrir si son:
        * - Palíndromos
        * - Anagramas
        * - Isogramas
        */
         
        String texto = "llenaba";
        String texto2 = "artea";
        String compare = "";
        
        

        for (int i = texto.length()-1;i>=0;i--) {
            compare+=texto.charAt(i);
        }
       
        if(compare.equals(texto2)){
            System.out.println("es un palindormo");
        }

        int count = 0;
        for (Character c : texto.toCharArray()) {
            if(texto2.contains(c+"")){
                count++;
            }   
        }  
        if(texto.length()==count){
            System.out.println("son anagramas");
        }
        int iso = 0;
        boolean a = true;
       for (int i = 0; i < texto2.length(); i++) {
            for (int j = 0; j < texto2.length(); j++) {
                    if(texto2.charAt(i)==texto2.charAt(j)){
                        iso++;
                    }
            }
            if(iso>=2){
                a=false;
                break;
            }
            iso=0;
       }
       if(a){
            System.out.println("es un isograma");
       }else{
            System.out.println("no es un isograma");
       }
        
    }   
    
}
