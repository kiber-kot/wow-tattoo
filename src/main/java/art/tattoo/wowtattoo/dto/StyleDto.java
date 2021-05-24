package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.attributes.Styles;
import art.tattoo.wowtattoo.entity.MasterEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StyleDto {

    private Long id;

    private String style;

    private Long masterId;
}
