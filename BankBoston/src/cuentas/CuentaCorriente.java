package cuentas;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(String numeroCuenta) {
        super(numeroCuenta);
    }

    public CuentaCorriente(String numeroCuenta, int saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void reporte() {
        System.out.println("Cuenta Corriente: sin limite.");
        System.out.println("Saldo: " + saldo + " pesos.");
    }
}
