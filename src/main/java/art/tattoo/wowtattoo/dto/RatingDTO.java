package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.RatingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class RatingDTO {

    private Long id;
    private double rating;

    public static RatingDTO getDto(RatingEntity ratingEntity){
        RatingDTO dto = new RatingDTO();
        dto.setId(ratingEntity.getId());
        dto.setRating(ratingEntity.getRating());
        return dto;
    }
}
