package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	IPokemonFactory iPokemonFactory;
	IPokemonMetadataProvider metadataProvider;
	
	@BeforeEach
	void setup() {
		metadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
		//iPokemonFactory=Mockito.mock(IPokemonFactory.class);
		iPokemonFactory=new PokemonFactory(metadataProvider);
		
	}
	
	@Test
	public void testCreatePokemon() throws PokedexException {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		
		//Mockito.when(iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aqualiData);
		Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
		//création d' Aquali
		Pokemon aquali=iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
	
		assertEquals(133,aquali.getIndex());
		assertEquals("Aquali",aquali.getName());
		assertEquals(186,aquali.getAttack());
		assertEquals(168,aquali.getDefense());
		assertEquals(260,aquali.getStamina());
		assertEquals(2729,aquali.getCp());
		assertEquals(202,aquali.getHp());
		assertEquals(5000,aquali.getDust());
		assertEquals(4,aquali.getCandy());
		assertEquals(73,aquali.getIv());		
	}
	
	//test de l'invalidité des paramètres
	@Test
		public void testCreatePokemonInvalidParameter() throws PokedexException{
		//Pokemon bulbiData= new Pokemon(-1,"Unknown", 0,0,0,-613, -64, -4000, -4,0);
		//Mockito.when(iPokemonFactory.createPokemon(-1, -613, -64, -4000, -4)).thenReturn(bulbiData);
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
		Pokemon bulbi=iPokemonFactory.createPokemon(-133, -2729, -202, -5000, -4);
		
		// Vérifier que les paramètres sont positifs
		assertNull(bulbi);
			
		}
}
