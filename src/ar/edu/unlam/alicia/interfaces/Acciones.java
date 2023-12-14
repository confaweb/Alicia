package ar.edu.unlam.alicia.interfaces;

import ar.edu.unlam.alicia.enums.TipoAlimento;
import ar.edu.unlam.alicia.exceptions.DineroInsuficienteEception;
import ar.edu.unlam.alicia.exceptions.EfectoAnuladoException;
import ar.edu.unlam.alicia.exceptions.SinDineroDisponibleEception;
import ar.edu.unlam.alicia.alimento.Alimento;

public interface Acciones {
void comprar( Alimento alimento) throws SinDineroDisponibleEception, DineroInsuficienteEception;
Boolean alimentarse(Alimento alimento) throws EfectoAnuladoException;

}
