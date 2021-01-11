package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.Release;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepo extends JpaRepository <Release, Integer> {
    }
