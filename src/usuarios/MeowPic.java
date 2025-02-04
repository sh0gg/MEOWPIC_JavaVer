package usuarios;

import java.util.Scanner;

public class MeowPic {
    public static void main(String[] args) {

        int opcionUsuario = 0;
        Scanner sc = new Scanner(System.in);
        // Inicia sesión de usuario
        String usuario = UsuariosBD.iniciarSesion();

        do {
            System.out.println("eew");
            System.out.println("ee");
            System.out.println("ee");
            System.out.println("ee");
            opcionUsuario = sc.nextInt();
           

            switch (opcionUsuario) {
                case 1:
                System.out.println("eeee"); break;
                case 2: 
                System.out.println("ee");
                break;
                case 0:
                System.out.println("rrrrrrrrrrr");
                break;
                default:System.out.println("Opción incorrecta");
            }

        } while (opcionUsuario != 0);

    System.out.println("Fin del programa para " + usuario);
    sc.close();

    
    }
}
