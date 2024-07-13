package az.edu.turinghackaton.service.impl;

import az.edu.turinghackaton.dao.repository.UserRepository;
import az.edu.turinghackaton.exceptions.EmailExistException;
import az.edu.turinghackaton.mapper.UserMapper;
import az.edu.turinghackaton.model.dto.UserSignUpRequestDto;
import az.edu.turinghackaton.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.edu.turinghackaton.model.enums.Error.ERR_02;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public void signUp(UserSignUpRequestDto userSignUpRequestDto) {
        if(userRepository.existsByEmail(userSignUpRequestDto.getEmail())){
            throw new EmailExistException(ERR_02.getErrorCode(), ERR_02.getErrorDescription());
        }
    }
}
