package Phase1;
import java.lang.Math;

public class CarController implements ICarController{
	
	public int pos = 0;
	public int parked = 0;
	public int isEmptyCount = 0;
	public int[] sensorValue1 = new int[5];
	public int[] sensorValue2 = new int[5];
	public static void main(String[] args) {

	}

	@Override
	public int MoveForward() {
		//Catch an error if we have a pos that is out of bounds.
		if(pos < 0 || pos > 500 ) {
			throw new IndexOutOfBoundsException("pos " + "is out of bounds!");
		}
		//Add 1 to pos if position is within range.
		if(pos <  500 && parked == 0 )
			pos = pos+1;
		return pos;				
	}
	
	@Override
	public boolean isEmpty() {
		int sens1 = 0;
		int sens2 = 0;
		int count1 = 0,count2 = 0;
		//Loop through both sensor arrays and checks for values that are inaccurate.
		for (int i = 0; i<4; i++) {
			if(Math.abs(sensorValue1[i]-sensorValue1[i+1]) < 25)
				count1++;
				sens1 += sensorValue1[i];
			if(Math.abs(sensorValue2[i]-sensorValue2[i+1]) < 25)
				count2++;
				sens2 += sensorValue2[i];
		}
		//Takes the average of all the sensorvalues1.
		sens1 = sens1/count1;
		//Check if average is out of bounds.
		if(sens1 < 0 || sens1 > 200 ) {
			throw new IndexOutOfBoundsException("sensor1 " + "is out of bounds!");
		}
		//Takes the average of all the sensorvalues2.
		sens2 = sens2/count2;
		//Check if average is out of bounds.
		if(sens2 < 0 || sens2 > 200 ) {
			throw new IndexOutOfBoundsException("sensor2 " + "is out of bounds!");
		}
		//Check if sensor values indicate that there is a free space
		if(sens1 > 150 && sens2 > 150)
			return true;
		return false;
	}

	@Override
	public int MoveBackward() {
		//Check is pos is out of bounds.
		if(pos < 0 || pos > 500 ) {
			throw new IndexOutOfBoundsException("pos " + "is out of bounds!");
		}
		////Subtract 1 to pos if position is within range.
		if(pos > 0 && parked == 0 )
			pos = pos-1;
		return pos;		
	}

	@Override
	public void Park() {
		//Check if isEmptyCount is out of bounds.
		if(isEmptyCount < 0 || isEmptyCount > 5 ) {
			throw new IndexOutOfBoundsException("isEmptyCount " + "is out of bounds!");
		}	
		//If isEmptyCount is within range, move backwards five times and then park.
		if(isEmptyCount == 5 && parked == 0) {
			for (int i = 0; i<5; i++) {
				pos = MoveBackward();
			}
			parked = 1;
		}
	}
	
	@Override
	public void UnPark() {
		//If we are parked, move forward 5 times and unpark.
		if(parked == 1) {
			for (int i = 0; i<5; i++) {
				pos = MoveForward();
			}
		}
		parked = 0;
	}

	@Override
	public int[] WhereIs() {
		//Just returns the currenct position and if parked or not.
		return new int[] {pos, parked};
	}
}
