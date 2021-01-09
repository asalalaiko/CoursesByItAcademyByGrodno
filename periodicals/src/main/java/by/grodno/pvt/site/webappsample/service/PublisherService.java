package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getPublishers();

    Publisher getPublisher(Integer id);

    void addPublisher(List<Publisher> publisher);

    void savePublisher(Publisher publisher);

    void deletePublisher(Integer id);

    List<Publisher> findByName(String name);
}
