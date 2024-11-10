package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class IPokedexFactoryTest {
	IPokedexFactory iPokedexFactory;
	
	
	@BeforeEach
	void setup() {
		//iPokedexFactory=Mockito.mock(IPokedexFactory.class);
		iPokedexFactory=new PokedexFactory();
	}
	
	@Test
	public void testCreatePokedex() {
		IPokemonMetadataProvider pokemonMetadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
		IPokemonFactory pokemonFactory=Mockito.mock(IPokemonFactory.class);
		//IPokedex pokedexData=Mockito.mock(IPokedex.class);
		
		//Mockito.when(iPokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedexData);
	
		IPokedex pokedex=iPokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		
		// Vérifie que la méthode retourne bien une instance de IPokedex
		assertNotNull(pokedex);
	}
}
