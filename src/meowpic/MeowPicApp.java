package meowpic;
import java.util.*;

public class MeowPicApp {
    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager();
    private static ImageManager imageManager = new ImageManager();
    private static User currentUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🐱 MEOWPIC - Consola 🐱");
            if (currentUser == null) {
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar Sesión");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> {
                        System.out.println("¡Hasta luego! 🐾");
                        System.exit(0);
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("\nBienvenido, " + currentUser.getUsername() + " 🐾");
                System.out.println("1. Subir imagen");
                System.out.println("2. Ver imágenes");
                System.out.println("3. Buscar imagen");
                System.out.println("4. Cerrar sesión");
                System.out.print("Seleccione una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> uploadImage();
                    case 2 -> imageManager.showImages();
                    case 3 -> searchImage();
                    case 4 -> {
                        currentUser = null;
                        System.out.println("Sesión cerrada.");
                    }
                    default -> System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void register() {
        System.out.print("Ingrese un nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String password = scanner.nextLine();
        if (userManager.registerUser(username, password)) {
            System.out.println("Usuario registrado con éxito. Ahora puede iniciar sesión.");
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    private static void login() {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        currentUser = userManager.authenticateUser(username, password);
        if (currentUser == null) {
            System.out.println("Credenciales incorrectas.");
        } else {
            System.out.println("Inicio de sesión exitoso.");
        }
    }

    private static void uploadImage() {
        System.out.print("Ingrese el nombre de la imagen: ");
        String imageName = scanner.nextLine();
        imageManager.addImage(imageName);
        System.out.println("Imagen subida con éxito.");
    }

    private static void searchImage() {
        System.out.print("Ingrese el nombre de la imagen a buscar: ");
        String name = scanner.nextLine();
        imageManager.searchImage(name);
    }
}
