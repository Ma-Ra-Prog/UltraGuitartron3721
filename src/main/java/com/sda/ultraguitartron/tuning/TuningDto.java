package com.sda.ultraguitartron.tuning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class TuningDto {

    Long id;
    @NotBlank
    String tuningName;
    @NotNull
    Integer stringNumber;
    @NotBlank
    String firstStringNote;
    @NotBlank
    String secondStringNote;
    @NotBlank
    String thirdStringNote;
    @NotBlank
    String fourthStringNote;
    @NotBlank
    String fifthStringNote;
    @NotBlank
    String sixthStringNote;
    String seventhStringNote;
    String createdBy;

}