package art.tattoo.wowtattoo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private String masterName;

    private String description;

    private int experience;

    private String avatar;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "masterId")
    private RatingEntity rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<ReviewEntity> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<PortfolioEntity> portfolioEntities;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "masterId")
    private ContactEntity contact;
}
