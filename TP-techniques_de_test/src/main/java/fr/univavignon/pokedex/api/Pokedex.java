package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
	List<Pokemon> pokemons;
	IPokemonMetadataProvider pokemonProvider;
	IPokemonFactory pookemonFactory;
	
	public Pokedex (IPokemonMetadataProvider pokemonProvider, IPokemonFactory pokemonFactory) {
		this.pokemons= new ArrayList<>();
		this.pokemonProvider=pokemonProvider;
		this.pookemonFactory=pokemonFactory;
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return pokemonProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pookemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	/**
	 * Renvoie la taille du Pokedex.
	 * 
	 * @return la taille du Pokedex
	 */
	@Override
	public int size() {
		return pokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		pokemons.add(pokemon);
		return pokemons.size()-1;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		if(id<0 || id>pokemons.size()-1 || id>155)
			throw new PokedexException("index invalide");
		return pokemons.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		return Collections.unmodifiableList(pokemons);
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> sortedList= new ArrayList<>(pokemons);
		sortedList.sort(order);
		return sortedList;
	}

	
}
