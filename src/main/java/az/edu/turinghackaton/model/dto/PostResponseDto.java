package az.edu.turinghackaton.model.dto;

import az.edu.turinghackaton.model.enums.Title;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostResponseDto(
        Title title,

        String description,

        String company,

        String companyImage,

        String location,

        String jobType,

        @JsonFormat(pattern = "yy/MM/dd HH:mm")
        LocalDateTime applicationDeadline) {
}
