package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import model.Adulto;
import model.Menor;
import model.Ser;

class seresTest {

	@Test
	void testVida() {
		Ser ser=new Menor(17f);
		System.out.println(ser.toString());
		System.out.print("esperanza vida"+ser.getEsperanzaVida());
		System.out.println(" necesidad vital"+ser.getNecesidadVital());
		for (int i = 0; i < 120&&ser.isAlive(); i++) {
			if(ser.vivir(100))
				System.out.print(" "+ser.getEdad());
			//SONDEO o POLLING preguntar todo el tiempo si ha
			//habido un cambio
			if(ser.pasaAAdulto()) {
				System.out.println();
				ser=new Adulto(ser);
				System.out.println(ser.toString());
			}
			if(ser.pasaAAnciano()){
				System.out.println();
				ser=new Ser(ser);
				System.out.println("anciano "+ser.toString());
			}
		}
		System.out.println();
		System.out.println("esperanza final "+ser.getEsperanzaVida());
	}
	@Test
	void testalimentacion() {
		Ser ser=new Menor(100f);
		System.out.println(ser.toString());
		float esperanzaVidaInicial = ser.getEsperanzaVida();
		System.out.print("esperanza vida"+esperanzaVidaInicial);
		System.out.println(" necesidad vital"+ser.getNecesidadVital());
		int sueldo = 30;
		for (int i = 0; i < 120&&ser.isAlive(); i++) {
			if(ser.vivir(sueldo))
				System.out.print(" "+ser.getEdad());
			//SONDEO o POLLING preguntar todo el tiempo si ha
			//habido un cambio
			if(ser.pasaAAdulto()) {
				System.out.println();
				ser=new Adulto(ser);
				System.out.println(ser.toString());
			}
			if(ser.pasaAAnciano()){
				System.out.println();
				ser=new Ser(ser);
				System.out.println("anciano "+ser.toString());
			}
		}
		System.out.println();
		System.out.println("esperanza final "+ser.getEsperanzaVida());
		float i = ser.getNecesidadVital()/sueldo;
		float f = esperanzaVidaInicial/i;
		float esperanzaVida = ser.getEsperanzaVida();
		assertTrue(f>esperanzaVida);
	}
}
