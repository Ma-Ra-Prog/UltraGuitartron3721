package com.sda.ultraguitartron.chords;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.ultraguitartron.counting.chords.CountingChords;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
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


    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<String> asdqw;
}
