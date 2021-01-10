package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScaleDefinition {


    String scaleName;
    private Integer firstNote;
    private Integer secondNote;
    private Integer thirdNote;
    private Integer fourthNote;
    private Integer fifthNote;
    private Integer sixthNote;
    private Integer seventhNote;
}
