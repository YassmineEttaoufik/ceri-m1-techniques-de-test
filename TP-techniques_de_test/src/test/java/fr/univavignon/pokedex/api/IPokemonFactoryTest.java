package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	IPokemonFactory iPokemonFactory;
	IPokemonFactory iPokemonFactory2;
	IPokemonMetadataProvider metadataProvider;
	
	@BeforeEach
	void setup() {
		metadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
		//iPokemonFactory=Mockito.mock(IPokemonFactory.class);
		iPokemonFactory=new PokemonFactory(metadataProvider);
		iPokemonFactory2=new RocketPokemonFactory();
		
	}
	
	@Test
	public void testCreatePokemon() throws PokedexException {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		
		//Mockito.when(iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aqualiData);
		Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
		//création d' Aquali
		Pokemon aquali=iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
		//test de RocketPokemonFactory
		Pokemon aquali2=iPokemonFactory2.createPokemon(133, 2729, 202, 5000, 4);
	
		assertNotNull(aquali);
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
		
		//test de RocketPokemonFactory
		assertNotNull(aquali2);
		assertEquals(133,aquali2.getIndex());
		assertEquals("Aquali",aquali2.getName());
		assertEquals(2729,aquali2.getCp());
		assertEquals(202,aquali2.getHp());
		assertEquals(5000,aquali2.getDust());
		assertEquals(4,aquali2.getCandy());
		assertEquals(1,aquali2.getIv());		
	}
	
	//test de l'invalidité des paramètres
	@Test
		public void testCreatePokemonInvalidParameter() throws PokedexException{
		//Pokemon bulbiData= new Pokemon(-1,"Unknown", 0,0,0,-613, -64, -4000, -4,0);
		//Mockito.when(iPokemonFactory.createPokemon(-1, -613, -64, -4000, -4)).thenReturn(bulbiData);
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Mockito.when(metadataProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
				
		//index invalide
		Pokemon bulbi=iPokemonFactory.createPokemon(-133, 2729, 202, 5000, 4);
		assertNull(bulbi);
		
		//test de RocketPokemonFactory
		Pokemon bulbiR=iPokemonFactory2.createPokemon(-133, 2729, 202, 5000, 4);
		assertNull(bulbiR);
		
		//cp invalide
		Pokemon bulbi1=iPokemonFactory.createPokemon(133, -2729, 202, 5000, 4);
		assertNull(bulbi1);	
		
		//test de RocketPokemonFactory
		Pokemon bulbiR1=iPokemonFactory2.createPokemon(133, -2729, 202, 5000, 4);
		assertNull(bulbiR1);	
		
		//hp invalide
		Pokemon bulbi2=iPokemonFactory.createPokemon(133, 2729, -202, 5000, 4);
		assertNull(bulbi2);	
		
		//test de RocketPokemonFactory
		Pokemon bulbiR2=iPokemonFactory2.createPokemon(133, 2729, -202, 5000, 4);
		assertNull(bulbiR2);	
		
		//dust invalide
		Pokemon bulbi3=iPokemonFactory.createPokemon(133, 2729, 202, -5000, 4);
		assertNull(bulbi3);	
		
		//test de RocketPokemonFactory
		Pokemon bulbiR3=iPokemonFactory2.createPokemon(133, 2729, 202, -5000, 4);
		assertNull(bulbiR3);
		
		//candy invalide
		Pokemon bulbi4=iPokemonFactory.createPokemon(133, 2729, 202, 5000, -4);
		assertNull(bulbi4);	
		
		//test de RocketPokemonFactory
		Pokemon bulbiR4=iPokemonFactory2.createPokemon(133, 2729, 202, 5000, -4);
		assertNull(bulbiR4);	
		}
}
