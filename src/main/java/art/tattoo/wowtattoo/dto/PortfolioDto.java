package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.PortfolioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PortfolioDto {

    private Long id;

    private Long masterId;

    private String imageLink;

}
