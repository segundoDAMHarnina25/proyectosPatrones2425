package modelo.data;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.enums.EspeciePez;

public class Puerto {
	private Long id;
	private String nombre;
	private Coordenada sitio;
	private List<InfoPesca> infoPescas;
	private PropertyChangeSupport pcs;
	//Hay que hacer un monton de consultas en java 8 con estas estadisticas
	
	public Puerto(Long id, String nombre, Coordenada sitio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sitio = sitio;
		this.infoPescas = new ArrayList();
		pcs=new PropertyChangeSupport(this);
	}

	public void compraPescado(InfoPesca infoPesca) {
		infoPescas.add(infoPesca);
		Map<EspeciePez, Double> collect = infoPescas.stream()
			.collect(Collectors.groupingBy(InfoPesca::getEspeciePez,Collectors.summingDouble(InfoPesca::getCantidad)));
		List<EspeciePez> collect2 = collect.entrySet().stream()
			.filter(entry->entry.getValue()>entry.getKey().getMaximaCantidadPorTipo())
			.map(Entry::getKey)
			.collect(Collectors.toList());
		collect2.stream().forEach(especie->pcs.firePropertyChange("limite",null,especie));			
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Coordenada getSitio() {
		return sitio;
	}

	public List<InfoPesca> getInfoPescas() {
		return infoPescas;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
}
