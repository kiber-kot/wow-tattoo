package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.ReviewRepository;
import art.tattoo.wowtattoo.dao.StyleRepository;
import art.tattoo.wowtattoo.dto.ReviewDto;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.RatingEntity;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.mapping.ReviewMapper;
import art.tattoo.wowtattoo.mapping.StyleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/api")
public class ReviewPageController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private MasterRepository masterRepository;

    @PostMapping("/review/{id}")
    public ResponseEntity<ReviewDto> saveStyle(@PathVariable long id,
                                               @Valid
                                               @RequestBody ReviewEntity entity){
        MasterEntity masterEntity = masterRepository.findById(id).get();
        entity.setMasterId(masterEntity);
        ReviewDto reviewDto = reviewMapper
                .toDto(reviewRepository
                        .save(entity));
        return ResponseEntity.ok(reviewDto);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<?> updatePortfolio(@PathVariable long id,
                                             @Valid
                                             @RequestBody ReviewEntity entity){
        Optional<MasterEntity> masterEntity = masterRepository.findById(id);
        try {
            if (masterEntity.isEmpty()) {
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + id + "' отсутствует в базе");
            }
            entity.setMasterId(masterEntity.get());
            return ResponseEntity.ok(reviewMapper
                    .toDto(reviewRepository
                            .save(entity)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
