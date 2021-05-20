package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.PortfolioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class PortfolioDTO {

    private Long id;

    private String imageLink;

    public static PortfolioDTO toDto(PortfolioEntity portfolioEntity){
        PortfolioDTO dto = new PortfolioDTO();
        dto.setId(portfolioEntity.getId());
        dto.setImageLink(portfolioEntity.getImageLink());
        return dto;
    }
}
