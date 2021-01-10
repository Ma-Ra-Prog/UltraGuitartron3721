package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ScaleDto {

    Long id;
    @NotNull
    private String scaleName;
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
    //@NotNull
    private String createdBy;

}
