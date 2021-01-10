package com.sda.ultraguitartron.chords;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chordName;
    private Integer firstNote;
    private Integer secondNote;
    private Integer thirdNote;
    private Integer fourthNote;
    private String createdBy;


//    @ManyToMany      //to hint do relacji many to many
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private List<String> asdqw;
}