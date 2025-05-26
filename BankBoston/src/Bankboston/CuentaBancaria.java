package Bankboston;
public class CuentaBancaria {
    private String numeroCuenta;
    private int saldo;

    public CuentaBancaria(String numeroCuenta) {
        if (numeroCuenta == null || !numeroCuenta.matches("\\d{9}")) {
            throw new IllegalArgumentException("El numero de cuenta debe tener exactamente 9 digitos");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public void depositar(int monto){
        if (monto <= 0) {
            System.out.println("Monto invalido. Debe ser mayor a cero.");
            return;
        }
        saldo += monto;
        System.out.println("Deposito exitoso!");
        System.out.println("Saldo: " + saldo + " pesos.");
    }

    public void girar(int monto){
        if (monto <= 0) {
            System.out.println("Monto invalido. Debe ser mayor que cero.");
            return;
        }
        if (monto > saldo) {
            System.out.println("No es posible realizar el giro. Fondos insuficientes.");
            return;
        }
        saldo -= monto;
        System.out.println("Giro exitoso!");
        System.out.println("Saldo: " + saldo + " pesos.");
    }


    //GETTERS Y SETTERS
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    

}
