package art.tattoo.wowtattoo.entity;

import art.tattoo.wowtattoo.attributes.Styles;
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

    @Enumerated(EnumType.STRING)
    private Styles styles;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private MasterEntity masterId;
}
