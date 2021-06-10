package art.tattoo.wowtattoo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "master")
public class MasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String masterName;

    @Column(length = 5000)
    private String description;

    @Min(1)
    @Max(99)
    private int experience;

    private String avatar;

    private String city;

    private String minPrice;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "masterId")
    private RatingEntity rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<ReviewEntity> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<PortfolioEntity> portfolio;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "masterId")
    private ContactEntity contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<StyleEntity> style;
}
