package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
	IPokemonMetadataProvider metadataProvider;
	
	public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
		this.metadataProvider=metadataProvider;
	}
	
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		if(index >=0 && cp >0 && hp >0 && dust >0 && candy >0){
			try {
				PokemonMetadata metadata= metadataProvider.getPokemonMetadata(index);
				double iv=(12+10+11)/45.0*100;
				return new Pokemon(index,metadata.getName(),metadata.getAttack(),metadata.getDefense(),metadata.getStamina(),cp,hp,dust,candy,(int)iv);		
			} catch (PokedexException e) {
				e.getMessage();
			}
				
		}
		return null;
	}

	
}
