package Bankboston;
import java.util.ArrayList;

public class BancoClientes {
    private ArrayList<Cliente> clientes;

    public BancoClientes(){
        clientes = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente){
        if (cliente == null) {
            System.out.println("No se puede registrar un cliente nulo.");
            return;
        }
        clientes.add(cliente);
        System.out.println("Cliente registrado exitosamente!.");
    }

    public Cliente buscarClientePorRut(String rut) {
        for (Cliente c : clientes) {
            if (c.getRut().equals(rut)) {
                return c;
            }
        }
        System.out.println("Cliente no encontrado");
        return null;
    }

    public void verDatosCliente(String rut) {
        Cliente cliente = buscarClientePorRut(rut);
        if (cliente != null) {
            cliente.mostrarDatos();
        }
    }
}
