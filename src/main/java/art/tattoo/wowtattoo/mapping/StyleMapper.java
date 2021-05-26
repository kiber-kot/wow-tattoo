package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.PortfolioDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StyleMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StyleEntity toEntity(StyleDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, StyleEntity.class);
    }

    public StyleDto toDto(StyleEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, StyleDto.class);
    }
}
