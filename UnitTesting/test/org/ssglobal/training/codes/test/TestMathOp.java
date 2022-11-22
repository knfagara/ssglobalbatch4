package org.ssglobal.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ssglobal.training.codes.MathOp;

public class TestMathOp {
	
	private MathOp math;
	
	@BeforeEach
	public void setup() {
		math = new MathOp();
	}
	
	
	@AfterEach
	public void teardown() {
		math = null;
	}
	
	@ParameterizedTest
	@ValueSource(ints = {100, 50, 90, 10, 0, -1, -5, -10})
	public void testDivide(int param) {
		int expectedValue = 10;
	
		// exception testing
		try {
			int actualValue = math.divide(10, param);
			assertEquals(expectedValue, actualValue);
		}catch (Exception e) {
			fail("Did not apply try-catch.");
		}
	}
	
	@ParameterizedTest
	@MethodSource("createParams")
	public void testDivideTwoParams(DivideParams param) {
		//int expectedValue = 10;
		try {
			int actualValue = math.divide(param.getxParam(), param.getyParam());
			assertEquals(param.getExpectedValue(), actualValue);
		}catch (Exception e) {
			fail("Did not apply try-catch.");
		}
	}
	
	@Test
	public void testDivideNew() {
		int expectedValue = 10;
		
		assertDoesNotThrow(() -> {
			int actualValue = math.divide(10, 0);
			assertEquals(expectedValue, actualValue);
		}, "Did not apply try-catch.");
	}
	
	public static Stream<DivideParams> createParams(){
		return Stream.of(new DivideParams(10, 10, 1), 
						new DivideParams(-10, 5, -2), 
						new DivideParams(3, 0, 0));
	}
}

class DivideParams{
	
	public DivideParams(int xParam, int yParam, int expectedValue) {
		this.xParam = xParam;
		this.yParam = yParam;
		this.setExpectedValue(expectedValue);
	}
	
	private int xParam;
	private int yParam;
	private int expectedValue;
	
	public int getxParam() {
		return xParam;
	}
	public void setxParam(int xParam) {
		this.xParam = xParam;
	}
	public int getyParam() {
		return yParam;
	}
	public void setyParam(int yParam) {
		this.yParam = yParam;
	}
	public int getExpectedValue() {
		return expectedValue;
	}
	public void setExpectedValue(int expectedValue) {
		this.expectedValue = expectedValue;
	}
}
