package art.tattoo.wowtattoo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Users userId;

    @ManyToOne
    @JoinColumn
    private Masters masterId;

    private String dataTime;
    private String reviewText;
    private boolean objectStatus;
}
