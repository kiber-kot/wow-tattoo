package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.StyleRepository;
import art.tattoo.wowtattoo.dao.UserRepository;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.dto.UserDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.ReviewEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.entity.UserEntity;
import art.tattoo.wowtattoo.exeption.MasterNotFoundException;
import art.tattoo.wowtattoo.mapping.StyleMapper;
import art.tattoo.wowtattoo.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/api")
public class UserPageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user")
    public ResponseEntity<UserDto> saveStyle(@Valid @RequestBody UserEntity entity){
        UserDto userDto = userMapper
                .toDto(userRepository
                        .save(entity));
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updatePortfolio(@PathVariable long id,
                                             @Valid
                                             @RequestBody UserEntity entity){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        try {
            if (userEntity.isEmpty()) {
                throw new MasterNotFoundException("Ошибка, пользолватель с id = '" + id + "' отсутствует в базе");
            }
            return ResponseEntity.ok(userMapper
                    .toDto(userRepository
                            .save(entity)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
