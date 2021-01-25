package com.sda.ultraguitartron.trainee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sda.ultraguitartron.counting.chords.CountingChords;
import com.sda.ultraguitartron.tuning.Tuning;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private boolean adminPermission;
    @ManyToOne
    Tuning currentTuning;
    @OneToMany(mappedBy = "trainee")
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CountingChords> countingChordsList;
}