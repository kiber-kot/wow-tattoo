package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.ReviewEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class UserDto {
    private Long id;

    private String name;

    private String birthDate;

    private String avatar;

    private String lastUpdate;

    private List<ReviewDto> reviews;
}
