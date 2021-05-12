package art.tattoo.wowtattoo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Masters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long masterId;

    private long userId;

    private String masterName;

    private String description;

    private boolean rating;

    private int experience;

    private boolean objectStatus;

}
