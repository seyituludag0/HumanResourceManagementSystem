package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="school_departments")
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="school_id")
    private School school;

    @ManyToOne()
    @JoinColumn(name="department_id")
    private Department department;

//    @JsonIgnore
    @OneToMany(mappedBy = "schoolDepartment" )
    private List<SchoolCandidate> schoolCandidates;

}
