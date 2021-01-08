package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Frequency;

import java.util.List;

public interface FrequencyService {
    List<Frequency> getFrequencies();

    Frequency getFrequency(Integer id);

    void addFrequency(List<Frequency> frequencies);

    void saveFrequency(Frequency frequency);

    void deleteFrequency(Integer id);

    List<Frequency> findByName(String name);
}
