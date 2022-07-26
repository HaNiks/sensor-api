package by.cource.project.service;

import by.cource.project.model.Measurement;
import by.cource.project.model.Sensor;
import by.cource.project.repository.MeasurementRepo;
import by.cource.project.repository.SensorRepo;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MeasurementService {
    private final MeasurementRepo measurementRepo;
    private final SensorRepo sensorRepo;

    public MeasurementService(MeasurementRepo measurementRepo, SensorRepo sensorRepo) {
        this.measurementRepo = measurementRepo;
        this.sensorRepo = sensorRepo;
    }

    public Measurement addMeasurement(Measurement measurement) {
        Measurement newMeasurement = new Measurement();
        double value = measurement.getValue();
        boolean isRaining = measurement.isRaining();
        Sensor sensor1 = sensorRepo.findByName(measurement.getSensor().getName()).orElse(null);
        newMeasurement.setValue(value);
        newMeasurement.setRaining(isRaining);
        newMeasurement.setSensor(sensor1);
        measurementRepo.save(newMeasurement);
        return newMeasurement;
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepo.findAll();
    }


    public long getRainyDays() {
        return getAllMeasurements().stream()
                .filter(Measurement::isRaining)
                .count();
    }
}
