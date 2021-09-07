package jobs.Reactor;

public class Tick {

	static int lastFuelRodAmount;
	static int fuelRodAmountChange;
	
	static int lastControllRodDepth;
	static int controllRodDepthChange;
	
	static int lastTemperature;
	static int temperatureChange;
	
	public static void firstTick() {
		lastFuelRodAmount = Parameters.fuelRodAmount;
		lastControllRodDepth = Parameters.controllRodDepth;
		lastTemperature = Parameters.temperature;
	}
	
	public static void tick() {
		
		fuelRodAmountChange = fuelRodAmountChange + (Parameters.fuelRodAmount - lastFuelRodAmount);
		controllRodDepthChange = controllRodDepthChange + (Parameters.controllRodDepth - lastControllRodDepth);

		int change = fuelRodAmountChange;
		fuelRodAmountChange = fuelRodAmountChange - change;
		Parameters.temperature = Parameters.temperature + (10 * change);
		Parameters.power = Parameters.power + (100 * change);

		change = controllRodDepthChange / 5;
		Parameters.temperature = Parameters.temperature - (3 * change);
		Parameters.power = Parameters.power - (10 * controllRodDepthChange);
		controllRodDepthChange = controllRodDepthChange - (change * 5);
		
		temperatureChange = temperatureChange + (Parameters.temperature - lastTemperature);
		
		change = temperatureChange;
		Parameters.power = Parameters.power - change;
		temperatureChange = temperatureChange - change;
		
		lastFuelRodAmount = Parameters.fuelRodAmount;
		lastControllRodDepth = Parameters.controllRodDepth;
		lastTemperature = Parameters.temperature;
		
	}
	
	static int simulatedLastFuelRodAmount;
	static int simulatedFuelRodAmountChange;
	
	static int simulatedLastControllRodDepth;
	static int simulatedControllRodDepthChange;
	
	static int simulatedLastTemperature;
	static int simulatedTemperatureChange;
	
	public static void simulatedFirstTick() {
		simulatedLastFuelRodAmount = Parameters.fuelRodAmount;
		simulatedLastControllRodDepth = Parameters.controllRodDepth;
		simulatedLastTemperature = Parameters.temperature;
	}
	
	public static void simulatedTick() {
		
		simulatedFuelRodAmountChange = simulatedFuelRodAmountChange + (Parameters.fuelRodAmount - simulatedLastFuelRodAmount);
		simulatedControllRodDepthChange = simulatedControllRodDepthChange + (Parameters.controllRodDepth - simulatedLastControllRodDepth);
		

		int change = simulatedFuelRodAmountChange;
		simulatedFuelRodAmountChange = simulatedFuelRodAmountChange - change;
		Parameters.temperature = Parameters.temperature + (10 * change);
		Parameters.power = Parameters.power + (100 * change);

		change = simulatedControllRodDepthChange / 5;
		Parameters.temperature = Parameters.temperature - (3 * change);
		Parameters.power = Parameters.power - (10 * simulatedControllRodDepthChange);
		simulatedControllRodDepthChange = simulatedControllRodDepthChange - (change * 5);
		
		simulatedTemperatureChange = simulatedTemperatureChange + (Parameters.temperature - simulatedLastTemperature);
		
		change = simulatedTemperatureChange;
		Parameters.power = Parameters.power - change;
		simulatedTemperatureChange = simulatedTemperatureChange - change;
		
		simulatedLastFuelRodAmount = Parameters.fuelRodAmount;
		simulatedLastControllRodDepth = Parameters.controllRodDepth;
		simulatedLastTemperature = Parameters.temperature;
		
	}
}
