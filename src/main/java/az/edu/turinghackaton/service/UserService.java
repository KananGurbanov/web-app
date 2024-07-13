package az.edu.turinghackaton.service;

import az.edu.turinghackaton.model.dto.UserSignUpRequestDto;

public interface UserService {
    void signUp(UserSignUpRequestDto userSignUpRequestDto);
}
