package numero26SRP;

import java.util.Scanner;

public class Main {
    private final GestionLibros bookManager = new GestionLibros();
    private final GestionUsuarios userManager = new GestionUsuarios();
    private final LibreriaControlador loanManager = new LibreriaControlador(bookManager);
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Agregar libro\n2. Registrar usuario\n3. Iniciar sesión\n4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> registrarUsuario();
                case 3 -> iniciarSesion();
                case 4 -> salir = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void agregarLibro() {
        System.out.println("Título:");
        String titulo = scanner.nextLine();
        System.out.println("Autor:");
        String autor = scanner.nextLine();
        System.out.println("Descripcion:");
        String descripcion = scanner.nextLine();
        System.out.println("Número de copias:");
        int copias = scanner.nextInt();
        scanner.nextLine();
        bookManager.agregarLibro(titulo,descripcion, autor, copias);
        System.out.println("Libro agregado correctamente.");
    }

    private void registrarUsuario() {
        System.out.println("Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Correo:");
        String correo = scanner.nextLine();
        System.out.println("Contraseña:");
        String password = scanner.nextLine();
        userManager.registrarUsuario(nombre, correo, password);
        System.out.println("Usuario registrado correctamente.");
    }

    private void iniciarSesion() {
        System.out.println("Correo:");
        String correo = scanner.nextLine();
        System.out.println("Contraseña:");
        String password = scanner.nextLine();
        Usuario sesion = userManager.autenticar(correo,password);
        if (sesion!=null) {
            gestionarSesion(sesion);
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void gestionarSesion(Usuario usuario) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Tomar un libro\n2. Devolver un libro\n3. Cerrar sesión");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> tomarLibro(usuario);
                case 2 -> devolverLibro(usuario);
                case 3 -> salir = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void tomarLibro(Usuario usuario) {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        if (loanManager.prestarLibro(usuario, titulo)) {
            System.out.println("Libro prestado exitosamente.");
        } else {
            System.out.println("No se pudo prestar el libro.");
        }
    }

    private void devolverLibro(Usuario usuario) {
        System.out.println("Ingrese el título del libro a devolver:");
        String titulo = scanner.nextLine();
        if (loanManager.devolverLibro(usuario, titulo)) {
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("No se pudo devolver el libro.");
        }
    }

    public static void main(String[] args) {
        new Main().iniciar();
    }
}
