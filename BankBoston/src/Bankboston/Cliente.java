package Bankboston;
public class Cliente {
   private  String rut;
   private String nombre;
   private String apellidoPaterno; 
   private String apellidoMaterno;
   private String domicilio;
   private String comuna;
   private String telefono;
   private CuentaBancaria cuenta;

    public Cliente(String apellidoMaterno, String apellidoPaterno, String domicilio, String comuna, CuentaBancaria cuenta, String nombre, String rut, String telefono, String numeroCuenta) {

        if (rut == null || rut.length() < 11 || rut.length() > 12) {
           throw new IllegalArgumentException("El rut debe tener entre 11 y 12 caracteres, incluyendo puntos y guion");
        }

        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.cuenta = new CuentaBancaria(numeroCuenta);
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public void mostrarDatos(){
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Telefono: " + telefono);
        System.out.println("Cuenta corriente: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta.getSaldo() + " pesos.");
    }

    //GETTERS Y SETTERS
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
}
