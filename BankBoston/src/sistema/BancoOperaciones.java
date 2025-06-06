package sistema;
import cliente.Cliente;

public class BancoOperaciones {
    
    public static void depositarEnCuenta(Cliente cliente, int monto) {
        if (cliente == null || cliente.getCuenta() == null) {
            System.out.println("Cliente o cuenta no valida.");
            return;
        }
        cliente.getCuenta().depositar(monto);
    }

    public static void girarDesdeCuenta(Cliente cliente, int monto) {
        if (cliente == null || cliente.getCuenta() == null) {
            System.out.println("Cliente o cuenta no valida.");
            return;
        }
        cliente.getCuenta().girar(monto);
    }

    public static void consultarSaldo(Cliente cliente) {
        if (cliente == null || cliente.getCuenta() == null) {
            System.out.println("Cliente o cuenta no valida.");
            return;
        }
        System.out.println("Saldo: " + cliente.getCuenta().getSaldo() + " pesos.");
    }

    public static void verDatosCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente no valido.");
            return;
        }
        cliente.mostrarDatos();
    }
}
