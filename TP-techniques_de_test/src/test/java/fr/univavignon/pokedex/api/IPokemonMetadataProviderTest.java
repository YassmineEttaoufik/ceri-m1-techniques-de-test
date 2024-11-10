package fr.univavignon.pokedex.api;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonMetadataProviderTest {
	IPokemonMetadataProvider iPokemonMetadataProvider;
	
	@BeforeEach
	void setup() {
		//iPokemonMetadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
		iPokemonMetadataProvider=new PokemonMetadataProvider();
	}
	
	@Test
	public void testGetPokemonMetadata()throws PokedexException {
		//PokemonMetadata bulbizarreData= new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		//Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreData);
		
		//récuperation des données de Bulbizarre
		PokemonMetadata bulbizarre=iPokemonMetadataProvider.getPokemonMetadata(0);
		
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(126,bulbizarre.getAttack());
		assertEquals(126,bulbizarre.getDefense());
		assertEquals(90,bulbizarre.getStamina());

		
		
	}
	
	@Test 
	//test de l'invalidité d'un index 
	public void testGetPokemonMetadataInvalidIndex()throws PokedexException {
		// Simuler une PokedexException pour un index invalide
		//Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(155)).thenThrow(new PokedexException("index invalide"));
		
		//indice supérieur à 151
		assertThrows(PokedexException.class,()->{
			iPokemonMetadataProvider.getPokemonMetadata(155);
		});
		
		//indice négatif
		assertThrows(PokedexException.class,()->{
			iPokemonMetadataProvider.getPokemonMetadata(-155);
		});
		
	}
	
	
	
}
