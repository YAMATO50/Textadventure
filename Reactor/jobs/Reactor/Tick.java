package jobs.Reactor;

public class Tick {

	static int lastFuelRodAmount;
	static int fuelRodAmountChange;
	
	static int lastControllRodDepth;
	static int controllRodDepthChange;
	
	static int lastTemperature;
	static int temperatureChange;
	
	public static void firstTick() {
		lastFuelRodAmount = FuelRodReader.fuelRodAmount;
		lastControllRodDepth = ControllRodDepthReader.controllRodDepth;
		lastTemperature = TemperatureReader.temperature;
	}
	
	public static void tick() {
		
		fuelRodAmountChange = fuelRodAmountChange + (FuelRodReader.fuelRodAmount - lastFuelRodAmount);
		controllRodDepthChange = controllRodDepthChange + (ControllRodDepthReader.controllRodDepth - lastControllRodDepth);

		int change = fuelRodAmountChange;
		fuelRodAmountChange = fuelRodAmountChange - change;
		TemperatureReader.temperature = TemperatureReader.temperature + (10 * change);
		PowerReader.power = PowerReader.power + (100 * change);

		change = controllRodDepthChange / 5;
		TemperatureReader.temperature = TemperatureReader.temperature - (3 * change);
		PowerReader.power = PowerReader.power - (10 * controllRodDepthChange);
		controllRodDepthChange = controllRodDepthChange - (change * 5);
		
		temperatureChange = temperatureChange + (TemperatureReader.temperature - lastTemperature);
		
		change = temperatureChange;
		PowerReader.power = PowerReader.power - change;
		temperatureChange = temperatureChange - change;
		
		lastFuelRodAmount = FuelRodReader.fuelRodAmount;
		lastControllRodDepth = ControllRodDepthReader.controllRodDepth;
		lastTemperature = TemperatureReader.temperature;
		
	}
	
	static int simulatedLastFuelRodAmount;
	static int simulatedFuelRodAmountChange;
	
	static int simulatedLastControllRodDepth;
	static int simulatedControllRodDepthChange;
	
	static int simulatedLastTemperature;
	static int simulatedTemperatureChange;
	
	public static void simulatedFirstTick() {
		simulatedLastFuelRodAmount = FuelRodReader.fuelRodAmount;
		simulatedLastControllRodDepth = ControllRodDepthReader.controllRodDepth;
		simulatedLastTemperature = TemperatureReader.temperature;
	}
	
	public static void simulatedTick() {
		
		simulatedFuelRodAmountChange = simulatedFuelRodAmountChange + (FuelRodReader.fuelRodAmount - simulatedLastFuelRodAmount);
		simulatedControllRodDepthChange = simulatedControllRodDepthChange + (ControllRodDepthReader.controllRodDepth - simulatedLastControllRodDepth);
		

		int change = simulatedFuelRodAmountChange;
		simulatedFuelRodAmountChange = simulatedFuelRodAmountChange - change;
		TemperatureReader.temperature = TemperatureReader.temperature + (10 * change);
		PowerReader.power = PowerReader.power + (100 * change);

		change = simulatedControllRodDepthChange / 5;
		TemperatureReader.temperature = TemperatureReader.temperature - (3 * change);
		PowerReader.power = PowerReader.power - (10 * simulatedControllRodDepthChange);
		simulatedControllRodDepthChange = simulatedControllRodDepthChange - (change * 5);
		
		simulatedTemperatureChange = simulatedTemperatureChange + (TemperatureReader.temperature - simulatedLastTemperature);
		
		change = simulatedTemperatureChange;
		PowerReader.power = PowerReader.power - change;
		simulatedTemperatureChange = simulatedTemperatureChange - change;
		
		simulatedLastFuelRodAmount = FuelRodReader.fuelRodAmount;
		simulatedLastControllRodDepth = ControllRodDepthReader.controllRodDepth;
		simulatedLastTemperature = TemperatureReader.temperature;
		
	}
}
