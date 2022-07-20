package by.cource.project.controller;

import by.cource.project.dto.SensorDTO;
import by.cource.project.model.Sensor;
import by.cource.project.service.SensorService;
import by.cource.project.util.SensorValidator;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SensorController {

    private final ModelMapper modelMapper;
    private final SensorService sensorService;
    private final SensorValidator sensorValidator;

    public SensorController(ModelMapper modelMapper, SensorService sensorService, SensorValidator sensorValidator) {
        this.modelMapper = modelMapper;
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/sensors/registration")
    public SensorDTO registerSensor(@RequestBody Sensor sensor, BindingResult bindingResult) {
        sensorValidator.validate(sensor, bindingResult);
        return convertToPersonDTO(sensorService.addSensor(sensor));
    }

    @GetMapping("sensors")
    public List<SensorDTO> getAllSensors() {
        return sensorService.getAllSensors().stream()
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    private Sensor convertToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

    private SensorDTO convertToPersonDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }
}
