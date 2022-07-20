package by.cource.project.util;

import by.cource.project.model.Sensor;
import by.cource.project.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if (sensorService.getSensor(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "", "This name is already taken");
        }
        if (sensor.getName().length() < 3 && sensor.getName().length() > 30) {
            errors.rejectValue("name", "", "This name is big or small");
        }
    }
}
