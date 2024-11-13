package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	IPokedex iPokedex;
	IPokemonMetadataProvider pokemonProvider;
	IPokemonFactory pokemonFactory;
	
	@BeforeEach
	void setup() {
		//iPokedex=Mockito.mock(IPokedex.class);
		pokemonProvider=Mockito.mock(IPokemonMetadataProvider.class);
		pokemonFactory=Mockito.mock(IPokemonFactory.class);
		iPokedex=new Pokedex(pokemonProvider,pokemonFactory);
		
	}
	
	@Test
	public void testSize() {
		//Mockito.when(iPokedex.size()).thenReturn(2);
		
		int size=iPokedex.size();
		
		assertEquals(0,size);
	}
	
	@Test
	public void testAddPokemon() {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);

		//Mockito.when(iPokedex.addPokemon(aqualiData)).thenReturn(133);
		
		int index=iPokedex.addPokemon(aqualiData);
		
		assertEquals(0,index);
	
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		
		//Mockito.when(iPokedex.getPokemon(133)).thenReturn(aqualiData);
		
		int pokemon=iPokedex.addPokemon(aqualiData);
		Pokemon aquali=iPokedex.getPokemon(0);
		
		assertEquals(133,aquali.getIndex());
	
	}
	
	@Test 
	//test de l'invalidité d'un index 
	public void testGetPokemonInvalidIndex()throws PokedexException {
		// Simuler une PokedexException pour un index invalide
		//Mockito.when(iPokedex.getPokemon(155)).thenThrow(new PokedexException("index invalide"));
		
		PokedexException exception=assertThrows(PokedexException.class,()->{
			iPokedex.getPokemon(155);
		});
		assertEquals("index invalide",exception.getMessage());
	}
	
	@Test
	public void tesGetPokemons() {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Pokemon bulbizarreData= new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		
		//List<Pokemon> pokemons=new ArrayList<>();
		//pokemons.add(aqualiData);
		//pokemons.add(bulbizarreData);
		
		iPokedex.addPokemon(aqualiData);
		iPokedex.addPokemon(bulbizarreData);
		
		//Mockito.when(iPokedex.getPokemons()).thenReturn(pokemons);
		
		List<Pokemon> pokemonsResult=iPokedex.getPokemons();
		
		//vérification de la taille de la liste
		assertEquals(2,pokemonsResult.size());
		assertEquals("Aquali",pokemonsResult.get(0).getName());
		assertEquals("Bulbizarre",pokemonsResult.get(1).getName());
	}
	
	@Test
	public void testGetPokemonsWithComparator() {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Pokemon bulbizarreData= new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		/*List<Pokemon> pokemons=new ArrayList<>();
		pokemons.add(aqualiData);
		pokemons.add(bulbizarreData);
		pokemons.sort(PokemonComparators.INDEX); //comparaison selon l'indice*/
		
		//liste triée selon l'index
		//Mockito.when(iPokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemons);
		
		iPokedex.addPokemon(aqualiData);
		iPokedex.addPokemon(bulbizarreData);
		
		List<Pokemon> pokemonsResult=iPokedex.getPokemons(PokemonComparators.INDEX);
		assertEquals("Bulbizarre",pokemonsResult.get(0).getName());
		assertEquals("Aquali",pokemonsResult.get(1).getName());
	}
	
	
	@Test
	public void testGetPokemonMetadata()throws PokedexException {
		
		PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		//récuperation des données de Bulbizarre

		 Mockito.when(pokemonProvider.getPokemonMetadata(0)).thenReturn(bulbizarre);
		 
		
		assertEquals(0,bulbizarre.getIndex());
		assertEquals("Bulbizarre",bulbizarre.getName());
		assertEquals(126,bulbizarre.getAttack());
		assertEquals(126,bulbizarre.getDefense());
		assertEquals(90,bulbizarre.getStamina());			
	}
	
	@Test
	public void testCreatePokemon() throws PokedexException {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		
		Mockito.when(pokemonProvider.getPokemonMetadata(133)).thenReturn(aqualiData);
		//création d' Aquali
		Pokemon aquali =new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		Mockito.when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
	
		Pokemon result=pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
		
		assertNotNull(result);
		assertEquals(133,result.getIndex());
		assertEquals("Aquali",result.getName());
		assertEquals(186,result.getAttack());
		assertEquals(168,result.getDefense());
		assertEquals(260,result.getStamina());
		assertEquals(2729,result.getCp());
		assertEquals(202,result.getHp());
		assertEquals(5000,result.getDust());
		assertEquals(4,result.getCandy());
		assertEquals(100,result.getIv());		
	}
}
