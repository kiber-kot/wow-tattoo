package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.dto.UserDto;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toEntity(UserDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, UserEntity.class);
    }

    public UserDto toDto(UserEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, UserDto.class);
    }
}
