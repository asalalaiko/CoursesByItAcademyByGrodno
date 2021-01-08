package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getLanguages();

    Language getLanguage(Integer id);

    void addLanguage(List<Language> languages);

    void saveLanguage(Language language);

    void deleteLanguage(Integer id);

    List<Language> findByName(String name);
}


