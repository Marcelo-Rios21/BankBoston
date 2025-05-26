
import java.util.Scanner;

public class BankBostonApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        menuPrincipal(input);
        input.close();
    }

    public static void menuPrincipal(Scanner input) {
        BancoClientes bancoClientes = new BancoClientes();
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = pedirOpcion(input);

            if (opcion >= 1 && opcion <= 6) {
                
            } else {
                System.out.println("Opcion invalida. Debe ser un numero entre 1 y 6.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n----- MENU BANK BOSTON -----");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
        System.out.println("Seleccione una opcion: ");
    }

    public static int pedirOpcion(Scanner input) {
        int opcion = -1;

        try {
            opcion = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un numero valido.");
        }
        return opcion;
    }

    public static boolean ejecutarOpcion(Scanner input, BancoClientes bancoClientes, int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("1. Registrar cliente");
                break;
            case 2:
                System.out.println("2. Ver datos de cliente");
                break;
            case 3:
                System.out.println("3. Depositar");
                break;
            case 4:
                System.out.println("4. Girar");
                break;
            case 5:
                System.out.println("5. Consultar saldo");
                break;
            case 6:
                System.out.println("Gracias por usar Bank Boston!");
                return true;
        }
        return false;
    }
}
