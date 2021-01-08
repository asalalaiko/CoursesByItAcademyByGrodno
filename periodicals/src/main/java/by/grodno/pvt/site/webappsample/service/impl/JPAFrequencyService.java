package by.grodno.pvt.site.webappsample.service.impl;


import by.grodno.pvt.site.webappsample.domain.Frequency;
import by.grodno.pvt.site.webappsample.repo.FrequencyRepo;
import by.grodno.pvt.site.webappsample.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAFrequencyService implements FrequencyService {
    @Autowired
    private FrequencyRepo frequencyRepo;

    @Override
    public List<Frequency> getFrequencies() {
        return frequencyRepo.findAll();
    }

    @Override
    public Frequency getFrequency(Integer id) {
        return frequencyRepo.getOne(id);
    }

    @Override
    public void addFrequency(List<Frequency> frequency) {
        frequencyRepo.saveAll(frequency);
    }

    @Override
    public void saveFrequency(Frequency frequency) {
        frequencyRepo.save(frequency);
    }

    @Override
    public void deleteFrequency(Integer id) { frequencyRepo.deleteById(id);    }

    @Override
    public List<Frequency> findByName(String name) {
        return null;
    }

}
