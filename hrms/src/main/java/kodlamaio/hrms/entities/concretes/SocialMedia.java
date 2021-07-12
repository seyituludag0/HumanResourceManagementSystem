package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="social_medias")
@AllArgsConstructor
@NoArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @ManyToOne()
    @JoinColumn(name="link_type_id")
    private LinkType linkType;


    @Column(name="link")
    private String link;
}
