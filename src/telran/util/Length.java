package telran.util;
//HW_22 IlyaL

public class Length implements Comparable<Length> {
	float amount;
	LengthUnit unit;
	@Override
	/**
	 * equals two Length objects according to LengthUnit
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		//TODO
		return false;
	}

	@Override
	public int compareTo(Length o) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit unit) {
		//TODO
		return null;
	}
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		//TODO
		return "";
	}
	
	

}
