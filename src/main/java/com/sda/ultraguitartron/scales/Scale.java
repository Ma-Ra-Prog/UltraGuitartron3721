package com.sda.ultraguitartron.scales;

import com.sda.ultraguitartron.counting.scales.CountingScales;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scaleName;
    private Integer firstNote;
    private Integer secondNote;
    private Integer thirdNote;
    private Integer fourthNote;
    private Integer fifthNote;
    private Integer sixthNote;
    private Integer seventhNote;
    private String createdBy;
}
