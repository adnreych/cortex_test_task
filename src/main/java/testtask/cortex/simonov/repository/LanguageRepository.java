package testtask.cortex.simonov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testtask.cortex.simonov.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
	List<Language> findByName(String name);
}
