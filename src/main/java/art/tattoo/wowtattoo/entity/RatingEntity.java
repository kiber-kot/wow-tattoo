package art.tattoo.wowtattoo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "rating")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "master_id")
    @OneToOne
    private MasterEntity masterId;

    private double rating;

    @JsonCreator
    public RatingEntity(@JsonProperty("master_id") Long masterId ) {
        this.setId(masterId);
    }
}
