package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private final List<Sensor> sensors;
    private final List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return readings;
    }

    @Override
    public boolean isOn() {
        return sensors.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException("It is must be working or it must contain sensor");
        }

        int reading = (int) Math.round(sensors.stream().mapToInt(Sensor::read).average().getAsDouble());

        readings.add(reading);

        return reading;
    }
}
