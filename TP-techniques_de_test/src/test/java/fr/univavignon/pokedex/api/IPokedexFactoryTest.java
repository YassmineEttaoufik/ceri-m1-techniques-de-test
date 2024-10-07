package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	IPokedexFactory iPokedexFactory;
	
	@BeforeEach
	void setup() {
		iPokedexFactory=Mockito.mock(IPokedexFactory.class);
	}
}
