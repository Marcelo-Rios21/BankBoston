package Bankboston;
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

            if (opcion >= 1 && opcion <= 7) {
                salir = ejecutarOpcion(input, bancoClientes, opcion);
            } else {
                System.out.println("Opcion invalida. Debe ser un numero entre 1 y 7.");
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
        System.out.println("6. Reporte de cuenta");
        System.out.println("7. Salir");
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
                System.out.println("Ingrese el RUT del cliente: ");
                String rut = input.nextLine();
                bancoClientes.verDatosCliente(rut);
                break;
            case 3:
                depositar(input, bancoClientes);
                break;
            case 4:
                girar(input, bancoClientes);
                break;
            case 5:
                consultarSaldo(input, bancoClientes);
                break;
            case 6: 
                System.out.println("wip");
            case 7:
                System.out.println("Gracias por usar Bank Boston!");
                return true;
        }
        return false;
    }

    public static void registrarCliente(Scanner input, BancoClientes bancoClientes) {  
        String rut; 
        while (true) {
            System.out.println("Ingrese su RUT (debe tener entre 11 y 12 caracteres, incluyendo puntos y guion): ");
            rut = input.nextLine();
            if (rut.length() >= 11 && rut.length() <= 12) break;
            System.out.println("RUT invalido. Intente nuevamente.");
        }

        String nombre;
        while (true) {
            System.out.println("Ingrese nombre: ");
            nombre = input.nextLine();
            if (!nombre.isBlank()) break;
            System.out.println("El nombre no puede estar vacio.");
        }

        String apellidoPaterno;
        while (true) {
            System.out.println("Ingrese apellido paterno: ");
            apellidoPaterno = input.nextLine();
            if (!apellidoPaterno.isBlank()) break;
            System.out.println("El apellido paterno no puede estar vacio.");
        }
            
        String apellidoMaterno;
        while (true) {
            System.out.println("Ingrese apellido materno: ");
            apellidoMaterno = input.nextLine();
            if (!apellidoMaterno.isBlank()) break;
            System.out.println("El apellido materno no puede estar vacio.");
        }
            
        String domicilio;
        while (true) {
            System.out.println("Ingrese domicilio: ");
            domicilio = input.nextLine();
            if (!domicilio.isBlank()) break;
            System.out.println("El domicilio no puede estar vacio.");
        }
            
        String comuna;
        while (true) {
            System.out.println("Ingrese comuna: ");
            comuna = input.nextLine();
            if (!comuna.isBlank()) break;
            System.out.println("El comuna no puede estar vacio.");
        }
            
        String telefono;
        while (true) {
            System.out.println("Ingrese telefono: ");
            telefono = input.nextLine();
            if (!telefono.isBlank()) break;
            System.out.println("El telefono no puede estar vacio.");
        }
        
        int opcionCuenta = -1;

            while (true) { 
                System.out.println("Ingrese tipo de cuenta deseado: ");
                System.out.println("1. cuenta corriente");
                System.out.println("2. cuenta ahorro");
                System.out.println("3. cuenta de credito");
                try {
                    opcionCuenta = Integer.parseInt(input.nextLine());
                    if (opcionCuenta >= 1 && opcionCuenta <= 3) break;
                    System.out.println("Debe ingresar un numero valido entre 1 y 3.");
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un numero valido");
                }
            }
                String numeroCuenta = generarNumeroCuenta();
                System.out.println("Numero de cuenta generado: " + numeroCuenta);
            CuentaBancaria cuenta = null;
            switch (opcionCuenta) {
                case 1:
                    cuenta = new CuentaCorriente(numeroCuenta);
                    break;

                case 2:
                   cuenta = new CuentaAhorro(numeroCuenta);
                    break;
                case 3:
                    cuenta = new CuentaCredito(numeroCuenta);
                      break;
            }

        try {
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

    public static void depositar(Scanner input, BancoClientes bancoClientes) {
        Cliente cliente;
        while(true) {
            System.out.println("Ingrese el RUT del cliente: ");
            String rut = input.nextLine();
            cliente = bancoClientes.buscarClientePorRut(rut);

            if (cliente != null) break;
            System.out.println("No se encontró ningun cliente con ese RUT. Intente nuevamente.");
        }
        
        int monto;
        while(true) {
            System.out.println("Ingrese el monto a depositar: ");
            try {
                monto = Integer.parseInt(input.nextLine());
                if (monto > 0) break;
                System.out.println("El monto debe ser mayor a cero");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
        BancoOperaciones.depositarEnCuenta(cliente, monto);
    }

    public static void girar(Scanner input, BancoClientes bancoClientes) {
        Cliente cliente;
        while(true) {
            System.out.println("Ingrese el RUT del cliente: ");
            String rut = input.nextLine();
            cliente = bancoClientes.buscarClientePorRut(rut);

            if (cliente != null) break;
            System.out.println("No se encontró ningun cliente con ese RUT. Intente nuevamente.");
        }

        int monto;
        
        while(true) {
            System.out.println("Ingrese el monto a girar: ");
            try {
                monto = Integer.parseInt(input.nextLine());
                if (monto <= 0) {
                    System.out.println("El monto debe ser mayor a cero");
                } else if (monto > cliente.getCuenta().getSaldo()) {
                    System.out.println("Fondos insuficientes. Su saldo actual es: " + cliente.getCuenta().getSaldo() + " pesos.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
        BancoOperaciones.girarDesdeCuenta(cliente, monto);
    }

    public static void consultarSaldo(Scanner input, BancoClientes bancoClientes) {
        Cliente cliente;
        while(true) {
            System.out.println("Ingrese el RUT del cliente: ");
            String rut = input.nextLine();
            cliente = bancoClientes.buscarClientePorRut(rut);

            if (cliente != null) break;
            System.out.println("No se encontró ningun cliente con ese RUT. Intente nuevamente.");
        }
        BancoOperaciones.consultarSaldo(cliente);
    }
}
