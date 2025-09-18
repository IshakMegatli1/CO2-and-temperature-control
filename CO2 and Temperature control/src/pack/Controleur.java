package pack;
 //OBSERVER concret 

public class Controleur implements CapteurObserver {
	int etatVentilation = 0; //0= rien 1=Ventilation 
	int etatChauffageClim = 0; // 0= rien 1=Clim 2=chauffage
	
	public int getVentilationEtat() {
		return etatVentilation;
	}
	public int getChauffageClimEtat() {
		return etatChauffageClim;
	}
	
	public void setVentilationEtat(int etat) {
		this.etatVentilation = etat;
	}
	public void setChauffageClimEtat(int etat) {
		this.etatChauffageClim = etat;
	}
	
	@Override
	public void update(Capteurs capteurs) {
		if (capteurs instanceof CapteurTemp) {
			System.out.println("Controleur ---> nouvelle TEMPERATURE : " + capteurs.getEtat() +" °C");
			if (capteurs.getEtat() > 22 && getChauffageClimEtat() != 1) {
				if(getChauffageClimEtat() == 2) {
					System.out.println("Chauffage désactivée");
				}
				System.out.println("Climatisation activée");
				setChauffageClimEtat(1);
			}
			else if (capteurs.getEtat() < 22 && getChauffageClimEtat() != 2) {
				if(getChauffageClimEtat() == 1) {
					System.out.println("Climatisation désactivée");
				}
				System.out.println("Chauffage activée");
				setChauffageClimEtat(2);
			}
			else if (capteurs.getEtat() == 22 && getChauffageClimEtat() == 1) {
				System.out.println("Climatisation désactivée");
				setChauffageClimEtat(0);
			}
			else if (capteurs.getEtat() == 22 && getChauffageClimEtat() == 2) {
				System.out.println("Chauffage désactivée");
				setChauffageClimEtat(0);
			}
			
		}
		else if (capteurs instanceof CapteurCO2) {
			System.out.println("Controleur ---> nouvelle concentration CO2 : " + capteurs.getEtat() + "ppm");
			if (capteurs.getEtat() > 1000 && getVentilationEtat() != 1) {
				System.out.println("Ventilation activée");
				setVentilationEtat(1);
			}
			else if (capteurs.getEtat() <= 1000 && getVentilationEtat() == 1) {
				System.out.println("Ventilation désactivée");
				setVentilationEtat(0);
			}
			
	}
}
}

