package model;

public class Cuenta {
	
	//CONSTANTES
	
	public static final String CORRIENTE = "corriente";
	
	public static final String DE_AHORROS = "ahorros";
	
	public static final String CDT = "cdt";
	
	public static final Double INTERES_CTA_AHORROS = 0.6;
	
	//ATRIBUTOS
	
	private String tipoDeCuenta;
	
	private Double saldoTotal;
	
	private Double interesCDT;
	
	//RELACIONES
	
	private Cliente elCliente;
	
	//CONSTRUCTOR
	
	public Cuenta(String tipoDeCuenta, Double saldoTotal, Cliente elCliente) {
		this.tipoDeCuenta = tipoDeCuenta;
		this.saldoTotal = saldoTotal;
		this.elCliente = elCliente;
	}
	
	public Cuenta(String tipoDeCuenta, Double inversion, Double interes, Cliente elCliente) {
		this.tipoDeCuenta = tipoDeCuenta;
		this.saldoTotal = inversion;
		this.interesCDT = interes;
		this.elCliente = elCliente;
	}

	//METODOS GET & SET
	
	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	
	public Double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public Double getInteresCDT() {
		return interesCDT;
	}

	public void setInteresCDT(Double interesCDT) {
		this.interesCDT = interesCDT;
	}
	
	//METODOS

	public void depositar(Double deposito) {
		if(!tipoDeCuenta.equals(CDT)) {
			saldoTotal += deposito;
		}
	}
	
	public Double retirar(Double dineroARetirar) {
		Double retiro = 0.0;
		if(!tipoDeCuenta.equals(CDT)) {
			if(tipoDeCuenta.equals(CORRIENTE)) {
				retiro = dineroARetirar;
				saldoTotal -= retiro;
			} else if(tipoDeCuenta.equals(DE_AHORROS)) {
				retiro = dineroARetirar;
				saldoTotal -= retiro;
			}
		}
		return retiro;
	}
	
	public void aplicarInteresCtaAhorros() {
		saldoTotal += (INTERES_CTA_AHORROS*saldoTotal);
	}
	
	public void aplicarInteresCDT() {
		saldoTotal += (interesCDT*saldoTotal);
	}

	public void cerrarCDT() {
		if(tipoDeCuenta.equals(CDT)) {
			elCliente.getCuentaCorriente().depositar(saldoTotal);
			saldoTotal = 0.0;
			interesCDT = 0.0;
		}
	}
}