package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import art.tattoo.wowtattoo.entity.UserEntity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ReviewDTO {


    public static ReviewDTO toDTO(ReviewEntity reviewEntity){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(reviewEntity.getId());
//        reviewDTO.setUserId(reviewEntity.getUserId());
//        reviewDTO.setMasterId(reviewEntity.getMasterId());
        reviewDTO.setDataTime(reviewEntity.getDataTime());
        reviewDTO.setReviewText(reviewEntity.getReviewText());
        return reviewDTO;
    }


    private Long id;
//    private UserEntity userId;
//    private MasterEntity masterId;
    private String dataTime;
    private String reviewText;


}
