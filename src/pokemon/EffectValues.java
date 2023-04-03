package pokemon;

//Contains the values for what type advantage will deal in extra damage 
public enum EffectValues {
	INEFFECTIVE(0.0), WEAK(0.5), NEUTRAL(1.0), ADVANTAGE(2.0);

	private double value;

	EffectValues(final double newValue) {
		value = newValue;
	}

	public double getValue() {
		return value;
	}

}
