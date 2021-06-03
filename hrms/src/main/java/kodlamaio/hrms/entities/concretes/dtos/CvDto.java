package kodlamaio.hrms.entities.concretes.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.AbilityCandidate;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvDetail;
import kodlamaio.hrms.entities.concretes.LanguageCandidate;
import kodlamaio.hrms.entities.concretes.SchoolCandidate;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.WorkplaceCandidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto  {

    @JsonIgnore
    private Candidate candidate;

    private List<SchoolCandidate> schoolCandidates;
    private List<LanguageCandidate> languageCandidates;
    private List<WorkplaceCandidate> workplaceCandidate;
    private List<SocialMedia> socialMedias;
    private List<AbilityCandidate> abilityCandidates;
    private CvDetail cvDetail;
}
