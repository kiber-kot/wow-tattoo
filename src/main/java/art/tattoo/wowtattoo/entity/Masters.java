package art.tattoo.wowtattoo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Masters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Users userId;

    private String masterName;

    private String description;

    private boolean rating;

    private int experience;

    private boolean objectStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<Reviews> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterId")
    private List<Portfolio> portfolios;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "masterId")
    private Ratings ratings;

}
