package ar.edu.unlam.alicia.persona;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import ar.edu.unlam.alicia.alimento.Alimento;
import ar.edu.unlam.alicia.enums.TipoAlimento;
import ar.edu.unlam.alicia.exceptions.DineroInsuficienteEception;
import ar.edu.unlam.alicia.exceptions.EfectoAnuladoException;
import ar.edu.unlam.alicia.exceptions.SinDineroDisponibleEception;
import ar.edu.unlam.alicia.interfaces.Acciones;


public abstract class Persona  implements Acciones{

	protected Integer dni;
	protected String nombre;
	protected Double peso;
	protected Double altura;
	protected Double dinero;

	public Persona(Integer dni, String nombre, Double peso, Double altura,Double dinero) {
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

	public Double getDinero() {
		return dinero;
	}



	public void setDinero(Double dinero) {
		this.dinero = dinero;
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
	public abstract void comprar(Alimento alimento) throws SinDineroDisponibleEception, DineroInsuficienteEception ;



	@Override
	public abstract Boolean alimentarse(Alimento alimento) throws EfectoAnuladoException ;



	public abstract void agregarAlimentoaAlista(Alimento caramelos);



	
	public abstract void ordenarLista(List<Alimento> listaDeAlimentos);



	
}
