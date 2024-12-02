package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Interface representing a Pokedex.
 * A Pokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 */
public class Pokedex implements IPokedex{
	List<Pokemon> pokemons;
	IPokemonMetadataProvider pokemonProvider;
	IPokemonFactory pookemonFactory;
	
	public Pokedex (IPokemonMetadataProvider pokemonProvider, IPokemonFactory pokemonFactory) {
		this.pokemons= new ArrayList<>();
		this.pokemonProvider=pokemonProvider;
		this.pookemonFactory=pokemonFactory;
	}

	/**
	 * Returns the metadata for a given pokemon.
	 *
	 * @param index The index of the pokemon in the Pokedex.
	 * @return The pokemon's metadata.
	 * @throws PokedexException If the pokemon cannot be found.
	 */
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return pokemonProvider.getPokemonMetadata(index);
	}

	/**
	 * Creates a pokemon with specified parameters.
	 *
	 * @param index The index of the pokemon.
	 * @param cp Combat power of the pokemon.
	 * @param hp Health points of the pokemon.
	 * @param dust Amount of dust the pokemon has.
	 * @param candy Amount of candy the pokemon has.
	 * @return The newly created pokemon.
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pookemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	/**
	 * Returns the size of the Pokedex.
	 * 
	 * @return The size of the Pokedex
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

	/**
	 * Retrieves a pokemon by its ID.
	 *
	 * @param id The ID of the pokemon.
	 * @return The pokemon at the given ID.
	 * @throws PokedexException If the ID is invalid.
	 */
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
