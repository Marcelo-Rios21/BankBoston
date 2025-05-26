
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
                registrarCliente(input, bancoClientes);
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

        public static void registrarCliente(Scanner input, BancoClientes bancoClientes) {   
            try {
                System.out.println("Ingrese su RUT (debe tener entre 11 y 12 caracteres, incluyendo puntos y guion): ");
                String rut = input.nextLine();

                System.out.println("Ingrese nombre: ");
                String nombre = input.nextLine();

                System.out.println("Ingrese apellido paterno: ");
                String apellidoPaterno = input.nextLine();

                System.out.println("Ingrese apellido materno: ");
                String apellidoMaterno = input.nextLine();

                System.out.println("Ingrese domicilio: ");
                String domicilio = input.nextLine();

                System.out.println("Ingrese comuna: ");
                String comuna = input.nextLine();

                System.out.println("Ingrese telefono: ");
                String telefono = input.nextLine();

                String numeroCuenta = generarNumeroCuenta();
                System.out.println("Numero de cuenta generado: " + numeroCuenta);

                CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta);
                Cliente cliente = new Cliente(
                    apellidoMaterno, apellidoPaterno, domicilio, comuna, cuenta, nombre, rut, telefono, numeroCuenta
                );

                bancoClientes.registrarCliente(cliente);
            } catch (IllegalArgumentException e) {
                System.out.println("Error al registrar cliente: " + e.getMessage());
            }
        }

    public static String generarNumeroCuenta() {
        StringBuilder numero = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digito = (int)(Math.random() * 10); 
            numero.append(digito);
        }
        return numero.toString();
    }
}
