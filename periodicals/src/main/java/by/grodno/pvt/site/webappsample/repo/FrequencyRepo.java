package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.Frequency;
import by.grodno.pvt.site.webappsample.service.impl.JPAFrequencyService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequencyRepo extends JpaRepository<Frequency, Integer> {
}
