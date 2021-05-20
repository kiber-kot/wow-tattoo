package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class MasterDTO {

    private Long id;

    private String masterName;

    private String description;

    private int experience;

    private String avatar;

    private RatingDTO rating;

    private List<ReviewDTO> reviews;

    private List<PortfolioDTO> portfolio;

    private ContactEntity contact;

    public static MasterDTO toMasterDTO(MasterEntity masterEntity){


        MasterDTO masterDTO = new MasterDTO();
        masterDTO.setId(masterEntity.getId());
        masterDTO.setMasterName(masterEntity.getMasterName());
        masterDTO.setDescription(masterEntity.getDescription());
        masterDTO.setExperience(masterEntity.getExperience());
        masterDTO.setAvatar(masterEntity.getAvatar());
        masterDTO.setReviews(masterEntity.getReviews()
                .stream()
                .map(ReviewDTO::toDTO)
                .collect(Collectors.toList()));
        masterDTO.setPortfolio(masterEntity.getPortfolio()
                .stream()
                .map(PortfolioDTO::toDto)
                .collect(Collectors.toList()));
//        masterDTO.setRating(masterEntity.getRating());

        return masterDTO;
    }
}
