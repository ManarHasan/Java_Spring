package com.axsos.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.languages.models.Language;
import com.axsos.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the Languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a Language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
//    public Language updateLanguage(Language b) {
//    	return LanguageRepository.save(b);
//    }
    // retrieves a Language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	public Language updateLanguage(Long id, String name, String creator, Long currentVersion) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		 if(optionalLanguage.isPresent()) {
	            Language language = optionalLanguage.get();
	            language.setName(name);
	            language.setCreator(creator);
	            language.setCurrentVersion(currentVersion);
	            languageRepository.save(language);
	            return language;
	        } else {
	            return null;
	        }
	}
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		 if(optionalLanguage.isPresent()) {
			 languageRepository.deleteById(id);
	        }
	}
}