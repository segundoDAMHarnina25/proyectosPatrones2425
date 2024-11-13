package model.data.state;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import model.data.being.Adult;
import model.data.being.Being;
import model.data.being.Young;

/**
 * En la version v3 quiero quitar el controlPara cambiar de edad
 */
public class State  {
	private ArrayList<ArrayList<Being>> all;
	private ArrayList<Being> youngs = new ArrayList<>();
	private ArrayList<Being> adults = new ArrayList<>();
	private ArrayList<Being> ancients = new ArrayList<>();
	private int initialPopulation = 10;
	private PropertyChangeListener adultChangeListener
	,ancientChangeListener;
	public State(int initialPopulation) {
		this.initialPopulation=initialPopulation;
		prepareState();
	}
	
	public State() {
		super();
		prepareState();
		
	}

	private void createListeners() {
		adultChangeListener=(being)->{
			applyLambda(being,youngs,adults);
		};
		ancientChangeListener=(being)->{
			applyLambda(being,adults,ancients);
		};
	}

	private void applyLambda(PropertyChangeEvent being, List<Being> source,List<Being> destination) {
		Being remove = source.remove(source.indexOf(being));
		destination.add(remove);
	}
	
	private void prepareState() {
		youngs = new ArrayList<>();
		adults = new ArrayList<>();
		ancients = new ArrayList<>();
		all = new ArrayList();
		all.add(youngs);
		all.add(adults);
		all.add(ancients);
		raisePopulation();
	}

	private void raisePopulation() {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being();
			e.addPropertyAdultChangeListener(adultChangeListener);
			e.addPropertyAncientChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	private void raisePopulation(int lifeExpenctancy) {
		for (int i = 0; i < initialPopulation; i++) {
			youngs.add(new Being(lifeExpenctancy));
		}
	}

	public void developWorld(int years) {
		for (int i = 0; i < years; i++) {
			feed();
			bury();
		}
	}
	
	//Problema porque el estado hace un sondeo sobre TODOS los seres
	void x() {
		for (Iterator iterator = youngs.iterator(); iterator.hasNext();) {
			Being being = (Being) iterator.next();
			if(!(being.getBehaviour() instanceof Young)) {
				iterator.remove();
				adults.add(being);
			}
		}
	}
	private void bury() {
		// sacar a los muertos
		all.forEach(list -> list.removeIf(being -> !being.isAlive()));
	}

	private void feed() {
		all.stream().flatMap(Collection::stream).forEach(being -> being.live(being.getVitalNecesity()));
	}
}
