package art.tattoo.wowtattoo.mapping;

import art.tattoo.wowtattoo.dto.ContactDto;
import art.tattoo.wowtattoo.dto.MasterDto;
import art.tattoo.wowtattoo.entity.ContactEntity;
import art.tattoo.wowtattoo.entity.MasterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ContactMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ContactEntity toEntity(ContactDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, ContactEntity.class);
    }

    public ContactDto toDto(ContactEntity entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, ContactDto.class);
    }

}
