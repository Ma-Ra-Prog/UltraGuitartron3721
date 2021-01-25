package com.sda.ultraguitartron.trainee;

import com.sda.ultraguitartron.tuning.Tuning;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class TraineeDto {

    Long id;
    @NotBlank(message = "Name is mandatory.")
    String name;
    @NotBlank(message = "Password is mandatory.")
    String password;
    boolean adminPermission;
    Tuning currentTuning;
}