package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="cv_details")
@AllArgsConstructor
@NoArgsConstructor
public class CvDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @OneToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name="description")
    private String description;

    @Column(name="cv_photo_url")
    private String cvPhotoUrl;

}
