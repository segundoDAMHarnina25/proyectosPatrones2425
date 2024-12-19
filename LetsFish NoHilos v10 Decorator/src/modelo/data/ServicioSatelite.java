// Servicio Satélite
package modelo.data;


import java.util.List;

public class ServicioSatelite {
    private List<Cardumen> cardumenes;
    private static ServicioSatelite servicioSatelite;
    private ServicioSatelite(List<Cardumen> cardumenes) {
        this.cardumenes=cardumenes;
    }

    public List<Cardumen> obtenerInformeDiario() {
        return cardumenes;
    }
      
	public Coordenada getPosicion(Cardumen cardumen) {
		return cardumen.getPosicion();
	}
	
	public static ServicioSatelite getInstance(Mar mar) {
		if(servicioSatelite==null)
			servicioSatelite=new ServicioSatelite(mar.getCardumenes());
		return servicioSatelite;
	}
}
