package pack;

import java.util.ArrayList;
import java.util.List;

public abstract class Capteurs {
	private int etat;
	//private int pastEtat;  À REVOIR
	private List<CapteurObserver> observers = new ArrayList<CapteurObserver>();
	
	
	public int getEtat() {
		return etat;
	}
	
	public void setEtat(int etat) {
		this.etat = etat;
		notifyAllObservers();
	}
	
	public void attach(CapteurObserver observer){
	    observers.add(observer);       
	}

	public void notifyAllObservers(){
	    for (CapteurObserver observer : observers) {
	            observer.update(this);
	        }
	} 
}
