package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.Publisher;
import by.grodno.pvt.site.webappsample.repo.PublisherRepo;
import by.grodno.pvt.site.webappsample.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JPAPublisherService implements PublisherService {



    @Autowired
    private PublisherRepo publisherRepo;


    @Override
    public List<Publisher> getPublishers() {
        return publisherRepo.findAll();    }

    @Override
    public Publisher getPublisher(Integer id) {
        return publisherRepo.getOne(id);
    }

    @Override
    public void addPublisher(List<Publisher> publishers) {
     publisherRepo.saveAll(publishers);
    }

    @Override
    public void savePublisher(Publisher publisher) {
    publisherRepo.save(publisher);
    }

    @Override
    public void deletePublisher(Integer id) {
    publisherRepo.deleteById(id);
    }

    @Override
    public List<Publisher> findByName(String name) {
        return null;
    }
}
