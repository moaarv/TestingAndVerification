package Phase1Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Phase1.CarController;


class CarControllerTest {

	CarController car = new CarController();

	@Test
	void testMoveForwardLowerBoundsExceptionNotParked() {
		boolean thrown = false;
		try {
			car.pos = -1;
			car.parked = 0;
			car.MoveForward();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing pos -1, not parked",thrown);
	}		
	@Test
	void testMoveForwardLowerBoundsExceptionParked() {	
		boolean thrown = false;
		try {
			car.pos = -1;
			car.parked = 1;
			car.MoveForward();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing pos -1, parked",thrown);		
	}
	@Test
	void testMoveForwardPos0NotParked() {	
		car.pos = 0;
		car.parked = 0;
		assertEquals(1, car.MoveForward(),"Testing pos 0, not parked");
	}
	@Test
	void testMoveForwardPos0Parked() {
		car.pos = 0;
		car.parked = 1;
		assertEquals(0, car.MoveForward(),"Testing pos 0, parked");
	}
	@Test
	void testMoveForwardPos250NotParked() {
		car.pos = 250;
		car.parked = 0;
		assertEquals(251, car.MoveForward(),"Testing pos 250, not parked");
	}
	@Test
	void testMoveForwardPos250Parked() {
		car.pos = 250;
		car.parked = 1;
		assertEquals(250, car.MoveForward(),"Testing pos 250, parked");
	}
	@Test
	void testMoveForwardPos500NotParked() {
		car.pos = 500;
		car.parked = 0;
		assertEquals(500, car.MoveForward(),"Testing pos 500, not parked");
	}
	@Test
	void testMoveForwardPos500Parked() {
		car.pos = 500;
		car.parked = 1;
		assertEquals(500, car.MoveForward(),"Testing pos 500, parked");
	}
	@Test
	void testMoveForwardUpperBoundsExceptionNotParked() {	
		boolean thrown = false;
		try {
			car.pos = 501;
			car.parked = 0;
			car.MoveForward();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing pos 501, not parked",thrown);
	}
	@Test
	void testMoveForwardUpperBoundsExceptionParked() {			
		boolean thrown = false;
		try {
			car.pos = 501;
			car.parked = 1;
			car.MoveForward();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing pos 501, parked",thrown);
	}

	
	@Test
	void testisEmpty() {
		boolean thrown = false;
		try {
			car.sensorValue1 = new int[]{-1,-1,-1,-1,-1};
			car.sensorValue2 = new int[]{100,100,100,100,100};
			car.isEmpty();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing avg sensorValue -1:100",thrown);
		thrown = false;
		try {
			car.sensorValue1 = new int[]{100,100,100,100,100};
			car.sensorValue2 = new int[]{-1,-1,-1,-1,-1};
			car.isEmpty();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing avg sensorValue 100:-1",thrown);
		thrown = false;
		try {
			car.sensorValue1 = new int[]{-1,-1,-1,-1,-1};
			car.sensorValue2 = new int[]{-1,-1,-1,-1,-1};
			car.isEmpty();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing avg sensorValue -1:-1",thrown);
		car.sensorValue1 = new int[]{0,0,0,0,0};
		car.sensorValue2 = new int[]{0,0,0,0,0};
		assertFalse("Testing isEmpty with average 0:0", car.isEmpty());
		car.sensorValue1 = new int[]{0,0,0,0,0};
		car.sensorValue2 = new int[]{100,100,100,100,100};
		assertFalse("Testing isEmpty with average 0:100", car.isEmpty());
		car.sensorValue1 = new int[]{0,0,0,0,0};
		car.sensorValue2 = new int[]{200,200,200,200,200};
		assertFalse("Testing isEmpty with average 0:200", car.isEmpty());
		car.sensorValue1 = new int[]{100,100,100,100,100};
		car.sensorValue2 = new int[]{0,0,0,0,0};
		assertFalse("Testing isEmpty with average 100:0", car.isEmpty());
		car.sensorValue1 = new int[]{100,100,100,100,100};
		car.sensorValue2 = new int[]{100,100,100,100,100};
		assertFalse("Testing isEmpty with average 100:100", car.isEmpty());
		car.sensorValue1 = new int[]{100,100,100,100,100};
		car.sensorValue2 = new int[]{200,200,200,200,200};
		assertFalse("Testing isEmpty with average 100:200", car.isEmpty());
		car.sensorValue1 = new int[]{200,200,200,200,200};
		car.sensorValue2 = new int[]{0,0,0,0,0};
		assertFalse("Testing isEmpty with average 200:0", car.isEmpty());
		car.sensorValue1 = new int[]{200,200,200,200,200};
		car.sensorValue2 = new int[]{100,100,100,100,100};
		assertFalse("Testing isEmpty with average 200:100", car.isEmpty());
		car.sensorValue1 = new int[]{200,200,200,200,200};
		car.sensorValue2 = new int[]{200,200,200,200,200};
		assertTrue("Testing isEmpty with average 200:200", car.isEmpty());
		car.sensorValue1 = new int[]{0,50,0,0,100};
		car.sensorValue2 = new int[]{0,0,0,0,0};
		assertFalse("Testing isEmpty with with noise on sens1", car.isEmpty());		
		car.sensorValue1 = new int[]{0,0,0,0,0};
		car.sensorValue2 = new int[]{50,0,100,0,0};
		assertFalse("Testing isEmpty with with noise on sens2", car.isEmpty());
		thrown = false;
		try {
			car.sensorValue1 = new int[]{201,201,201,201,201};
			car.sensorValue2 = new int[]{100,100,100,100,100};
			car.isEmpty();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing avg sensorValue 201:100",thrown);
		thrown = false;
		try {
			car.sensorValue1 = new int[]{100,100,100,100,100};
			car.sensorValue2 = new int[]{201,201,201,201,201};
			car.isEmpty();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing avg sensorValue 100:201",thrown);
		thrown = false;
		try {
			car.sensorValue1 = new int[]{201,201,201,201,201};
			car.sensorValue2 = new int[]{201,201,201,201,201};
			car.isEmpty();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing avg sensorValue 201:201",thrown);
	}
	
	@Test
	void testMoveBackwardLowerBoundsExceptionNotParked() {
		boolean thrown = false;
		try {
			car.pos = -1;
			car.parked = 0;
			car.MoveBackward();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing pos -1, not parked",thrown);
	}
	@Test
	void testMoveBackwardLowerBoundsExceptionParked() {
		boolean thrown = false;
		try {
			car.pos = -1;
			car.parked = 1;
			car.MoveBackward();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
	}
	@Test
	void testMoveBackwardPos0NotParked() {	
		car.pos = 0;
		car.parked = 0;
		assertEquals(0, car.MoveBackward(),"Testing pos 0, not parked");
	}
	@Test
	void testMoveBackwardPos0Parked() {	
		car.pos = 0;
		car.parked = 1;
		assertEquals(0, car.MoveBackward(),"Testing pos 0, parked");
	}
	@Test
	void testMoveBackwardPos250NotParked() {	
		car.pos = 250;
		car.parked = 0;
		assertEquals(249, car.MoveBackward(),"Testing pos 250, not parked");
	}
	@Test
	void testMoveBackwardPos250Parked() {	
		car.pos = 250;
		car.parked = 1;
		assertEquals(250, car.MoveBackward(),"Testing pos 250, parked");
	}
	@Test
	void testMoveBackwardPos500NotParked() {	
		car.pos = 500;
		car.parked = 0;
		assertEquals(499, car.MoveBackward(),"Testing pos 500, not parked");
	}
	@Test
	void testMoveBackwardPos500Parked() {	
		car.pos = 500;
		car.parked = 1;
		assertEquals(500, car.MoveBackward(),"Testing pos 500,parked");
	}	
	@Test
	void testMoveBackwardUpperBoundsExceptionNotParked() {
		boolean thrown = false;
		try {
			car.pos = 501;
			car.parked = 0;
			car.MoveBackward();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing pos 501, not parked",thrown);
	}
	@Test
	void testMoveBackwardUpperBoundsExceptionParked() {
		boolean thrown = false;
		try {
			car.pos = 501;
			car.parked = 1;
			car.MoveBackward();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing pos 501, parked",thrown);
	}
	
	@Test
	void testPark() {
		boolean thrown = false;
		try {
			car.isEmptyCount = -1;
			car.parked = 0;
			car.Park();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing isEmptyCount -1, not parked",thrown);
		thrown = false;
		try {
			car.isEmptyCount = -1;
			car.parked = 1;
			car.Park();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing isEmptyCount -1, parked",thrown);
		car.isEmptyCount = 0;
		car.parked = 0;
		car.Park();
		assertEquals(0, car.parked,"Testing isEmptyCount 0, not parked");
		car.isEmptyCount = 0;
		car.parked = 1;
		car.Park();
		assertEquals(1, car.parked,"Testing isEmptyCount 0, parked");
		car.isEmptyCount = 2;
		car.parked = 0;
		car.Park();
		assertEquals(0, car.parked,"Testing isEmptyCount 2, not parked");
		car.isEmptyCount = 2;
		car.parked = 1;
		car.Park();
		assertEquals(1, car.parked,"Testing isEmptyCount 2, parked");
		car.isEmptyCount = 5;
		car.parked = 0;
		car.Park();
		assertEquals(1, car.parked,"Testing isEmptyCount 5, not parked");
		car.isEmptyCount = 5;
		car.parked = 1;
		car.Park();
		assertEquals(1, car.parked,"Testing isEmptyCount 5, parked");
		thrown = false;
		try {
			car.isEmptyCount = 6;
			car.parked = 0;
			car.Park();
		}catch (IndexOutOfBoundsException e) {
		thrown = true;
		}
		assertTrue("Testing isEmptyCount 6, not parked",thrown);
		thrown = false;
		try {
			car.isEmptyCount = 6;
			car.parked = 1;
			car.Park();
		} catch (IndexOutOfBoundsException e) {
			thrown = true;
		}
		assertTrue("Testing isEmptyCount 6, parked",thrown);
	}
	
	@Test
	void testUnPark() {
		car.parked = 0;
		car.UnPark();
		assertEquals(0, car.parked,"Testing that we are not parked");
		car.parked = 1;
		car.UnPark();
		assertEquals(0, car.parked,"Testing that we are not parked");
	}
	
}
