package art.tattoo.wowtattoo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String birthDate;

    private String avatar;

    private String lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<ReviewEntity> reviews;

}
