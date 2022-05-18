package site.metacoding.blogtest.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.blogtest.domain.User;
import site.metacoding.blogtest.dto.ResponseDto;
import site.metacoding.blogtest.service.UserService;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/s/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email (user가 들고 있다.)
        System.out.println("UserApiController : save 호출됨");
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)
    }
}
