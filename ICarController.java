package Phase1;

public interface ICarController {
	/**
	  Description
	  This method moves the car 1 meter forward, queries the two sensors 
	  through the isEmpty method described below and returns a data structure that contains the current position of the car,  
	  and the situation of the detected parking places up to now. 
	  The car cannot be moved forward beyond the end of the street.
	  Also this method returns the so far detected empty space.
	  Pre-condition: Pos, a variable that holds the position of the car
	  Post-condition: if Pos < 500 then Pos = Pos+1 and return if space is empty
	  Test-cases: 
	  (Input; pos=-1,parked=0; Expected output=Invalid input),(Input; pos=-1,parked=1 Expected output=Invalid input), 
	  (Input; pos=0 ,parked=0; Expected output=1), (Input; pos=0,parked=1 Expected output=0),
	  (Input; pos=250,parked=0; Expected output=251), (Input; pos=250,parked=1 Expected output=250),
	  (Input; pos=500,parked=0; Expected output=500), (Input; pos=500,parked=1 Expected output=500)
	  (Input; pos=501,parked=0; Expected output=Invalid input), (Input; pos=501,parked=1 Expected output=Invalid input)
	*/
	public int MoveForward();
	
	
	/**
	  Description
	  This method queries the two ultrasound sensors at least 5 times and filters the noise in their results and returns the distance to 
	  the nearest object in the right hand side. If one sensor is detected to continuously return very noisy output, 
	  it should be completely disregarded.  
	  You can use averaging or any other statistical method to filter the noise from the signals received from the ultrasound sensors.  
	  Pre-condition: Two sensor values (in the range of 0 to 200) 
	  Post-condition: If the spot to the right is empty, return true else return false
	  Test-cases: 
	  (Input: Sensor1(Avg) = -1, Sensor2(Avg) = 100; Expected output: Invalid input)
      (Input: Sensor1(Avg) = 100, Sensor2(Avg) = -1; Expected output: Invalid input)
      (Input: Sensor1(Avg) = -1, Sensor2(Avg) = -1; Expected output: Invalid input)
      (Input: Sensor1(Avg) = 0, Sensor2(Avg) = 0; Expected output: False)
      (Input: Sensor1(Avg) = 0, Sensor2(Avg) = 100; Expected output: False)
      (Input: Sensor1(Avg) = 0, Sensor2(Avg) = 200; Expected output: False)
      (Input: Sensor1(Avg) = 100, Sensor2(Avg) = 0; Expected output: False)
      (Input: Sensor1(Avg) = 100, Sensor2(Avg) = 100; Expected output: False)
      (Input: Sensor1(Avg) = 100, Sensor2(Avg) = 200; Expected output: False)
      (Input: Sensor1(Avg) = 200, Sensor2(Avg) = 0; Expected output: False)
      (Input: Sensor1(Avg) = 200, Sensor2(Avg) = 100; Expected output: False)
      (Input: Sensor1(Avg) = 200, Sensor2(Avg) = 200; Expected output: False)
      (Input: Sensor1(Avg) = 201, Sensor2(Avg) = 100; Expected output: Invalid input)
      (Input: Sensor1(Avg) = 100, Sensor2(Avg) = 201; Expected output: Invalid input)
      (Input: Sensor1(Avg) = 201, Sensor2(Avg) = 201; Expected output: Invalid input)
	*/
	public boolean isEmpty();
	
	
	/**
	  Description
	  The same as above; only it moves the car 1 meter backwards. 
	  The car cannot be moved behind if it is already at the beginning of the street. 
	  Also this method returns the so far detected empty space. 
	  Pre-condition: Pos, a variable that holds the position of the car
	  Post-condition: if Pos > 0 then Pos = Pos-1 and return if space is empty.
	  Test-cases:
	  (Input; pos=-1,parked=0; Expected output=Invalid input),(Input; pos=-1,parked=1 Expected output=Invalid input), 
	  (Input; pos=0,parked=0; Expected output=0), (Input; pos=0,parked=1 Expected output=0),
	  (Input; pos=250,parked=0; Expected output=249), (Input; pos=250,parked=1 Expected output=250),
	  (Input; pos=500,parked=0; Expected output=499), (Input; pos=500,parked=1 Expected output=500)
	  (Input; pos=501,parked=0; Expected output=Invalid input), (Input; pos=501,parked=1 Expected output=Invalid input)
	*/
	public int MoveBackward();
	
	
	/**
	  Description
	  This method keeps moving the car until space is found or the end of the street reached. 
	  When a parking is possible it moves the car to the beginning of the current 5 meter free stretch of parking place, 
	  Then it performs a pre-programmed reverse parallel parking maneuver. 
	  Pre-condition: We got "true" returned 5 times from the "isEmpty()" method.
	  Post-condition: the "parked" flag is 1. 
	  Test-cases:
	  (Input; isEmptyCount=-1,parked=0; Expected output=Invalid input),(Input; isEmptyCount=-1,parked=1 Expected output=Invalid input), 
	  (Input; isEmptyCount=0,parked=0; Expected output=0),(Input; isEmptyCount=0,parked=1 Expected output=1), 
	  (Input; isEmptyCount=2,parked=0; Expected output=0),(Input; isEmptyCount=2,parked=1 Expected output=1), 
	  (Input; isEmptyCount=5,parked=1; Expected output=0),(Input; isEmptyCount=5,parked=1 Expected output=1), 
	  (Input; isEmptyCount=6,parked=Invalid input; Expected output=0),(Input; isEmptyCount=6,parked=1 Expected output=Invalid input), 
	    
	*/
	public void Park();
	
	
	/**
	  Description
	  It moves the car forward (and to left) to front of the parking place, 
	  if it is parked. 
	  Pre-condition: the parked flag is 1 in order to unpark.
	  Post-condition: parked flag is 0 and position has changed
	  Test-cases:
	  (Input: Parked = 0; Expected output: 0)
      (Input: Parked = 1; Expected output: 0)
	*/
	public void UnPark();
	
	
	/**
	  Description
	  This method returns the current position of the car in the street as well as its situation (whether it is parked or not). 
	  Pre-condition: 
	  Post-condition: returns pos and parked as an int array
	*/
	public int[] WhereIs();
	
}
