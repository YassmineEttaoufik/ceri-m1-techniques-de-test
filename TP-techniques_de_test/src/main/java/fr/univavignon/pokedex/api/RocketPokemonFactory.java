package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;

public class RocketPokemonFactory implements IPokemonFactory {
	
	private static Map<Integer, String> index2name;
	static {
		Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        aMap.put(133, "Aquali");
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
	}
	
	private static int generateRandomStat() {
		return new Random().nextInt(16);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		if ( cp >0 && hp >0 && dust >0 && candy >0){ 
		String name;
		if(!index2name.containsKey(index)) {
			name = index2name.get(0);
		} else {
			name = index2name.get(index);
		}
		int attack;
		int defense;
		int stamina;
		double iv;
		if(index < 0) {
			attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0;
		} else {
			attack = RocketPokemonFactory.generateRandomStat();
			defense = RocketPokemonFactory.generateRandomStat();
			stamina = RocketPokemonFactory.generateRandomStat();
			iv = 1;
		}
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);}
		return null;
	}

}