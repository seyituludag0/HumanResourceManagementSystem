package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="workplace_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class WorkplaceCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="workplaces_id")
    private Workplace workplace;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @ManyToOne()
    @JoinColumn(name="job_title_id")
    private JobTitle jobTitle;

    @Column(name="date_of_entry")
    private LocalDate dateOfEntry;

    @Column(name="date_of_quit")
    private LocalDate dateOfQuit;
}
