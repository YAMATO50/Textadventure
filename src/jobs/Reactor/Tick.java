package jobs.Reactor;

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
	
}
