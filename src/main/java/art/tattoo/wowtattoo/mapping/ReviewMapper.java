package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.ReviewDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ReviewMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ReviewEntity toEntity(ReviewDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, ReviewEntity.class);
    }

    public ReviewDto toDto(ReviewEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, ReviewDto.class);
    }
}
