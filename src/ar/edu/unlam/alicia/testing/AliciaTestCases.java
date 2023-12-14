package ar.edu.unlam.alicia.testing;
import static org.junit.Assert.*;

import org.junit.Test;

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
	@Test
	public void queSePuedaCrearAlicia() {
		
//		PREPARACION
		Integer dni=111111,dinero=1000;
		Double altura =1.8,peso =55.0;
		String nombre="Alicia";
		
//		EJECUCION
		Persona persona = new Persona(dni,nombre,peso,altura, dinero);
		Persona alicia = new Alicia(dni,nombre,peso,altura,dinero);
//		VALIDACION
		assertNotNull(alicia);
	}

}
