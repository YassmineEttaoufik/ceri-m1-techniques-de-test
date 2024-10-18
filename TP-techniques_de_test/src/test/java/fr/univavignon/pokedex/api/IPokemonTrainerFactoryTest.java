package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	IPokemonTrainerFactory iPokemonTrainerFactory;
	
	
	@BeforeEach
	void setup() {
		iPokemonTrainerFactory=Mockito.mock(IPokemonTrainerFactory.class);
		
	}
	
	@Test
	void testCreateTrainer() {	
		IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
		IPokedex  iPokedex=Mockito.mock(IPokedex.class);
		
		//création d'un PokemonTrainer
		PokemonTrainer trainer=new PokemonTrainer("Ash",Team.INSTINCT,iPokedex);
		Mockito.when(iPokemonTrainerFactory.createTrainer("Ash", Team.INSTINCT, ipokedexFactory)).thenReturn(trainer);
		
		
		PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("Ash",Team.INSTINCT,ipokedexFactory);
	
		assertEquals("Ash",trainerResult.getName());
		assertEquals(Team.INSTINCT,trainerResult.getTeam());
		assertEquals(iPokedex,trainerResult.getPokedex());
		
	}
	
	@Test
	void testCreateTrainerWithEmptyName() {			
		//création d'un entraineur sans nom
		IPokedexFactory ipokedexFactory=Mockito.mock(IPokedexFactory.class);
		
		//création d'un PokemonTrainer
		Mockito.when(iPokemonTrainerFactory.createTrainer("", Team.MYSTIC, ipokedexFactory)).thenReturn(null);
		
		PokemonTrainer trainerResult=iPokemonTrainerFactory.createTrainer("",Team.MYSTIC,ipokedexFactory);
		
		assertEquals(null,trainerResult); 
		
	}

}
