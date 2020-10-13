package model;

public class Cliente {

	private String nombre;
	
	private Double documento;
	
	private Cuenta cuentaAhorro;
	
	private Cuenta cuentaCorriente;
	
	private Cuenta cdt;
	
	public Cliente(String nombre, Double documento) {
		this.nombre = nombre;
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getDocumento() {
		return documento;
	}

	public void setDocumento(Double documento) {
		this.documento = documento;
	}

	public Cuenta getCuentaAhorro() {
		return cuentaAhorro;
	}

	public void setCuentaAhorro(Cuenta cuentaAhorro) {
		this.cuentaAhorro = cuentaAhorro;
	}

	public Cuenta getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(Cuenta cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public Cuenta getCdt() {
		return cdt;
	}

	public void setCdt(Cuenta cdt) {
		this.cdt = cdt;
	}
	
	public Double getSaldoTotal() {
		Double total = 0.0;
		total += cuentaAhorro.getSaldoTotal();
		total += cuentaCorriente.getSaldoTotal();
		total += cdt.getSaldoTotal();
		return total;
	}
	
	public void avanzarMes() {
		cuentaAhorro.aplicarInteresCtaAhorros();
		cdt.aplicarInteresCDT();
	}
	
}
