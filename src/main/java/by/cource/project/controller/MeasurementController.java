package by.cource.project.controller;

import by.cource.project.model.Measurement;
import by.cource.project.model.Sensor;
import by.cource.project.service.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public Measurement addMeasurement(@RequestBody Measurement measurement, Sensor sensor) {
        return measurementService.addMeasurement(measurement, sensor);
    }

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @GetMapping("/rainyDaysCount")
    public long getRainyDaysCount() {
        return measurementService.getRainyDays();
    }
}
