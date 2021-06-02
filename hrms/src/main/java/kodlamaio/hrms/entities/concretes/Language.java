package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="languages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","languageCandiates"})
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name="id")
    private int id;

    @Column(name="language_name")
    private String languageName;

    @JsonIgnore
    @OneToMany(mappedBy = "language" )
    private List<LanguageCandiate> languageCandiates;

}
