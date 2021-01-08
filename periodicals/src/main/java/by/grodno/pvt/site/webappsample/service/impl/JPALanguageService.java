package by.grodno.pvt.site.webappsample.service.impl;

import by.grodno.pvt.site.webappsample.domain.Language;
import by.grodno.pvt.site.webappsample.repo.LanguageRepo;
import by.grodno.pvt.site.webappsample.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPALanguageService implements LanguageService {

    @Autowired
    private LanguageRepo languageRepo;

    @Override
    public List<Language> getLanguages() {
        return languageRepo.findAll();
    }

    @Override
    public Language getLanguage(Integer id) {
        return languageRepo.getOne(id);
    }

    @Override
    public void addLanguage(List<Language> languages) {
        languageRepo.saveAll(languages);
    }

    @Override
    public void saveLanguage(Language language) {
        languageRepo.save(language);
    }

    @Override
    public void deleteLanguage(Integer id) { languageRepo.deleteById(id);    }

    @Override
    public List<Language> findByName(String name) {
        return null;
    }









}
