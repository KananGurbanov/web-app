package az.edu.turinghackaton.service.impl;

import az.edu.turinghackaton.dao.entity.UserEntity;
import az.edu.turinghackaton.dao.repository.UserRepository;
import az.edu.turinghackaton.exceptions.EmailExistException;
import az.edu.turinghackaton.exceptions.IncorrectPasswordException;
import az.edu.turinghackaton.exceptions.UserNotFoundException;
import az.edu.turinghackaton.mapper.UserMapper;
import az.edu.turinghackaton.model.dto.UserSignInRequestDto;
import az.edu.turinghackaton.model.dto.UserSignInResponseDto;
import az.edu.turinghackaton.model.dto.UserSignUpRequestDto;
import az.edu.turinghackaton.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.edu.turinghackaton.model.enums.Error.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public void signUp(UserSignUpRequestDto userSignUpRequestDto) {
        if(userRepository.existsByEmail(userSignUpRequestDto.email())){
            throw new EmailExistException(ERR_02.getErrorCode(), ERR_02.getErrorDescription());
        }
        userRepository.save(userMapper.maptoEntity(userSignUpRequestDto));
    }

    @Override
    public UserSignInResponseDto signIn(UserSignInRequestDto userSignInRequestDto) {
        if(userRepository.existsByEmail(userSignInRequestDto.email())){
            UserEntity byEmail = userRepository.findByEmail(userSignInRequestDto.email());
            if((!userSignInRequestDto.password().equals(byEmail.getPassword()))){
                throw new IncorrectPasswordException(ERR_03.getErrorCode(), ERR_03.getErrorDescription());
            }
            return userMapper.maptoSignInResponseDto(byEmail);
        }
        else {
            throw new UserNotFoundException(ERR_01.getErrorCode(), ERR_01.getErrorDescription());
        }
    }
}
