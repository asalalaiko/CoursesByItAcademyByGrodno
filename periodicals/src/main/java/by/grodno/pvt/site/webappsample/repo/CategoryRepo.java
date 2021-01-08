package by.grodno.pvt.site.webappsample.repo;

import by.grodno.pvt.site.webappsample.domain.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {



}
