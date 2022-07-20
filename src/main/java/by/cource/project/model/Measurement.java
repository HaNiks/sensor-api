package by.cource.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Measurement {

    private int id;
    @JsonProperty("value")
    private double value;
    @JsonProperty("raining")
    private boolean raining;
    @JsonProperty("sensor")
    private Sensor sensor;

    public Measurement(int id, double value, boolean raining, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public Measurement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", raining=" + raining +
                ", sensor=" + sensor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Measurement)) return false;
        Measurement that = (Measurement) o;
        return Double.compare(that.getValue(), getValue()) == 0 && isRaining() == that.isRaining() && getSensor().equals(that.getSensor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), isRaining(), getSensor());
    }
}
