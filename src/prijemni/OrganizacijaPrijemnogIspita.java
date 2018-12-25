package prijemni;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import prijemni.izuzeci.PrijemniException;

public class OrganizacijaPrijemnogIspita {

	private List<PrijemniIspit> ustanove = new LinkedList<>();
	
	public void ucitajIzFajlaUListu(String nazivFajla) {
		try {
			ObjectInputStream in = new ObjectInputStream(
										new BufferedInputStream(
											new FileInputStream(nazivFajla)));
			try {
				while (true) {
					PrijemniIspit p = (PrijemniIspit) (in.readObject());
					
					if (p.getBrojPrijavljenih() > 0) {
						ustanove.add(p);
					}
				}
			} catch (Exception ex) {
			}

			// zatvaramo stream
			in.close();
		} catch (Exception ex) {
			throw new PrijemniException("Greska prilikom ucitavanja iz fajla.");
		}
	}
	
	public List<String> vratiUspesnePrijemneIspite() {
		List<String> naziviUstanova = new LinkedList<>();
		
		for (PrijemniIspit prijemni1 : ustanove) {
			
			// ako se podaci o prijemnom ispitu odnose na godinu 2017
			if (prijemni1.getGodinaUpisa() == 2017) {
				
				// pronalazimo da li postoje u listi podaci prijemnog ispita za istu ustanovu (ustanovu 
				// sa istim nazivom) koji se odnose na 2018. godinu i proveravamo da li je broj prijavljenih
				// u 2018. veci od broja prijavljenih u 2017.
				for (PrijemniIspit prijemni2 : ustanove) {
					if (prijemni1.getNazivUstanove().equals(prijemni2.getNazivUstanove()) &&
							prijemni2.getGodinaUpisa() == 2018 &&
							prijemni1.getBrojPrijavljenih() < prijemni2.getBrojPrijavljenih()) {
						
						naziviUstanova.add(prijemni1.getNazivUstanove());
					}
				}
			}
		}
		
		return naziviUstanova;
	}
}
