package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScalesDefinition {


    @NotNull
    String scaleName;
    @NotNull
    private Integer firstNote;
    @NotNull
    private Integer secondNote;
    @NotNull
    private Integer thirdNote;
    @NotNull
    private Integer fourthNote;
    @NotNull
    private Integer fifthNote;
    @NotNull
    private Integer sixthNote;
    @NotNull
    private Integer seventhNote;
    @NotNull
    private String createdBy;
}
