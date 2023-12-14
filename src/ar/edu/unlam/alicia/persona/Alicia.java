package ar.edu.unlam.alicia.persona;

import ar.edu.unlam.alicia.interfaces.Acciones;

public class Alicia extends Persona  {

	

	public Alicia(Integer dni, String nombre, Double peso, Double altura, Integer dinero) {
		super(dni,nombre,peso,altura,dinero);
		super.dni=dni;
		super.nombre=nombre;
		super.peso=peso;
		super.altura=altura;
		super.dinero=dinero;
	}

}
