package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import art.tattoo.wowtattoo.entity.UserEntity;


import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ReviewDto {

    private Long id;

    @JsonProperty(value = "sentId")
    private Long userId;

    private Long masterId;

    private String dataTime;

    private String reviewText;
}
