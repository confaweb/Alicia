package ar.edu.unlam.alicia.alimento;

import java.util.Objects;

import ar.edu.unlam.alicia.enums.AlimentoAchicador;
import ar.edu.unlam.alicia.enums.AlimentoAgrandador;
import ar.edu.unlam.alicia.enums.TipoAlimento;
import ar.edu.unlam.alicia.exceptions.AlimentoNoExisteException;
import ar.edu.unlam.alicia.enums.TipoAlimento;

public class Alimento implements Comparable<Alimento>{
	private String nombre;
	private TipoAlimento tipo;
	private Double precio;

	public Alimento(String nombre, double precio, TipoAlimento tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio=precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoAlimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoAlimento tipo) {
		this.tipo = tipo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean definirTipoAlimentoPorNombre(String nombreAlimento) throws AlimentoNoExisteException {
		Boolean alimentoClasificado = false;
		if (verificarSiEsAchicador(nombreAlimento)) {
			this.setTipo(TipoAlimento.ACHICADOR);
			alimentoClasificado = true;
			return alimentoClasificado;
		} else if (verificarSiEsAgrandador(nombreAlimento)) {
			this.setTipo(TipoAlimento.AGRANDADOR);
			alimentoClasificado = true;
			return alimentoClasificado;
		} else
			throw new AlimentoNoExisteException("No produce efectos");

	}

	public boolean verificarSiEsAgrandador(String nombreAlimento) {
		Boolean esAgrandador = false;
		for (AlimentoAgrandador alimento : AlimentoAgrandador.values()) {
			if (alimento.name().equalsIgnoreCase(nombreAlimento))
				esAgrandador = true;
		}
		return esAgrandador;
	}

	public Boolean verificarSiEsAchicador(String nombreAlimento) {
		Boolean esAchicador = false;
		for (AlimentoAchicador alimento : AlimentoAchicador.values()) {
			if (alimento.name().equalsIgnoreCase(nombreAlimento))
				esAchicador = true;
		}
		return esAchicador;

	}
	@Override
	public int compareTo(Alimento a) {
		
		return this.getNombre().compareTo(a.getNombre());
		
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alimento [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + "]";
	}

	
}
