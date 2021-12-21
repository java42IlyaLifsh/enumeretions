package telran.util;
//HW_22 IlyaL

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		Length len1 = new Length(300000000, LengthUnit.MM);
		Length len2 = new Length(300, LengthUnit.KM);
		Length len3 = new Length(2, LengthUnit.KM);
		assertTrue(len1.equals(len2));
		assertTrue(len2.equals(len1));
		assertFalse(len1.equals(len3));
		assertFalse(len3.equals(len2));
	}

	@Test
	void testCompareTo() {
		assertEquals(0, new Length(2540, LengthUnit.MM).compareTo(new Length(100, LengthUnit.IN)));
		assertTrue(new Length(3333, LengthUnit.MM).compareTo(new Length(2, LengthUnit.KM))<0);
		assertTrue(new Length(10000000, LengthUnit.MM).compareTo(new Length(9999, LengthUnit.M))>0);
	}

	@Test
	void testConvert() {
		assertEquals(new Length(10f, LengthUnit.FT), 
				new Length(3048, LengthUnit.MM).convert(LengthUnit.FT));
		
	}

	@Test
	void testToString() {
		assertEquals("3,0000FT", new Length(3f, LengthUnit.FT).toString());	
		assertEquals("1,1000M", new Length(1.1f, LengthUnit.M).toString());	
	}
	@Test
	void testBetween() {
		assertEquals( new Length(999999f, LengthUnit.MM),
				LengthUnit.MM.between(new Length(1f, LengthUnit.KM), new Length(1f, LengthUnit.MM)));
	}

}
