package com.sda.ultraguitartron.chords;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sda.ultraguitartron.counting.chords.CountingChords;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany(mappedBy = "chord")
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CountingChords> countingChordsList;
}