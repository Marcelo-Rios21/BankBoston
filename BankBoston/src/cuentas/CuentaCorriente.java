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

    public double calcularInteres() {
        return saldo * 0.00;
    }

    public void simularInteres() {
        double interes = calcularInteres();
        System.out.println("Esta cuenta no genera interes.");    
    }
}
