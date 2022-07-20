package by.cource.project.service;

import by.cource.project.model.Sensor;
import by.cource.project.repository.SensorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepo sensorRepo;

    public SensorService(SensorRepo sensorRepo) {
        this.sensorRepo = sensorRepo;
    }

    public List<Sensor> getAllSensors() {
        return sensorRepo.findAll();
    }

    public Sensor getSensorById(int id) {
        return sensorRepo.findById(id).orElse(null);
    }

    public Optional<Sensor> getSensor(String name) {
        return sensorRepo.findByName(name);
    }

    public Sensor addSensor(Sensor sensor) {
        Sensor newSensor = new Sensor();
        newSensor.setName(sensor.getName());
        sensorRepo.save(newSensor);
        return newSensor;
    }

}