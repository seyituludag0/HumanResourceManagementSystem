package  kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="ability_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class AbilityCandidate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="ability_id")
    private Ability ability;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;
}
