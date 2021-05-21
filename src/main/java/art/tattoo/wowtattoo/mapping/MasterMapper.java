package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.dto.ReviewDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class MasterMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MasterEntity toEntity(MasterDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, MasterEntity.class);
    }

    public MasterDto toDto(MasterEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, MasterDto.class);
    }


}
