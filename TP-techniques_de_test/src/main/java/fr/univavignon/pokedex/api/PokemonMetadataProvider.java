package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * PokemonMetadataProvider.
 *
 * @author Yassmine Et taoufik
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider{
	/** list of metadata of pokemons. **/
	static List<PokemonMetadata> pokemonMetadata = new ArrayList<>();
	
	/** 
	 * Initialization of metadata of a pokemon. 
	 **/
	static {
	    pokemonMetadata.add(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
	}

    /**
	  * Retrieves and returns the metadata for the pokemon
	  * denoted by the given <code>index</code>.
	  *
	  * @param index Index of the pokemon to retrieve metadata for.
	  * @return Metadata of the pokemon.
	  * @throws PokedexException If the given <code>index</code> is not valid.
	  */
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		if (index<0 || index>=pokemonMetadata.size())
			throw new PokedexException("index invalide");
		PokemonMetadata pokemon = pokemonMetadata.get(index);
		return pokemon;
	}
	

}
