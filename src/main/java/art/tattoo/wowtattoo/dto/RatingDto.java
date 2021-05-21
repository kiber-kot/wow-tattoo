package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.RatingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class RatingDto {

    private Long id;

    private Long masterId;

    private double rating;

}
