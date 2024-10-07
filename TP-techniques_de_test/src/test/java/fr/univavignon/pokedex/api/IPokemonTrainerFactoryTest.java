package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	IPokemonTrainerFactory iPokemonTrainerFactory;
	
	@BeforeEach
	void setup() {
		iPokemonTrainerFactory=Mockito.mock(IPokemonTrainerFactory.class);
	}
	

	
}
