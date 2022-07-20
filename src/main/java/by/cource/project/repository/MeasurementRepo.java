package by.cource.project.repository;

import by.cource.project.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepo extends JpaRepository<Measurement, Integer> {
}
