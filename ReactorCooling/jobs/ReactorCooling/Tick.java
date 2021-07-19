package jobs.ReactorCooling;

public class Tick {

	static int lastFlowRate;
	static int flowRateChange;
	
	static int lastTemperature;
	static int temperatureChange;
	
	static int lastRefluxTemperature;
	static int refluxTemperatureChange;
	
	static int lastReservoirLevel;
	static int reservoirLevelChange;
	
	public static void firstTick() {
		lastFlowRate = FlowRateReader.flowRate;
		lastReservoirLevel = ReservoirLevelReader.reservoirLevel;
		lastTemperature = TemperatureReader.temperature;
		lastRefluxTemperature = RefluxTemperatureReader.temperature;
	}
	
	public static void tick() {
		
		flowRateChange = flowRateChange + (lastFlowRate - FlowRateReader.flowRate);
		reservoirLevelChange = reservoirLevelChange + (lastReservoirLevel - ReservoirLevelReader.reservoirLevel);
		temperatureChange = temperatureChange + (lastTemperature - TemperatureReader.temperature);
		refluxTemperatureChange = refluxTemperatureChange + (lastRefluxTemperature - RefluxTemperatureReader.temperature);

		int change = flowRateChange / 1000;
		ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel + (1 * change);
		RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature + (10 * change);
		flowRateChange = flowRateChange - (change * 1000);

		change = temperatureChange / 5;
		RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature - (2 * change);
		temperatureChange = temperatureChange - (change * 5);
		
		change = refluxTemperatureChange / 10;
		TemperatureReader.temperature = TemperatureReader.temperature - (2 * change);
		refluxTemperatureChange = refluxTemperatureChange - (10 * change);
		
		change = reservoirLevelChange / 10;
		TemperatureReader.temperature = TemperatureReader.temperature + (1 * change);
		reservoirLevelChange = reservoirLevelChange - (10 * change);
		
		lastFlowRate = FlowRateReader.flowRate;
		lastReservoirLevel = ReservoirLevelReader.reservoirLevel;
		lastTemperature = TemperatureReader.temperature;
		lastRefluxTemperature = RefluxTemperatureReader.temperature;
	}
	
	static int simulatedLastFlowRate;
	static int simulatedFlowRateChange;
	
	static int simulatedLastTemperature;
	static int simulatedTemperatureChange;
	
	static int simulatedLastRefluxTemperature;
	static int simulatedRefluxTemperatureChange;
	
	static int simulatedLastReservoirLevel;
	static int simulatedReservoirLevelChange;
	
	public static void simulateFirstTick() {
		simulatedLastFlowRate = FlowRateReader.flowRate;
		simulatedLastReservoirLevel = ReservoirLevelReader.reservoirLevel;
		simulatedLastTemperature = TemperatureReader.temperature;
		simulatedLastRefluxTemperature = RefluxTemperatureReader.temperature;
	}
	
	public static void simulateTick() {
		
		simulatedFlowRateChange = simulatedFlowRateChange + (simulatedLastFlowRate - FlowRateReader.flowRate);
		simulatedReservoirLevelChange = simulatedReservoirLevelChange + (simulatedLastReservoirLevel - ReservoirLevelReader.reservoirLevel);
		simulatedTemperatureChange = simulatedTemperatureChange + (simulatedLastTemperature - TemperatureReader.temperature);
		simulatedRefluxTemperatureChange = simulatedRefluxTemperatureChange + (simulatedLastRefluxTemperature - RefluxTemperatureReader.temperature);

		int change = simulatedFlowRateChange / 1000;
		ReservoirLevelReader.reservoirLevel = ReservoirLevelReader.reservoirLevel + (1 * change);
		RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature + (10 * change);
		simulatedFlowRateChange = simulatedFlowRateChange - (change * 1000);

		//System.out.println(change + "Flow");
		
		change = simulatedTemperatureChange / 5;
		RefluxTemperatureReader.temperature = RefluxTemperatureReader.temperature - (2 * change);
		simulatedTemperatureChange = simulatedTemperatureChange - (change * 5);
		
		//System.out.println(change + "temp");
		
		change = simulatedRefluxTemperatureChange / 10;
		TemperatureReader.temperature = TemperatureReader.temperature - (2 * change);
		simulatedRefluxTemperatureChange = simulatedRefluxTemperatureChange - (10 * change);
		
		//System.out.println(change);
		
		change = simulatedReservoirLevelChange / 10;
		TemperatureReader.temperature = TemperatureReader.temperature + (1 * change);
		simulatedReservoirLevelChange = simulatedReservoirLevelChange - (10 * change);
		
		//System.out.println(change + "res");
		
		simulatedLastFlowRate = FlowRateReader.flowRate;
		simulatedLastReservoirLevel = ReservoirLevelReader.reservoirLevel;
		simulatedLastTemperature = TemperatureReader.temperature;
		simulatedLastRefluxTemperature = RefluxTemperatureReader.temperature;
		
		//System.out.println(simulatedLastFlowRate + "Flow");
		//System.out.println(simulatedLastReservoirLevel + "Res");
		//System.out.println(simulatedLastTemperature + "Temp");
		//System.out.println(simulatedLastRefluxTemperature);
		//System.out.println("-----------------");
	}
	
}
