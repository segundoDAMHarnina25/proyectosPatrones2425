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
public class State {
	private ArrayList<ArrayList<Being>> all;
	private ArrayList<Being> youngs = new ArrayList<>();
	private ArrayList<Being> adults = new ArrayList<>();

	public ArrayList<Being> getYoungs() {
		return youngs;
	}

	public ArrayList<Being> getAdults() {
		return adults;
	}

	public ArrayList<Being> getAncients() {
		return ancients;
	}

	private ArrayList<Being> ancients = new ArrayList<>();
	private int initialPopulation = 10;
	private PropertyChangeListener adultChangeListener, ancientChangeListener;

	public State(int initialPopulation) {
		this.initialPopulation = initialPopulation;
		prepareState(initialPopulation);
	}

	public State(int initialPopulation, int lifeExpenctacy) {
		this.initialPopulation = initialPopulation;
		prepareState(initialPopulation, lifeExpenctacy);
	}

	public State() {
		super();
		prepareState(initialPopulation);

	}

	private void createListeners() {
		adultChangeListener = (being) -> {
			applyLambda(being, youngs, adults);
		};
		ancientChangeListener = (being) -> {
			applyLambda(being, adults, ancients);
		};
	}

	private void applyLambda(PropertyChangeEvent being, List<Being> source, List<Being> destination) {
		Being remove = source.remove(source.indexOf(being.getNewValue()));
		destination.add(remove);
	}

	private void prepareState(int initialPop) {
		createLists();
		createListeners();
		raisePopulation(initialPop);
	}

	private void prepareState(int initialPop, int lifeExpenctacy) {
		createLists();
		createListeners();
		raisePopulation(initialPop, lifeExpenctacy);
	}

	private void createLists() {
		youngs = new ArrayList<>();
		adults = new ArrayList<>();
		ancients = new ArrayList<>();
		all = new ArrayList();
		all.add(youngs);
		all.add(adults);
		all.add(ancients);
	}

	private void raisePopulation(int initialPopulation, int lifeExpenctancy) {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being(lifeExpenctancy);
			e.addPropertyAdultChangeListener(adultChangeListener);
			e.addPropertyAncientChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	private void raisePopulation(int initialPopulation) {
		for (int i = 0; i < initialPopulation; i++) {
			Being e = new Being();
			e.addPropertyAdultChangeListener(adultChangeListener);
			e.addPropertyAncientChangeListener(ancientChangeListener);
			youngs.add(e);
		}
	}

	public void developWorld(int years) {
		for (int i = 0; i < years; i++) {
			feed();
			bury();
		}
	}

	private void bury() {
		// sacar a los muertos
		all.forEach(list -> list.removeIf(being -> !being.isAlive()));
	}

	//Resulta que un problema d e los streams es que no podemos borrar en una coleccion mientras se 
	//recorre. 
	private void iterateCollectionForLiving(ArrayList<Being> colection) {
		ArrayList<Being> others = (ArrayList<Being>) colection.clone();
		for (Iterator iterator = others.iterator(); iterator.hasNext();) {
			Being being = (Being) iterator.next();
			being.live(being.getVitalNecesity());
		}
	}
	
	private void feed() {
		iterateCollectionForLiving(youngs);
		iterateCollectionForLiving(adults);
		iterateCollectionForLiving(ancients);
	}

}
