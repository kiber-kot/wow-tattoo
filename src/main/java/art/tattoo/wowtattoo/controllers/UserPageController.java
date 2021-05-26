package art.tattoo.wowtattoo.controllers;

import art.tattoo.wowtattoo.dao.MasterRepository;
import art.tattoo.wowtattoo.dao.StyleRepository;
import art.tattoo.wowtattoo.dao.UserRepository;
import art.tattoo.wowtattoo.dto.StyleDto;
import art.tattoo.wowtattoo.dto.UserDto;
import art.tattoo.wowtattoo.entity.MasterEntity;
import art.tattoo.wowtattoo.entity.StyleEntity;
import art.tattoo.wowtattoo.entity.UserEntity;
import art.tattoo.wowtattoo.mapping.StyleMapper;
import art.tattoo.wowtattoo.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserPageController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MasterRepository masterRepository;

    @PostMapping("/user")
    public ResponseEntity<UserDto> saveStyle(@PathVariable long id, @RequestBody UserEntity entity){
        UserDto userDto = userMapper
                .toDto(userRepository
                        .save(entity));
        return ResponseEntity.ok(userDto);
    }
}
