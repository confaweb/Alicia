package ar.edu.unlam.alicia.persona;

import java.util.Objects;

import ar.edu.unlam.alicia.interfaces.Acciones;
import ar.edu.unlam.alicia.interfaces.Alimento;
import ar.edu.unlam.alicia.interfaces.alimento;

public class Persona implements Acciones{

	protected Integer dni;
	protected String nombre;
	protected Double peso;
	protected Double altura;
	protected Integer dinero;

	public Persona(Integer dni, String nombre, Double peso, Double altura,Integer dinero) {
		this.dni=dni;
		this.nombre=nombre;
		this.peso=peso;
		this.altura=altura;
		this.dinero=dinero;
	}

	

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + "]";
	}



	@Override
	public void comprar(String precio, Alimento alimento) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void alimentarse(Alimento alimento) {
		// TODO Auto-generated method stub
		
	}

}
