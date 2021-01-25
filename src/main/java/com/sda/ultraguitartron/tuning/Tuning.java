package com.sda.ultraguitartron.tuning;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sda.ultraguitartron.counting.chords.CountingChords;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tuning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tuningName;
    private Integer stringNumber;
    private String firstStringNote;
    private String secondStringNote;
    private String thirdStringNote;
    private String fourthStringNote;
    private String fifthStringNote;
    private String sixthStringNote;
    private String seventhStringNote;
    private String createdBy;
    @OneToMany(mappedBy = "currentTuning")
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Trainee> traineeList;
}