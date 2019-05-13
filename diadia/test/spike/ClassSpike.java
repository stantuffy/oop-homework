package spike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ClassSpike {

	@Test
	public void testGetClassStessoOggetto() {
		Attrezzo a = new Attrezzo("Attrezzo", 0);
		Attrezzo b = new Attrezzo("Un altro", 0);
		assertSame(a.getClass(), b.getClass());
	}

}
