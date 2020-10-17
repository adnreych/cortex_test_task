package testtask.cortex.simonov.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import testtask.cortex.simonov.exception.LanguageNotFoundException;
import testtask.cortex.simonov.model.Language;
import testtask.cortex.simonov.model.LanguageResource;
import testtask.cortex.simonov.repository.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepository;
	
	public Iterable<Language> getAll() {
		return languageRepository.findAll();
	}

	public Language getByName(String name) throws LanguageNotFoundException {
		List<Language> results = languageRepository.findByName(name);
		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			throw new LanguageNotFoundException();
		}		
	}
	
	public Language saveLanguage(LanguageResource languageResourse) {
		Language language = new Language();
		language.setName(languageResourse.getName());
		language.setDescription(languageResourse.getDescription());
		language.setRating(languageResourse.getRating());
		return languageRepository.save(language);
	}
	
	@Transactional
	public void deleteLanguage(String name) throws LanguageNotFoundException {
		List<Language> results = languageRepository.findByName(name);
		if (!results.isEmpty()) {
			languageRepository.delete(results.get(0));
		} else {
			throw new LanguageNotFoundException();
		}			
	}	

}
