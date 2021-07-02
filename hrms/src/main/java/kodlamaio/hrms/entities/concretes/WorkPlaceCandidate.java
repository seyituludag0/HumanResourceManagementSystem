	package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="work_place_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class WorkPlaceCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="work_place_name")
    private String workPlaceName;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    
    @Column(name="job_title")
    private String jobTitle;

    @Column(name="date_of_entry")
    private LocalDate dateOfEntry;

    @Column(name="date_of_quit")
    private LocalDate dateOfQuit;
}
