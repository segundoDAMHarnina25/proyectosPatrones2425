package ejemploPersonaje;

public class PrincipalTres {
public static void main(String[] args) {
	Personaje uno=new Aldeano();
	uno=new Armadura(uno);
	uno=new Armadura(uno);
	uno=new Armadura(uno);
	Golpe golpe = new Golpe(100);
	Personaje golpear = golpe.golpear(uno);
	System.err.println(golpear.mostrarArmadura());
}
}
