package prob09;



public class numero09 {
    public static void main(String[] args) {
        Gerente g = new Gerente(1,"Chucho el gerente");
        GerenteDeProyectos proyecto = new GerenteDeProyectos(5,"fantasmin","proyecto de app");
        g.agregarProyectoAcargo(proyecto);
        g.setReporte("Tremenda mierda de proyecto cffff");
        System.out.println(g.toString());
        Programador p1= new Programador(2,"calderon","crear interface");
        Programador p2= new Programador(3,"ctm","backend");
        Programador p3= new Programador(4,"elpepe","ciberseguridad");
        proyecto.setProgramadoresAcargo(p1);
        proyecto.setProgramadoresAcargo(p2);
        proyecto.setProgramadoresAcargo(p3);
        System.out.println(proyecto.toString());

    }
}
