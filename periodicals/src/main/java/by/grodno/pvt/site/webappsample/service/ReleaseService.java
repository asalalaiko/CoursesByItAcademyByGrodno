package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Release;


import java.util.List;

public interface ReleaseService {

    List<Release> getReleases();

    Release getRelease(Integer id);

    void addRelease(List<Release> release);

    void saveRelease(Release release);

    void deleteRelease(Integer id);

    List<Release> findByName(String name);
    
}
