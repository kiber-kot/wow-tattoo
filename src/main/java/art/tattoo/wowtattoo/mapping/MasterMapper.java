package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<MasterEntity> toEntity(List<MasterDto> dto){
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<MasterDto> toTdoList(List<MasterEntity> entity){
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }


}
