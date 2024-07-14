package az.edu.turinghackaton.service;

import az.edu.turinghackaton.model.dto.UserSignInRequestDto;
import az.edu.turinghackaton.model.dto.UserSignInResponseDto;
import az.edu.turinghackaton.model.dto.UserSignUpRequestDto;

public interface UserService {
    void signUp(UserSignUpRequestDto userSignUpRequestDto);

    UserSignInResponseDto signIn(UserSignInRequestDto userSignInRequestDto);
}
