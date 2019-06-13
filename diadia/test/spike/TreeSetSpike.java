package spike;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TreeSetSpike {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOrdinamento_dueAttrezziCheRisultanoUgualiVengonoInseritiEntrambiNelSet() {
		SortedSet<Attrezzo> set = new TreeSet<Attrezzo>(new Comparator<Attrezzo>() {

			@Override
			public int compare(Attrezzo o1, Attrezzo o2) {
				return o1.getPeso() - o2.getPeso();
			}
		});
		
		set.add(new Attrezzo("piuma", 0));
		set.add(new Attrezzo("ventaglio", 0));
		
		assertSame(2, set.size());
	}

}
