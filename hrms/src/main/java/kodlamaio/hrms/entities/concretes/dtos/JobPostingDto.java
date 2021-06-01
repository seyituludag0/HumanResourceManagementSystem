package kodlamaio.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobPostingDto {

//    Firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi

    private String companyName;

    private String jobTitle;

    private int numberOfOpenPositions;

    private Date postedDate;

    private LocalDate lastApplyDate;



}
