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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String birthDate;

    private String avatar;

    private boolean objectStatus;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
    private Masters masters;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId")
    private Contacts contacts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Reviews> reviews;

}
