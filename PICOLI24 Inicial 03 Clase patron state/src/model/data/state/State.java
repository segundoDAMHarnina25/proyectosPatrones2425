package model.data.state;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import model.data.being.Adult;
import model.data.being.Being;

/**
 * En la version v3 quiero quitar el controlPara cambiar de edad
 */
public class State {
	private ArrayList<ArrayList<Being>> all;
	private ArrayList<Being> youngs = new ArrayList<>();
	private ArrayList<Being> adults = new ArrayList<>();
	private ArrayList<Being> ancients = new ArrayList<>();

	private int initialPopulation = 100;

	public State(int initialPopulation) {
		this.initialPopulation=initialPopulation;
		prepareState();
	}
	
	public State() {
		super();
		prepareState();
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
			youngs.add(new Being());
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
	
	private void bury() {
		// sacar a los muertos
		all.forEach(list -> list.removeIf(being -> !being.isAlive()));
	}

	private void feed() {
		// ultimo dia del año
		// alimentar con lo necesario
		all.stream().flatMap(Collection::stream).forEach(being -> being.live(being.getVitalNecesity()));
	}
}
