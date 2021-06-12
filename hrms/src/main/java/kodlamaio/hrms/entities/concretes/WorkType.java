package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="work_types")
public class WorkType {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy = "workType")
	@JsonIgnore
	private List<JobPosting> jobPostings;
}
