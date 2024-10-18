package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	IPokedex iPokedex;
	
	@BeforeEach
	void setup() {
		iPokedex=Mockito.mock(IPokedex.class);
	}
	
	@Test
	public void testSize() {
		Mockito.when(iPokedex.size()).thenReturn(2);
		
		int size=iPokedex.size();
		
		assertEquals(2,size);
	}
	
	@Test
	public void testAddPokemon() {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		
		Mockito.when(iPokedex.addPokemon(aqualiData)).thenReturn(133);
		
		int index=iPokedex.addPokemon(aqualiData);
		
		assertEquals(133,index);
	
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		
		Mockito.when(iPokedex.getPokemon(133)).thenReturn(aqualiData);
		
		Pokemon aquali=iPokedex.getPokemon(133);
		
		assertEquals(133,aquali.getIndex());
	
	}
	
	@Test 
	//test de l'invalidité d'un index 
	public void testGetPokemonInvalidIndex()throws PokedexException {
		// Simuler une PokedexException pour un index invalide
		Mockito.when(iPokedex.getPokemon(155)).thenThrow(new PokedexException("index invalide"));
		
		PokedexException exception=assertThrows(PokedexException.class,()->{
			iPokedex.getPokemon(155);
		});
		assertEquals("index invalide",exception.getMessage());
	}
	
	@Test
	public void tesGetPokemons() {
		Pokemon aqualiData= new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		Pokemon bulbizarreData= new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		List<Pokemon> pokemons=new ArrayList<>();
		pokemons.add(aqualiData);
		pokemons.add(bulbizarreData);
		
		Mockito.when(iPokedex.getPokemons()).thenReturn(pokemons);
		
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
		List<Pokemon> pokemons=new ArrayList<>();
		pokemons.add(aqualiData);
		pokemons.add(bulbizarreData);
		pokemons.sort(PokemonComparators.INDEX); //comparaison selon l'indice
		
		//liste triée selon l'index
		Mockito.when(iPokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemons);
		
		List<Pokemon> pokemonsResult=iPokedex.getPokemons(PokemonComparators.INDEX);
		assertEquals("Bulbizarre",pokemonsResult.get(0).getName());
		assertEquals("Aquali",pokemonsResult.get(1).getName());
	}
}
