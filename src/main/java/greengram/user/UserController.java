package greengram.user;

import greengram.ResVo;
import greengram.user.model.UserInsDto;
import greengram.user.model.UserProfileInfoVo;
import greengram.user.model.UserSigninDto;
import greengram.user.model.UserSigninVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResVo insUser(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }
    @PostMapping("/signin")
    public UserSigninVo login(@RequestBody UserSigninDto dto) {
        return service.signin(dto);
    }
    @GetMapping("/{targetIuser}")
    public UserProfileInfoVo getUserProfileInfo(@PathVariable int targetIuser) {
        return service.getUserProfileInfo(targetIuser);
    }
}
