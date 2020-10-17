package testtask.cortex.simonov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "languages")
public class Language {
	
	@Id
	@Column(name = "name")
	String name;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "rating")
	Integer rating;
}
