package prijemni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prijemni.izuzeci.PrijemniException;
import test.TestUtil;

public class PrijemniIspitTest {

	private PrijemniIspit instance;

	@Before
	public void setUp() throws Exception {
		instance = new PrijemniIspit();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_nazivUstanove() {
		assertTrue("U klasi nije definisan atribut nazivUstanove", TestUtil.doesFieldExist(PrijemniIspit.class, "nazivUstanove"));
	}
	
	@Test
	public void atribut_nazivUstanove_vidljivost() {
		assertTrue("Atribut nazivUstanove nije privatan", TestUtil.hasFieldModifier(PrijemniIspit.class, "nazivUstanove", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_godinaUpisa() {
		assertTrue("U klasi nije definisan atribut godinaUpisa", TestUtil.doesFieldExist(PrijemniIspit.class, "godinaUpisa"));
	}
	
	@Test
	public void atribut_godinaUpisa_vidljivost() {
		assertTrue("Atribut godinaUpisa nije privatan", TestUtil.hasFieldModifier(PrijemniIspit.class, "godinaUpisa", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_brojMesta() {
		assertTrue("U klasi nije definisan atribut brojMesta", TestUtil.doesFieldExist(PrijemniIspit.class, "brojMesta"));
	}
	
	@Test
	public void atribut_brojMesta_vidljivost() {
		assertTrue("Atribut brojMesta nije privatan", TestUtil.hasFieldModifier(PrijemniIspit.class, "brojMesta", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_brojPrijavljenih() {
		assertTrue("U klasi nije definisan atribut brojPrijavljenih", TestUtil.doesFieldExist(PrijemniIspit.class, "brojPrijavljenih"));
	}
	
	@Test
	public void atribut_brojPrijavljenih_vidljivost() {
		assertTrue("Atribut brojPrijavljenih nije privatan", TestUtil.hasFieldModifier(PrijemniIspit.class, "brojPrijavljenih", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setNazivUstanove() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		String nazivUstanove = (String) TestUtil.getFieldValue(instance, "nazivUstanove");
		assertEquals("Nakon poziva metode setNazivUstanove(String) sa prosledjenim argumentom \"Fakultet organizacionih nauka\", vrednost atributa nazivUstanove se nije promenila na tu vrednost", "Fakultet organizacionih nauka", nazivUstanove);
	}
	
	@Test(expected = PrijemniException.class)
	public void metoda_setNazivUstanove_null()  {
		instance.setNazivUstanove(null);
	}
	
	@Test(expected = PrijemniException.class)
	public void metoda_setNazivUstanove_kraceOd5Karaktera() {
		instance.setNazivUstanove("FON");
	}
	
	@Test
	public void metoda_getNazivUstanove() {
		String nazivUstanove = (String) TestUtil.getFieldValue(instance, "nazivUstanove");

		assertEquals("Metoda getNazivUstanove() ne vraca vrednost atributa nazivUstanove", nazivUstanove, instance.getNazivUstanove());
	}
	
	@Test
	public void metoda_setGodinaUpisa() {
		instance.setGodinaUpisa(2018);
		int godinaUpisa = (int) TestUtil.getFieldValue(instance, "godinaUpisa");
		assertEquals("Nakon poziva metode setBrojOdraslih(int) sa prosledjenim argumentom \"2018\", vrednost atributa godinaUpisa se nije promenila na tu vrednost", 2018, godinaUpisa);
	}
	
	@Test(expected = PrijemniException.class)
	public void metoda_setGodinaUpisa_manjeOdNula() {
		instance.setGodinaUpisa(-1);
	}
	
	@Test
	public void metoda_getGodinaUpisa() {
		int godinaUpisa = (int) TestUtil.getFieldValue(instance, "godinaUpisa");

		assertEquals("Metoda getGodinaUpisa() ne vraca vrednost atributa godinaUpisa", godinaUpisa, instance.getGodinaUpisa());
	}
	
	@Test
	public void metoda_setBrojMesta() {
		instance.setBrojMesta(100);
		int brojMesta = (int) TestUtil.getFieldValue(instance, "brojMesta");
		assertEquals("Nakon poziva metode setBrojMesta(int) sa prosledjenim argumentom \"100\", vrednost atributa brojMesta se nije promenila na tu vrednost", 100, brojMesta);
	}
	
	@Test(expected = PrijemniException.class)
	public void metoda_setBrojMesta_manjeOdNula() {
		instance.setBrojMesta(-1);
	}
	
	@Test
	public void metoda_getBrojMesta() {
		int brojMesta = (int) TestUtil.getFieldValue(instance, "brojMesta");
		
		assertEquals("Metoda getBrojMesta() ne vraca vrednost atributa brojMesta", brojMesta, instance.getBrojMesta());
	}
	
	@Test
	public void metoda_setBrojPrijavljenih() {
		instance.setBrojPrijavljenih(1000);
		int brojPrijavljenih = (int) TestUtil.getFieldValue(instance, "brojPrijavljenih");
		assertEquals("Nakon poziva metode setBrojPrijavljenih(int) sa prosledjenim argumentom \"1000\", vrednost atributa brojPrijavljenih se nije promenila na tu vrednost", 1000, brojPrijavljenih);
	}
	
	@Test(expected = PrijemniException.class)
	public void metoda_setBrojPrijavljenih_manjeOdNula() {
		instance.setBrojPrijavljenih(-1);
	}
	
	@Test
	public void metoda_getBrojPrijavljenih() {
		int brojPrijavljenih = (int) TestUtil.getFieldValue(instance, "brojPrijavljenih");
		
		assertEquals("Metoda getBrojPrijavljenih() ne vraca vrednost atributa brojPrijavljenih", brojPrijavljenih, instance.getBrojPrijavljenih());
	}
	
	@Test
	public void metoda_toString() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		instance.setBrojMesta(800);
		instance.setBrojPrijavljenih(1000);
		instance.setGodinaUpisa(2018);
		
		assertTrue("Metoda toString ne vraca vrednost atributa nazivUstanove.", instance.toString().contains("Fakultet organizacionih nauka"));
		assertTrue("Metoda toString ne vraca vrednost atributa godinaUpisa.", instance.toString().contains("2018"));
		assertTrue("Metoda toString ne vraca vrednost atributa brojMesta.", instance.toString().contains("800"));
		assertTrue("Metoda toString ne vraca vrednost atributa brojPrijavljenih.", instance.toString().contains("1.25"));
	}
	
	@Test
	public void metoda_equals_nijeDobraKlasa() {
		assertFalse("Metoda equals() ne vraca false ako se prosledi objekat druge klase.", instance.equals(new Object()));
	}
	
	@Test
	public void metoda_equals_isti() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		instance.setBrojMesta(800);
		instance.setBrojPrijavljenih(1000);
		instance.setGodinaUpisa(2018);
		
		PrijemniIspit pi1 = new PrijemniIspit();
		pi1.setNazivUstanove("Fakultet organizacionih nauka");
		pi1.setBrojMesta(800);
		pi1.setBrojPrijavljenih(1000);
		pi1.setGodinaUpisa(2018);
		
		assertEquals("Metoda equals() ne vraca vrednost true za prosledjen prijemni ispit sa istim vrednostima atributa.", pi1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitNazivUstanove() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		instance.setBrojMesta(800);
		instance.setBrojPrijavljenih(1000);
		instance.setGodinaUpisa(2018);
		
		PrijemniIspit pi1 = new PrijemniIspit();
		pi1.setNazivUstanove("Elektrotehnicki fakultet");
		pi1.setBrojMesta(800);
		pi1.setBrojPrijavljenih(1000);
		pi1.setGodinaUpisa(2018);
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjen prijemni ispit sa razlicitim nazivom ustanove.", pi1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitBrojMesta() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		instance.setBrojMesta(800);
		instance.setBrojPrijavljenih(1000);
		instance.setGodinaUpisa(2018);
		
		PrijemniIspit pi1 = new PrijemniIspit();
		pi1.setNazivUstanove("Fakultet organizacionih nauka");
		pi1.setBrojMesta(700);
		pi1.setBrojPrijavljenih(1000);
		pi1.setGodinaUpisa(2018);
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjen prijemni ispit sa razlicitim brojem mesta.", pi1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitBrojPrijavljenih() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		instance.setBrojMesta(800);
		instance.setBrojPrijavljenih(1000);
		instance.setGodinaUpisa(2018);
		
		PrijemniIspit pi1 = new PrijemniIspit();
		pi1.setNazivUstanove("Fakultet organizacionih nauka");
		pi1.setBrojMesta(800);
		pi1.setBrojPrijavljenih(900);
		pi1.setGodinaUpisa(2018);
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjen prijemni ispit sa razlicitim brojem prijavljenih.", pi1, instance);
	}
	
	@Test
	public void metoda_equals_razlicitaGodinaUpisa() {
		instance.setNazivUstanove("Fakultet organizacionih nauka");
		instance.setBrojMesta(800);
		instance.setBrojPrijavljenih(1000);
		instance.setGodinaUpisa(2018);
		
		PrijemniIspit pi1 = new PrijemniIspit();
		pi1.setNazivUstanove("Fakultet organizacionih nauka");
		pi1.setBrojMesta(800);
		pi1.setBrojPrijavljenih(1000);
		pi1.setGodinaUpisa(2017);
		
		assertNotEquals("Metoda equals() ne vraca vrednost false za prosledjen prijemni ispit sa razlicitom godinom upisa.", pi1, instance);
	}
	
}
