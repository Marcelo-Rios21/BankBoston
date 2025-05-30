package Bankboston;

public class CuentaAhorro extends CuentaBancaria{
    public CuentaAhorro(String numeroCuenta) {
        super(numeroCuenta);
    }

    public CuentaAhorro(String numeroCuenta, int saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void reporte() {
        System.out.println("Cuenta de ahorro: Ideal para tu dinero a largo plazo!!.");
        System.out.println("Saldo: " + saldo + " pesos.");
    }
}
