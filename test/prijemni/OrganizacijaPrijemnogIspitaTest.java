package prijemni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Modifier;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prijemni.izuzeci.PrijemniException;
import test.TestUtil;

public class OrganizacijaPrijemnogIspitaTest {

	private OrganizacijaPrijemnogIspita instance;

	@Before
	public void setUp() throws Exception {
		instance = new OrganizacijaPrijemnogIspita();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_ustanove() {
		assertTrue("U klasi nije definisan atribut ustanove", TestUtil.doesFieldExist(OrganizacijaPrijemnogIspita.class, "ustanove"));
	}

	@Test
	public void atribut_ustanove_vidljivost() {
		assertTrue("Atribut ustanove nije privatan", TestUtil.hasFieldModifier(OrganizacijaPrijemnogIspita.class, "ustanove", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_ucitajIzFajlaUListu() throws Exception {
		PrijemniIspit p1 = new PrijemniIspit();
		p1.setNazivUstanove("Fakultet organizacionih nauka");
		p1.setBrojMesta(800);
		p1.setBrojPrijavljenih(1000);
		p1.setGodinaUpisa(2018);
		
		PrijemniIspit p2 = new PrijemniIspit();
		p2.setNazivUstanove("Elektrotehnicki fakultet");
		p2.setBrojMesta(500);
		p2.setBrojPrijavljenih(600);
		p2.setGodinaUpisa(2018);
		
		PrijemniIspit p3 = new PrijemniIspit();
		p3.setNazivUstanove("Saobracajni fakultet");
		p3.setBrojMesta(500);
		p3.setBrojPrijavljenih(0);
		p3.setGodinaUpisa(2018);
		
		String nazivFajla = "prijemni.out";
		
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(nazivFajla)))) {
			
			out.writeObject(p1);
			out.writeObject(p2);
			out.writeObject(p3);
		} catch (Exception e) {
			throw e;
		}
		
		@SuppressWarnings("unchecked")
		List<PrijemniIspit> ustanove = (List<PrijemniIspit>) TestUtil.getFieldValue(instance, "ustanove");
		int brojElemenata = ustanove.size();
		
		instance.ucitajIzFajlaUListu(nazivFajla);
		int brojElemenata1 = ustanove.size();
		
		assertEquals("Nakon ucitavanja iz fajla gde se nalaze podaci o tri fakulteta, gde je kod jednog broj prijavljenih 0, broj elemenata u listi ustanove se nije uvecao za 2", 2, brojElemenata1 - brojElemenata);
		assertTrue("Nakon ucitavanja iz fajla gde se nalaze podaci o tri fakulteta, gde je kod jednog broj prijavljenih 0, prvi objekat se ne nalazi u listi", ustanove.contains(p1));
		assertTrue("Nakon ucitavanja iz fajla gde se nalaze podaci o tri fakulteta, gde je kod jednog broj prijavljenih 0, drugi objekat se ne nalazi u listi", ustanove.contains(p2));
		
		// brisemo fajl
		new File(nazivFajla).delete();
	}
	
	@Test (expected = PrijemniException.class)
	public void metoda_ucitajIzFajlaUListu_bacaIzuzetak() {
		instance.ucitajIzFajlaUListu("ne postoji fajl.txt");
	}

	@Test
	public void metoda_vratiUspesnePrijemneIspite() {
		PrijemniIspit p1 = new PrijemniIspit();
		p1.setNazivUstanove("Fakultet organizacionih nauka");
		p1.setBrojMesta(800);
		p1.setBrojPrijavljenih(1000);
		p1.setGodinaUpisa(2018);
		
		PrijemniIspit p2 = new PrijemniIspit();
		p2.setNazivUstanove("Fakultet organizacionih nauka");
		p2.setBrojMesta(500);
		p2.setBrojPrijavljenih(600);
		p2.setGodinaUpisa(2017);
		
		PrijemniIspit p3 = new PrijemniIspit();
		p3.setNazivUstanove("Saobracajni fakultet");
		p3.setBrojMesta(500);
		p3.setBrojPrijavljenih(300);
		p3.setGodinaUpisa(2018);
		
		PrijemniIspit p4 = new PrijemniIspit();
		p4.setNazivUstanove("Saobracajni fakultet");
		p4.setBrojMesta(500);
		p4.setBrojPrijavljenih(300);
		p4.setGodinaUpisa(2017);
		
		PrijemniIspit p5 = new PrijemniIspit();
		p5.setNazivUstanove("Elektrotehnicki fakultet");
		p5.setBrojMesta(500);
		p5.setBrojPrijavljenih(300);
		p5.setGodinaUpisa(2017);
		
		@SuppressWarnings("unchecked")
		List<PrijemniIspit> ustanove = (List<PrijemniIspit>) TestUtil.getFieldValue(instance, "ustanove");
		ustanove.add(p1);
		ustanove.add(p2);
		ustanove.add(p3);
		ustanove.add(p4);
		ustanove.add(p5);
		
		List<String> naziviUstanova = instance.vratiUspesnePrijemneIspite();
		
		assertEquals("Nakon dodavanja u listu podataka o sledecim prijemnima: Fakultet organizacionih nauka (mesta: 800, prijavljenih: 1000, godina: 2018), Fakultet organizacionih nauka (mesta: 500, prijavljenih: 600, godina: 2017), Saobracajni fakultet (mesta: 500, prijavljenih: 300, godina: 2018), Saobracajni fakultet (mesta: 500, prijavljenih: 300, godina: 2017),  Elektrotehnicki fakultet (mesta: 500, prijavljenih: 300, godina: 2017), metoda nije vratila samo jedan rezultat.", 1, naziviUstanova.size());
		assertTrue("Nakon dodavanja u listu podataka o sledecim prijemnima: Fakultet organizacionih nauka (mesta: 800, prijavljenih: 1000, godina: 2018), Fakultet organizacionih nauka (mesta: 500, prijavljenih: 600, godina: 2017), Saobracajni fakultet (mesta: 500, prijavljenih: 300, godina: 2018), Saobracajni fakultet (mesta: 500, prijavljenih: 300, godina: 2017),  Elektrotehnicki fakultet (mesta: 500, prijavljenih: 300, godina: 2017), metoda nije vratila Fakultet organizacionih nauka.", naziviUstanova.contains("Fakultet organizacionih nauka"));
	}
}
