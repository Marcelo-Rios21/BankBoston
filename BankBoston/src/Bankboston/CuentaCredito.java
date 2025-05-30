package Bankboston;

public class CuentaCredito extends CuentaBancaria {
    private static final int LIMITE_CREDITO = 100000;

    public CuentaCredito(String numeroCuenta) {
        super(numeroCuenta);
    }

    public CuentaCredito(String numeroCuenta, int saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido. Debe ser mayor a cero.");
            return;
        }

        if (saldo - monto < -LIMITE_CREDITO) {
            System.out.println("No se puede realizar el giro. Excede el limite de credito.");
            return;
        }

        saldo -= monto;
        System.out.println("Giro exitoso!");
        System.out.println("Saldo (puede ser negativo): " + saldo + " pesos.");
    }

    @Override
    public void reporte() {
        System.out.println("Cuenta de credito: Permite girar hasta un limite.");
        System.out.println("Saldo: " + saldo + " pesos.");
        System.out.println("Credito disponible: " + (LIMITE_CREDITO + saldo) + " pesos.");
    }
}
