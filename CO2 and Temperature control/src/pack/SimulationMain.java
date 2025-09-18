package pack;
import java.util.Scanner;

public class SimulationMain {
	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	CapteurCO2 CapteurCo2 = new CapteurCO2();
	CapteurTemp CapteurTemp = new CapteurTemp();
	int valTemp = 22;
	int CCo2 = 1000;
	Controleur Controler = new Controleur();
	
	CapteurCo2.attach(Controler);
	CapteurTemp.attach(Controler);
	
	
	while(true) {
	System.out.print("Entrez une nouvelle temperature ");
	
	valTemp = keyboard.nextInt();
	CapteurTemp.setEtat(valTemp);
	
	
	
	
	
	System.out.print("Entrez une nouvelle concentration de CO2 ");
	
	CCo2 = keyboard.nextInt();
	CapteurCo2.setEtat(CCo2);
	
	
	
	
	}
	}
}
