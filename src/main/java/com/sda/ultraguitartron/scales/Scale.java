package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "scale_name")
    private String name;
//    @Column(name = "first_note")
    private Integer firstNote;
//    @Column(name = "second_note")
    private Integer secondNote;
//    @Column(name = "third_note")
    private Integer thirdNote;
//    @Column(name = "fourth_note")
    private Integer fourthNote;
//    @Column(name = "fifth_note")
    private Integer fifthNote;
//    @Column(name = "sixth_note")
    private Integer sixthNote;
//    @Column(name = "seventh_note")
    private Integer seventhNote;
//    @Column(name = "creator")
    private String createdBy;
}