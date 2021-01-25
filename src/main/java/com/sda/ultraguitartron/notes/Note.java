package com.sda.ultraguitartron.notes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sda.ultraguitartron.counting.chords.CountingChords;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    String note;
    @OneToMany(mappedBy = "note")
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CountingChords> countingChordsList;
}