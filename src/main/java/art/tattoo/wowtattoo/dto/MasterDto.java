package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class MasterDto {

    private Long id;

    private String masterName;

    private String description;

    private int experience;

    private String avatar;

    private String city;

    private int minPrice;

    private RatingDto rating;

    private List<ReviewDto> reviews;

    private List<PortfolioDto> portfolio;

    private List<StyleDto> style;

    private ContactDto contact;

}
