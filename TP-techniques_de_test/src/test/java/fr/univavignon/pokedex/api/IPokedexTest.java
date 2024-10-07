package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class IPokedexTest {
	IPokedex iPokedex;
	
	@BeforeEach
	void setup() {
		iPokedex=Mockito.mock(IPokedex.class);
	}
}
