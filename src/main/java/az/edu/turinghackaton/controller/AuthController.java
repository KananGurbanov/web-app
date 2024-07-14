package az.edu.turinghackaton.controller;

import az.edu.turinghackaton.model.dto.RestResponse;
import az.edu.turinghackaton.model.dto.UserSignInRequestDto;
import az.edu.turinghackaton.model.dto.UserSignInResponseDto;
import az.edu.turinghackaton.model.dto.UserSignUpRequestDto;
import az.edu.turinghackaton.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid UserSignUpRequestDto user) {
        userService.signUp(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<RestResponse<UserSignInResponseDto>> login(@RequestBody @Valid
                                                                         UserSignInRequestDto loginRequest) {
        UserSignInResponseDto userSignInResponseDto = userService.signIn(loginRequest);
        RestResponse<UserSignInResponseDto> restResponse = RestResponse.<UserSignInResponseDto>builder()
                .status("SUCCESS")
                .data(userSignInResponseDto)
                .build();
        return ResponseEntity.ok(restResponse);
    }
}
