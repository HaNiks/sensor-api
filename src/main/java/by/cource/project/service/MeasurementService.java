package by.cource.project.service;

import by.cource.project.model.Measurement;
import by.cource.project.model.Sensor;
import by.cource.project.repository.MeasurementRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepo measurementRepo;

    public MeasurementService(MeasurementRepo measurementRepo) {
        this.measurementRepo = measurementRepo;
    }

    public Measurement addMeasurement(Measurement measurement, Sensor sensor) {
        Measurement newMeasurement = new Measurement();
        measurement.setValue(0);
        measurement.setRaining(false);
        measurement.setSensor(sensor);
        return measurement;
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
