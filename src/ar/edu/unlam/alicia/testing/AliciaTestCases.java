package ar.edu.unlam.alicia.testing;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unlam.alicia.alimento.Alimento;
import ar.edu.unlam.alicia.enums.TipoAlimento;
import ar.edu.unlam.alicia.exceptions.AlimentoNoExisteException;
import ar.edu.unlam.alicia.exceptions.DineroInsuficienteEception;
import ar.edu.unlam.alicia.exceptions.EfectoAnuladoException;
import ar.edu.unlam.alicia.exceptions.SinDineroDisponibleEception;
import ar.edu.unlam.alicia.persona.Alicia;
import ar.edu.unlam.alicia.persona.Persona;

public class AliciaTestCases {
/*
 * Alicia en el País de las Maravillas
Se desea hacer una aplicación que simule algunos de los aspectos de dicho cuento.
Para que Alicia pueda hacer una fiesta al Sombrero Loco y festejar el “Feliz No
Cumpleaños” decide ir al supermercado y comprar algunas cosas especiales.
Nuestro personaje Alicia, cuenta con las siguientes características:
 Altura,
 Peso,
 Nombre,
 Edad,
 Dinero para comprar

Se desea implementar la aplicación bajo ciertas restricciones:

- El personaje al momento de comprar los alimentos en el supermercado no puede
excederse de la cantidad de dinero que posee, en caso de excederse no dejara
comprar ni seguir gastando.
- Los productos que nuestro personaje compra en el supermercado son todos
Alimentos de distinto tipo:
- Achicadores (Cuando se consumen tienen la habilidad de encoger a nuestro
personaje 50 cms)
 Masitas, Alfajores, Bagels
- Agrandadores (Cuando se consumen tiene la habilidad de hacer crecer a
nuestro personaje 40 cms)
 Bocaditos de Chocolate, Caramelos, Gomitas.
- A medida que los alimentos son consumidos, estos se eliminan de los alimentos
disponibles para consumir.

Ya en la fiesta, Alicia decide probar las cosas que compró en el supermercado bajo ciertas
condiciones:

- Altura Inicial de Alicia 180 cm
- A medida que consume alimentos se debe modificar automáticamente la altura del
personaje
- No puede crecer más de 280cm, en caso de querer consumir un alimento que lo
supere el máximo de altura no deberá sumar.
- No puede encogerse más de 50cm, en caso de querer consumir un alimento que
supere el mínimo de altura no deberá restar
- Los alimentos que encogen deben ser ordenados por nombre de manera descendente 


El alumno podrá agregar todos atributos y/o generar métodos adicionales que
considere necesarios para alcanzar dicha solución.
- Se pide como test unitarios:

1) Que, al comprar un alimento, se descuente el dinero disponible
2) Que no se exceda del dinero disponible
3) Que, al consumir un alimento, verificar que se agrande
4) Que al consumir un alimento verificar que se encoja
5) Que al consumir alimentos verificar que no se pueda agrandar más de
280cm
6) Que al consumir alimentos verificar que no se pueda achicar menos de
50cm
7) Verificar que la colección de alimentos quede ordenada por nombre de
manera descendente 



 */
	@Test   //#1
	public void queSePuedaCrearAlicia() {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,dinero=1000.0;
		String nombre="Alicia";
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
//		VALIDACION
		assertNotNull(alicia);
	}
	@Test   //#2
	public void queSePuedaDefinirTipoDeAlimentoSegunSuNombre()throws AlimentoNoExisteException {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,precio=100.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="Masitas";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		
		caramelos.definirTipoAlimentoPorNombre(nombreAlimento);
			
		
//		VALIDACION
		
		TipoAlimento ve=tipo.ACHICADOR;
		TipoAlimento vo=caramelos.getTipo();
		assertEquals(ve,vo);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test  //#3
	(expected=AlimentoNoExisteException.class)
	public void queLanceEsceptionSiNoSePuedaDefinirTipoDeAlimentoSegunSuNombre()throws AlimentoNoExisteException {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,precio=100.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="SANDWICH";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		
		caramelos.definirTipoAlimentoPorNombre(nombreAlimento);
			
		
//		VALIDACION
		
		TipoAlimento ve=tipo.ACHICADOR;
		TipoAlimento vo=caramelos.getTipo();
		assertEquals(ve,vo);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#4
	public void queAlComprarSeResteDineroDisponible()throws AlimentoNoExisteException, SinDineroDisponibleEception, DineroInsuficienteEception {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,precio=400.0,precio1=500.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="Masitas",nombreAlimento1="alfajores";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento1, precio1, tipo);
		
		caramelos.definirTipoAlimentoPorNombre(nombreAlimento);		
		alicia.comprar(caramelos);
		alicia.comprar(alfajores);
			
		
//		VALIDACION
		
		Double ve=100.0;
		Double vo=alicia.getDinero();
		assertEquals(ve,vo);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#5
	(expected=DineroInsuficienteEception.class)
	public void queNoSeExcedaDelDineroDisponible()throws AlimentoNoExisteException, SinDineroDisponibleEception, DineroInsuficienteEception {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,precio=400.0,precio1=500.0,dinero=800.0;
		String nombre="Alicia",nombreAlimento="Masitas",nombreAlimento1="alfajores";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento1, precio1, tipo);
		
		caramelos.definirTipoAlimentoPorNombre(nombreAlimento);		
		alicia.comprar(caramelos);
		alicia.comprar(alfajores);
			
		
//		VALIDACION
		
		Double ve=100.0;
		Double vo=alicia.getDinero();
		assertEquals(ve,vo);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#6
	public void queAlConsumirUnAlimentoVerificarQueSeAgrande()throws AlimentoNoExisteException, SinDineroDisponibleEception, DineroInsuficienteEception, EfectoAnuladoException {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,precio=400.0,precio1=500.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="caramelos",nombreAlimento1="alfajores";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento1, precio1, tipo);
		
		
		alicia.comprar(caramelos);
		caramelos.definirTipoAlimentoPorNombre(nombreAlimento);
		alicia.alimentarse(caramelos);
			
		
//		VALIDACION
		
		Double ve=2.3;
		Double vo=alicia.getAltura();
		assertEquals(ve,vo,.01);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#7
	public void queAlConsumirUnAlimentoVerificarQueSeAchiuqe()throws AlimentoNoExisteException, SinDineroDisponibleEception, DineroInsuficienteEception, EfectoAnuladoException {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =1.8,peso =55.0,precio=400.0,precio1=500.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="caramelos",nombreAlimento1="alfajores";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento1, precio1, tipo);
		
		
		
		caramelos.definirTipoAlimentoPorNombre(alfajores.getNombre());
		alicia.alimentarse(alfajores);
			
		
//		VALIDACION
		
		Double ve=1.3;
		Double vo=alicia.getAltura();
		assertEquals(ve,vo,.01);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#8
	(expected=EfectoAnuladoException.class)
	public void queNosePuedaAgrandarMasDe_280()throws AlimentoNoExisteException, SinDineroDisponibleEception, DineroInsuficienteEception, EfectoAnuladoException {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =2.4,peso =55.0,precio=400.0,precio1=500.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="caramelos",nombreAlimento1="alfajores";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento1, precio1, tipo);
		
		
		alicia.comprar(caramelos);
		caramelos.definirTipoAlimentoPorNombre(nombreAlimento);
		alicia.alimentarse(caramelos);
			
		
//		VALIDACION
		
		Double ve=2.3;
		Double vo=alicia.getAltura();
		assertEquals(ve,vo,.01);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#9
	(expected=EfectoAnuladoException.class)
	public void qqueNoSePuedaAchicarMenosDe050()throws AlimentoNoExisteException, SinDineroDisponibleEception, DineroInsuficienteEception, EfectoAnuladoException {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =0.9,peso =55.0,precio=400.0,precio1=500.0,dinero=1000.0;
		String nombre="Alicia",nombreAlimento="caramelos",nombreAlimento1="alfajores";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		
//		EJECUCION
		
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento1, precio1, tipo);
		
		
		
		caramelos.definirTipoAlimentoPorNombre(alfajores.getNombre());
		alicia.alimentarse(alfajores);
			
		
//		VALIDACION
		
		Double ve=1.3;
		Double vo=alicia.getAltura();
		assertEquals(ve,vo,.01);
//		assertTrue(caramelos.verificarSiEsAgrandador(nombreAlimento));
	}
	@Test   //#10
	
	public void queLaColeccionDealimentosQuedeOrdenadaDescendente() {
		
//		PREPARACION
		Integer dni=111111;
		Double altura =0.9,peso =55.0,precio=400.0,precio1=500.0,dinero=1000.0;
		String nombreAlimento="caramelos",nombreAlimento1="masitas",nombreAlimento2="alfajores",nombreAlimento3="bagels",
				nombreAlimento4="gomitas",nombreAlimento5="bocaditos",nombre="Alicia";//Achicadores: Masitas, Alfajores, Bagels;   Agrandadores:Bocaditos de Chocolate, Caramelos, Gomitas.
		TipoAlimento tipo=null;
		List<Alimento> listaDeAlimentos;
		
		
//		EJECUCION
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
		
		 listaDeAlimentos=new ArrayList<Alimento>();
		
		Alimento caramelos = new Alimento(nombreAlimento, precio, tipo);
		Alimento masitas = new Alimento(nombreAlimento1, precio, tipo);
		Alimento alfajores = new Alimento(nombreAlimento2, precio, tipo);
		Alimento bagels = new Alimento(nombreAlimento3, precio, tipo);
		Alimento gomitas = new Alimento(nombreAlimento4, precio, tipo);
		Alimento bocaditos = new Alimento(nombreAlimento5, precio, tipo);
		
		
		
		
		alicia.agregarAlimentoaAlista(caramelos);
		alicia.agregarAlimentoaAlista(masitas);
		alicia.agregarAlimentoaAlista(alfajores);
		alicia.agregarAlimentoaAlista(bagels);
		alicia.agregarAlimentoaAlista(gomitas);
		alicia.agregarAlimentoaAlista(bocaditos);
		
		((Alicia) alicia).ordenarLista(listaDeAlimentos);
		
		
			
		
//		VALIDACION
		
		
		((Alicia) alicia).mostrarLista();
		

	
	}
		


}
