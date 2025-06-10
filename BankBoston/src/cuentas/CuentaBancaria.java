package cuentas;
public abstract class CuentaBancaria {
    protected String numeroCuenta;
    protected int saldo;

    //CONSTRUCTOR 1
    public CuentaBancaria(String numeroCuenta) {
        if (numeroCuenta == null || !numeroCuenta.matches("\\d{9}")) {
            throw new IllegalArgumentException("El numero de cuenta debe tener exactamente 9 digitos");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    //CONSTRUCTOR 2
    public CuentaBancaria(String numeroCuenta, int saldoInicial) {
        if (numeroCuenta == null || !numeroCuenta.matches("\\d{9}")) {
            throw new IllegalArgumentException("El numero de cuenta debe tener exactamente 9 digitos");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
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

    public abstract void reporte();

    public abstract double calcularInteres();


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
