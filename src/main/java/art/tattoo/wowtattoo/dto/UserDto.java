package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.ReviewEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;

    private String name;

    private String birthDate;

    private String avatar;

    private String lastUpdate;

    private List<ReviewDto> reviews;
}
