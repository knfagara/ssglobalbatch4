package org.ssglobal.training.codes.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestProfile {
	
	private Profile profile;
	
	// Setup and initialization 
	// fixtures
	
	@BeforeAll
	public static void superSetup() {
		//System.out.println("super setup");
		
	}
	
	@AfterAll
	public static void superTeardown() {
		//System.out.println("super teardown");
	}
	
	@BeforeEach
	public void setup() {
		profile = new Profile();
	}
	
	@AfterEach
	public void teardown() { // for garbage collect
		profile = null;
	}
	
	
	
	
	// Test cases in the form of methods
	@Test
	public void testShowProfile() {
		String expectedRec = "Maria 90";
		String actualRec = profile.showProfile();
		assertNotEquals(expectedRec, actualRec);
		System.out.println(actualRec);
	}
	
	@Test
	public void testIncreaseAge() {
		int expectedAge = 28;
		int actualAge = profile.increaseAge(10);
		assertEquals(expectedAge, actualAge);
		System.out.println(actualAge);
	}
}
