package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ScaleDto {

    Long id;
    @NotBlank(message = "field mandatory")
    private String scaleName;
    @NotNull(message = "field Mandatory")
    private Integer firstNote;
    @NotNull(message = "field Mandatory")
    private Integer secondNote;
    @NotNull(message = "field Mandatory")
    private Integer thirdNote;
    @NotNull(message = "field Mandatory")
    private Integer fourthNote;
    @NotNull(message = "field Mandatory")
    private Integer fifthNote;
    @NotNull(message = "field Mandatory")
    private Integer sixthNote;
    @NotNull(message = "field Mandatory")
    private Integer seventhNote;
    //@NotNull
    private String createdBy;

}
