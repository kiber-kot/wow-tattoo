package art.tattoo.wowtattoo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MasterListDto {
    private Long id;

    private String masterName;

    private int experience;

    private String avatar;

    private String city;

    private int minPrice;

    private List<StyleDto> style;
}
