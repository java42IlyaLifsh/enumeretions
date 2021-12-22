package telran.util;
//HW_22 IlyaL

public class Length implements Comparable<Length> {
	public float amount;
	public LengthUnit unit;
	private final static float delta = 0.001f;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	
	@Override
	/**
	 * equals two Length objects according to LengthUnit
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
	
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Length other = (Length) obj;
		if(other.unit != unit) {
			other = other.convert(unit);
		}
		return Math.abs(this.amount-other.amount)<delta;
	
	}

	@Override
	public int compareTo(Length len) {
		
		Length obj = len;
		if(unit!=len.unit) {
			obj = obj.convert(unit);
		}
		if(Math.abs(amount-obj.amount)<delta) {
			return 0;
		}
		return Float.compare(amount, obj.amount);

	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit otherUnit) {
	
		// V.R.  'this' is redundant here
		float factor = (this.unit).getValue()/otherUnit.getValue();
		return new Length(amount*factor, otherUnit);
		
	}
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		// V.R.  'this' is redundant here
		return String.format("%.4f", this.amount) + this.unit.toString();
		// V.R. By the way. delta is defined as 0.001f. May be the format has to be "%.3f"?
	}
	
	
	

}