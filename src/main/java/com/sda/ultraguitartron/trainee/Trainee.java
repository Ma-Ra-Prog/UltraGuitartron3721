package com.sda.ultraguitartron.trainee;

import com.sda.ultraguitartron.tuning.Tuning;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Tuning currentTuning;
}