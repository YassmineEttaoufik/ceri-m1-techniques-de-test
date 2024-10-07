package fr.univavignon.pokedex.api;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonMetadataProviderTest {
	IPokemonMetadataProvider iPokemonMetadataProvider;
	
	@BeforeEach
	void setup() {
		iPokemonMetadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
	}
	
	@Test
	public void testGetPokemonMetadata()throws PokedexException {
		PokemonMetadata bulbizarreData= new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreData);
		
		//récuperation des données de Bulbizarre
		PokemonMetadata bulbizarre=iPokemonMetadataProvider.getPokemonMetadata(0);
	
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(126,bulbizarre.getAttack());
		assertEquals(126,bulbizarre.getDefense());
		assertEquals(90,bulbizarre.getStamina());

		
	}
	
	
	
}
