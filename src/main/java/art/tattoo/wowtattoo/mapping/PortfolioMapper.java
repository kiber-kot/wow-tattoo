package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.dto.PortfolioDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PortfolioMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PortfolioEntity toEntity(PortfolioDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, PortfolioEntity.class);
    }

    public PortfolioDto toDto(PortfolioEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, PortfolioDto.class);
    }
}
