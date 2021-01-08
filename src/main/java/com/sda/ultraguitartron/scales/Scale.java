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
    private int firstNote;
    private int secondNote;
    private int thirdNote;
    private int fourthNote;
    private int fifthNote;
    private int sixthNote;
    private int seventhNote;
    private String createdBy;
}
