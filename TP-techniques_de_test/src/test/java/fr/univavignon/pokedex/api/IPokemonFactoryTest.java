package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	IPokemonFactory iPokemonFactory;
	
	@BeforeEach
	void setup() {
		iPokemonFactory=Mockito.mock(IPokemonFactory.class);
	}
	
	
}
