package testtask.cortex.simonov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import testtask.cortex.simonov.exception.LanguageNotFoundException;
import testtask.cortex.simonov.exception.LanguageValidationException;
import testtask.cortex.simonov.model.Language;
import testtask.cortex.simonov.model.LanguageResource;
import testtask.cortex.simonov.service.LanguageService;

@CrossOrigin
@RestController
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/language")
	  public Iterable<Language> getAll() {		
		return languageService.getAll();
	  }
	
	@GetMapping("/language/{name}")
	  public Language getDescriptionByName(@PathVariable(value="name") String name) 
			  throws LanguageNotFoundException {		
		return languageService.getByName(name);
	  }
	
	@PostMapping(value = "/language")
	  public ResponseEntity<Language> saveLanguage(@RequestBody LanguageResource languageResourse) throws LanguageValidationException {
		if (!languageIsValid(languageResourse)) {
			throw new LanguageValidationException();
		}
		Language result = languageService.saveLanguage(languageResourse);
		return ResponseEntity.ok().body(result);
	  }
	
	@PutMapping("/language/{name}")
	  public ResponseEntity<Language> editLanguage(@PathVariable(value="name") String name, 
			  @RequestBody LanguageResource languageResourse) {	
		Language result = languageService.saveLanguage(languageResourse);
		return ResponseEntity.ok().body(result);
	  }
	
	@DeleteMapping(value = "/language/{name}")
	  public ResponseEntity deleteLanguage(@PathVariable(value="name") String name) throws LanguageNotFoundException {	
		 languageService.deleteLanguage(name);
		 return ResponseEntity.ok(HttpStatus.OK);
	  }
	
	private boolean languageIsValid(LanguageResource languageResourse) {
		if (!languageResourse
				.getName()
				.matches("^(Java|JavaScript|C\\+\\+|C#|Python)$")) {
			return false;
		}
		if (languageResourse.getRating() > 5 || languageResourse.getRating() < 1) {
			return false;
		}
		return true;	
	}
}
