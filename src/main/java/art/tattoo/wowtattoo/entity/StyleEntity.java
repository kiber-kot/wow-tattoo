package art.tattoo.wowtattoo.entity;

import art.tattoo.wowtattoo.attributes.Styles;
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
@Table(name = "styles")
public class StyleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Styles style;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private MasterEntity masterId;

    @JsonCreator
    public StyleEntity (@JsonProperty("master_id") Long masterId ) {
        this.setId(masterId);
    }
}
