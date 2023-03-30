package pokemon;

/* Types.java
 * Contains all the information for the pokemon types.
 */
public class Types {

	public enum types {
		NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE,
		DRAGON, DARK;
	}
	
	 // Contains the values for what type advantage will deal in extra damage 
	public enum EffectValues {
		INEFFECTIVE(0.0), WEAK(0.5), NEUTRAL(1.0), ADVANTAGE(2.0);

		private double value;

		EffectValues(final double newValue) {
			value = newValue;
		}

		public double getValue() {
			return value;
		}

		// Type chart comes from Bulbapedia type charts https://bulbapedia.bulbagarden.net/wiki/Type/Type_chart
		
		private static final EffectValues neut = EffectValues.NEUTRAL;
		private static final EffectValues weak = EffectValues.WEAK;
		private static final EffectValues adv = EffectValues.ADVANTAGE;
		private static final EffectValues inef = EffectValues.INEFFECTIVE;
		
		private static final EffectValues genII[][] =
			    {
			             // norm  fght  fly   pois  grnd  rock  bug   ghst  stel  fire  wter  grss  elec  psyc  ice   drag  dark
			    /* norm */ {neut, adv , neut, neut, neut, neut, neut, inef, neut, neut, neut, neut, neut, neut, neut, neut, neut},
			    /* fght */ {neut, neut, adv , neut, neut, neut, neut, inef, neut, neut, neut, neut, neut, neut, neut, neut, neut},
			    /* fly  */ {neut, weak, neut, neut, inef, adv , weak, neut, neut, neut, neut, weak, adv , neut, adv , neut, neut},
			    /* pois */ {neut, weak, neut, weak, adv , neut, weak, neut, neut, neut, neut, weak, neut, adv , neut, neut, neut},
			    /* grnd */ {neut, neut, neut, weak, neut, weak, neut, neut, neut, neut, adv , adv , inef, neut, adv , neut, neut},
			    /* rock */ {weak, adv , weak, weak, adv , neut, neut, neut, neut, neut, adv , adv , neut, neut, neut, neut, neut},
			    /* bug  */ {neut, weak, adv , neut, weak, adv , neut, neut, neut, adv , neut, weak, neut, neut, neut, neut, neut},
			    /* ghst */ {inef, inef, neut, weak, neut, neut, weak, neut, neut, neut, neut, neut, neut, neut, neut, neut, adv },
			    /* stel */ {weak, adv , weak, inef, adv , weak, weak, weak, weak, adv , neut, weak, neut, weak, weak, weak, weak},
			    /* fire */ {neut, neut, neut, neut, adv , adv , weak, neut, weak, weak, adv , weak, neut, neut, weak, neut, neut},
			    /* wter */ {neut, neut, neut, neut, neut, neut, neut, neut, weak, weak, weak, adv , adv , neut, weak, neut, neut},
			    /* grss */ {neut, neut, adv , adv , weak, neut, adv , neut, neut, adv , weak, weak, weak, neut, adv , neut, neut},
			    /* elec */ {neut, neut, weak, neut, adv , neut, neut, neut, weak, neut, neut, neut, weak, neut, neut, neut, neut},
			    /* psyc */ {neut, weak, neut, neut, neut, neut, adv , adv , neut, neut, neut, neut, neut, weak, neut, neut, adv },
			    /* ice  */ {neut, adv , neut, neut, neut, adv , neut, neut, adv , adv , neut, neut, neut, neut, weak, neut, neut},
			    /* drag */ {neut, neut, neut, neut, neut, neut, neut, neut, neut, weak, weak, weak, weak, neut, adv , adv , neut},
			    /* dark */ {neut, adv , neut, neut, neut, adv , weak, neut, neut, neut, neut, neut, neut, inef, neut, neut, weak}
			             // norm  fght  fly   pois  grnd  rock  bug   ghst  stel  fire  wter  grss  elec  psyc  ice   drag  dark
			    };
		
		public static EffectValues getTypeAdvantage(types defenseType, types attackType) {
		        return genII[defenseType.ordinal()][attackType.ordinal()];
		}
		
	}
}
