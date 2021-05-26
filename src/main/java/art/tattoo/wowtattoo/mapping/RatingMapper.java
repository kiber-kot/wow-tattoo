package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.RatingDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.RatingEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RatingMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RatingEntity toEntity(RatingDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, RatingEntity.class);
    }

    public RatingDto toDto(RatingEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, RatingDto.class);
    }
}
