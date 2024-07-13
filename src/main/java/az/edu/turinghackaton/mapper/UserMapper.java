package az.edu.turinghackaton.mapper;

import az.edu.turinghackaton.dao.entity.UserEntity;
import az.edu.turinghackaton.model.dto.UserSignUpRequestDto;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface UserMapper {
    UserEntity maptoEntity(UserSignUpRequestDto userSignUpRequestDto);
}
