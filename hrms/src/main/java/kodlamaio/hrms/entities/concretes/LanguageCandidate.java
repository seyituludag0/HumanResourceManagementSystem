package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="language_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="language_id")
    private Language language;

    @ManyToOne()
    @JoinColumn(name="language_level_id")
    private LanguageLevel languageLevel;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;
}
