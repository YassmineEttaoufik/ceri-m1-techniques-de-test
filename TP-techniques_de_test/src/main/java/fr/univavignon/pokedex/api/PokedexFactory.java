package fr.univavignon.pokedex.api;

/**
 * PokedexFactory.
 *
 * @author Yassmine Et taoufik
 */
public class PokedexFactory implements IPokedexFactory {
	
	/**
	 * Creates a new pokedex instance using the given 
	 * <code>metadataProvider</code> and <code>pokemonFactory</code>. 
	 *
	 * @param metadataProvider Metadata provider the created pokedex will use.
	 * @param pokemonFactory Pokemon factory the created pokedex will use.
	 * @return Created pokedex instance.
	 */
	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider,
			IPokemonFactory pokemonFactory) {
		
		return new Pokedex(metadataProvider, pokemonFactory);
	}

}
