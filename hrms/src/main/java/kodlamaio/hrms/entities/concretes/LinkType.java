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
@Table(name="social_media_link_types")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","socialMedias"})
public class LinkType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;

    @Column(name="link_type")
    private String linkType;

    @JsonIgnore
    @OneToMany(mappedBy = "linkType" )
    private List<SocialMedia> socialMedias;

}
