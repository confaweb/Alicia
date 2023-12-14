package ar.edu.unlam.alicia.persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.alicia.alimento.Alimento;
import ar.edu.unlam.alicia.enums.TipoAlimento;
import ar.edu.unlam.alicia.exceptions.DineroInsuficienteEception;
import ar.edu.unlam.alicia.exceptions.EfectoAnuladoException;
import ar.edu.unlam.alicia.exceptions.SinDineroDisponibleEception;
import ar.edu.unlam.alicia.interfaces.Acciones;

public class Alicia extends Persona {

	private static final Double ALTURA_MAXIMA = 2.8;
	private static final Double ALTURA_MINIMA = 0.5;
	private List<Alimento> listaDeAlimentos;

	public Alicia(Integer dni, String nombre, Double peso, Double altura, Double dinero) {
		super(dni, nombre, peso, altura, dinero);
		super.dni = dni;
		super.nombre = nombre;
		super.peso = peso;
		super.altura = altura;
		super.dinero = dinero;
		this.listaDeAlimentos=new ArrayList<Alimento>();
	}
	
	

	@Override
	public void comprar(Alimento alimento) throws SinDineroDisponibleEception, DineroInsuficienteEception {
		if (checkSaldoMayr_0() && checkDineroSuficiente(alimento))
			super.dinero -= alimento.getPrecio();

	}

	private boolean checkSaldoMayr_0() throws SinDineroDisponibleEception {
		Boolean saldoPositivo = false;
		if (super.dinero > 0) {
			saldoPositivo = true;
			return saldoPositivo;
		} else
			throw new SinDineroDisponibleEception("No hay mas dinero Disponible");

	}

	private boolean checkDineroSuficiente(Alimento alimento) throws DineroInsuficienteEception {
		Boolean aclcanza = false;
		if (super.dinero >= alimento.getPrecio()) {
			aclcanza = true;
			return aclcanza;
		} else
			throw new DineroInsuficienteEception("No alcanza el  dinero Disponible para realizar la compra");

	}

	@Override
	public Boolean alimentarse(Alimento alimento) throws EfectoAnuladoException {
		boolean efectocumplido = false;
		if (alimento.getTipo() == TipoAlimento.AGRANDADOR && super.altura <= (Alicia.ALTURA_MAXIMA - .5)) {
			super.altura += .5;
			efectocumplido = true;
			return efectocumplido;
		} else if (alimento.verificarSiEsAchicador(alimento.getNombre()) && super.altura >= (Alicia.ALTURA_MINIMA + .5)) {
			super.altura -= 0.5;
			efectocumplido = true;
			return efectocumplido;
		}

		else {
			throw new EfectoAnuladoException("Efecto Supera rango de altura");
		}

	}

	@Override
	public void agregarAlimentoaAlista(Alimento alimento) {
		listaDeAlimentos.add(alimento);
		
	}

	public void ordenarLista(List<Alimento> listaDeAlimentos) {
		Collections.sort(listaDeAlimentos);
//		Collections.reverse(this.listaDeAlimentos);
	}
	public  void mostrarLista() {
		for(Alimento alimento :listaDeAlimentos) 
			System.out.println("\n"+alimento.getNombre());
		
	}
	

}
