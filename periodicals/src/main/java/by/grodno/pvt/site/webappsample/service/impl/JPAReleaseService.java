package by.grodno.pvt.site.webappsample.service.impl;


import by.grodno.pvt.site.webappsample.domain.Release;
import by.grodno.pvt.site.webappsample.repo.ReleaseRepo;
import by.grodno.pvt.site.webappsample.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAReleaseService implements ReleaseService {


    @Autowired
    private ReleaseRepo releaseRepo;

    @Override
    public List<Release> getReleases() {
        return releaseRepo.findAll();
    }

    @Override
    public Release getRelease(Integer id) {
        return releaseRepo.getOne(id);
    }

    @Override
    public void addRelease(List<Release> release) {
        releaseRepo.saveAll(release);

    }

    @Override
    public void saveRelease(Release release) {
    releaseRepo.save(release);
    }

    @Override
    public void deleteRelease(Integer id) {
    releaseRepo.deleteById(id);
    }

    @Override
    public List<Release> findByName(String name) {
        return null;
    }
}
