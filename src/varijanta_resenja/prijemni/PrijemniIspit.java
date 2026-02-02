package varijanta_resenja.prijemni;

import java.io.Serializable;

import varijanta_resenja.prijemni.izuzeci.PrijemniException;

public class PrijemniIspit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nazivUstanove;
	private int godinaUpisa;
	private int brojMesta;
	private int brojPrijavljenih;

	public String getNazivUstanove() {
		return nazivUstanove;
	}

	public void setNazivUstanove(String nazivUstanove) {
		if (nazivUstanove == null || nazivUstanove.length() < 5) {
			throw new PrijemniException("Naziv ustanove ne moze biti null ili kraci od pet znakova.");
		}
		this.nazivUstanove = nazivUstanove;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		if (godinaUpisa <= 0) {
			throw new PrijemniException("Godina upisa mora biti veca od ili jednaka nula.");
		}
		this.godinaUpisa = godinaUpisa;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		if (brojMesta < 0) {
			throw new PrijemniException("Broj mesta mora biti veci od ili jednak nula.");
		}
		this.brojMesta = brojMesta;
	}

	public int getBrojPrijavljenih() {
		return brojPrijavljenih;
	}

	public void setBrojPrijavljenih(int brojPrijavljenih) {
		if (brojPrijavljenih < 0) {
			throw new PrijemniException("Broj prijavljenih mora biti veci od ili jednak nula.");
		}
		this.brojPrijavljenih = brojPrijavljenih;
	}

	@Override
	public String toString() {
		// cast-ujemo u double da bismo izbegli celobrojno deljenje
		double odnos = (double) brojPrijavljenih / brojMesta;
		
		return "Naziv ustanove: " + nazivUstanove + ", godina upisa: " + godinaUpisa + ", broj mesta: " + brojMesta
				+ ", broj prijavljenih: " + brojPrijavljenih + ", odnos prijavljenih i broja mesta je: " + odnos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PrijemniIspit))
			return false;

		PrijemniIspit pi = (PrijemniIspit) obj;

		return this.nazivUstanove.equals(pi.nazivUstanove) && 
				this.godinaUpisa == pi.godinaUpisa && 
				this.brojMesta == pi.brojMesta && 
				this.brojPrijavljenih == pi.brojPrijavljenih;
	}
	
}
