package prijemni.gui;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prijemni.OrganizacijaPrijemnogIspita;
import test.TestUtil;

public class PrijemniGUITest {
	
	private PrijemniGUI instance;

	@Before
	public void setUp() throws Exception {
		instance = new PrijemniGUI();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_organizacijaPrijemnog() {
		assertTrue("U klasi nije definisan atribut organizacijaPrijemnog", TestUtil.doesFieldExist(PrijemniGUI.class, "organizacijaPrijemnog"));
	}
	
	@Test
	public void atribut_organizacijaPrijemnog_vidljivost() {
		assertTrue("Atribut organizacijaPrijemnog nije privatan", TestUtil.hasFieldModifier(PrijemniGUI.class, "organizacijaPrijemnog", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_organizacijaPrijemnog_pocetnaVrednost() {
		OrganizacijaPrijemnogIspita organizacijaPrijemnog = (OrganizacijaPrijemnogIspita) TestUtil.getFieldValue(instance, "organizacijaPrijemnog");
		
		assertNotNull("Atribut organizacijaPrijemnog nije inicijalizovan", organizacijaPrijemnog);
	}
}
