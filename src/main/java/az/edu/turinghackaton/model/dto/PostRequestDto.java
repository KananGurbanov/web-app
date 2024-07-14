package az.edu.turinghackaton.model.dto;

import az.edu.turinghackaton.model.enums.Title;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostRequestDto(
        Title title,

        @NotBlank
        String description,

        @NotBlank
        String company,

        @NotBlank
        String companyImage,

        @NotBlank
        String location,

        @NotBlank
        String jobType,

        @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
        LocalDateTime applicationDeadline) {
}
