package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobPostings"})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<JobPosting> jobPostings;

}
