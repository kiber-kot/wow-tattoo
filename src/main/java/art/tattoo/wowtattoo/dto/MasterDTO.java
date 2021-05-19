package art.tattoo.wowtattoo.dto;

import art.tattoo.wowtattoo.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private RatingEntity rating;

    private List<ReviewDTO> reviews;

    private List<PortfolioEntity> portfolioEntities;

    private ContactEntity contact;

    public static MasterDTO toMasterDTO(MasterEntity masterEntity){
        MasterDTO masterDTO = new MasterDTO();
        masterDTO.setId(masterEntity.getId());
        masterDTO.setMasterName(masterEntity.getMasterName());
        masterDTO.setDescription(masterEntity.getDescription());
        masterDTO.setExperience(masterEntity.getExperience());
        masterDTO.setAvatar(masterEntity.getAvatar());
        masterDTO.setRating(masterEntity.getRating());
        masterDTO.setReviews(masterEntity.getReviews().stream().map(ReviewDTO::toDTO).collect(Collectors.toList()));
        return masterDTO;
    }
}
