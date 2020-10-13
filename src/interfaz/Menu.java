package interfaz;

import java.util.Scanner;

import model.*;

public class Menu {

	private Cliente elCliente;

	public Menu() {

		System.out.println("------------------------------------------------------------------------");
		System.out.println("Bienvenido al programa de la Sucursal Bancaria");
		System.out.println("------------------------------------------------------------------------");
		Scanner scan = new Scanner(System.in);

		System.out.print("Escriba su nombre: ");
		String nombre = scan.nextLine();
		System.out.print("Escriba su cedula: ");
		Double documento = scan.nextDouble();
		
		elCliente = new Cliente(nombre, documento);
		
		//En caso de pedir los saldos iniciales al usuario
//		System.out.print("Escriba su saldo de cuenta corriente: ");
//		Double ctaCorriente = scan.nextDouble();
//		System.out.print("Escriba su saldo de cuenta ahorros: ");
//		Double ctaAhorros = scan.nextDouble();
//		System.out.print("Escriba su saldo de cuenta CDT: ");
//		Double ctaCDT = scan.nextDouble();
		
		Double ctaCorriente = 800000.0;
		Cuenta corriente = new Cuenta(Cuenta.CORRIENTE, ctaCorriente, elCliente);
		Double ctaAhorros = 1000.0;
		Cuenta ahorros = new Cuenta(Cuenta.DE_AHORROS, ctaAhorros, elCliente);
		Double ctaCDT = 0.0;
		Cuenta cdt = new Cuenta(Cuenta.CDT, ctaCDT, 0.0, elCliente);
		
		elCliente.setCuentaCorriente(corriente);
		elCliente.setCuentaAhorro(ahorros);
		elCliente.setCdt(cdt);
		
		int eleccion = 0;
		int mes = 1;
		
		do {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("---------------------------SIMULADOR BANCARIO---------------------------");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Datos Cliente: ---------------------------------------------------------");
			System.out.println("Nombre: "+ nombre + "             " + "Cédula: " + documento);
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Información Bancaria: --------------------------------------------------");
			System.out.println("");
			System.out.println("Cuenta de ahorros: -----------------------------------------------------");
			System.out.println("Saldo ahorros: $" + elCliente.getCuentaAhorro().getSaldoTotal() + "  [" + Cuenta.INTERES_CTA_AHORROS + "%]");
			System.out.println("                                           " + "1. Consignar  2. Retirar");
			System.out.println("Cuenta corriente: ------------------------------------------------------");
			System.out.println("Saldo corriente: $" + elCliente.getCuentaCorriente().getSaldoTotal());
			System.out.println("                                           " + "3. Consignar  4. Retirar");
			System.out.println("CDT: -------------------------------------------------------------------");
			System.out.println("Saldo CDT: $" + elCliente.getCdt().getSaldoTotal() + "  [" + elCliente.getCdt().getInteresCDT() + "%]");
			System.out.println("                                         " + "5.Abrir CDT  6. Cerrar CDT");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("Mes: " + mes);
			System.out.println("                                                     " + "7. Avanzar mes");
			System.out.println("                                                    Total: $" + elCliente.getSaldoTotal());
			System.out.println("------------------------------------------------------------------------");
			System.out.println("                                                      " + "0. Para salir");
			System.out.println("Digite su opción: ");
			eleccion = scan.nextInt();
			
			Double valorIngresado = 0.0; 
			
			switch(eleccion) {
				case 1:
					System.out.print("Digite el valor: ");
					valorIngresado = scan.nextDouble();
					elCliente.getCuentaAhorro().depositar(valorIngresado);
					break;
				case 2:
					System.out.print("Digite el valor: ");
					valorIngresado = scan.nextDouble();
					elCliente.getCuentaAhorro().retirar(valorIngresado);
					break;
				case 3:
					System.out.print("Digite el valor: ");
					valorIngresado = scan.nextDouble();
					elCliente.getCuentaCorriente().depositar(valorIngresado);
					break;
				case 4:
					System.out.print("Digite el valor: ");
					valorIngresado = scan.nextDouble();
					elCliente.getCuentaCorriente().retirar(valorIngresado);
					break;
				case 5:
					System.out.print("Digite el valor: ");
					valorIngresado = scan.nextDouble();
					System.out.print("Digite interes: ");
					Double interesCDT = scan.nextDouble();
//					Cuenta newCDT = new Cuenta(Cuenta.CDT, valorIngresado, interesCdt, elCliente);
//					elCliente.setCdt(newCDT);
					elCliente.getCdt().setSaldoTotal(valorIngresado);
					elCliente.getCdt().setInteresCDT(interesCDT);
					break;
				case 6:
					elCliente.getCdt().cerrarCDT();
					System.out.println("Se ha cerrado el CDT");
					break;
				case 7:
					elCliente.avanzarMes();
					break;
				case 0 :
					System.out.println("------------------------------------------------------------------------");
					System.out.println("---------------------------OPERACIÓN TERMINADA--------------------------");
					System.out.println("------------------------------------------------------------------------");
			}
			
		} while(eleccion != 0);
	}

	public static void main(String[] args) {
		Menu miMenu = new Menu();
	}

}
