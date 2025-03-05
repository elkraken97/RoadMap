import java.util.*;

public class numero18 {
    public static void main(String[] args) {
 /*       ArrayList<Integer> n = new ArrayList<>();
        n.addLast(23);
        n.addFirst(55);

        n.add(1,99);
        n.remove(3);
        n.remove(1);
        n.add(1,5);
        List<Integer> masN = new ArrayList<>();
        n.addAll(4,masN);
        n.set(3,2);*/

        //dificultad extra
        Set<Integer> conjuntoA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> conjuntoB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println("Conjunto A: " + conjuntoA);
        System.out.println("Conjunto B: " + conjuntoB);

        // Unión (A ∪ B) - Todos los elementos de ambos conjuntos
        Set<Integer> union = new HashSet<>(conjuntoA);
        union.addAll(conjuntoB);
        System.out.println("Unión (A ∪ B): " + union);

        // Intersección (A ∩ B) - Elementos comunes en ambos conjuntos
        Set<Integer> interseccion = new HashSet<>(conjuntoA);
        interseccion.retainAll(conjuntoB);
        System.out.println("Intersección (A ∩ B): " + interseccion);

        // Diferencia (A - B) - Elementos en A que no están en B
        Set<Integer> diferencia = new HashSet<>(conjuntoA);
        diferencia.removeAll(conjuntoB);
        System.out.println("Diferencia (A - B): " + diferencia);

        // Diferencia simétrica (A Δ B) - Elementos en A o en B, pero no en ambos
        Set<Integer> diferenciaSimetrica = new HashSet<>(union);
        diferenciaSimetrica.removeAll(interseccion);
        System.out.println("Diferencia Simétrica (A Δ B): " + diferenciaSimetrica);
    }
}
