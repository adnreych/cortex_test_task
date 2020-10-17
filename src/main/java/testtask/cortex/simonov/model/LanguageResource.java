package testtask.cortex.simonov.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LanguageResource {
	
	Long id;
	String name;
	String description;
	Integer rating;
}
