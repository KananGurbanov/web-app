package az.edu.turinghackaton.model.dto;

import lombok.Builder;

@Builder
public record UserSignInResponseDto(
        String name,
        String surname,
        String email,
        Integer stars) {
}
