package by.cource.project.repository;

import by.cource.project.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepo extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
}
