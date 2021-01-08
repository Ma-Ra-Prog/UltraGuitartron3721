package com.sda.ultraguitartron.tuning;

import com.sda.ultraguitartron.notes.Notes;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Tuning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tuningName;
    private Integer StringNumber;
    private String firstStringNote;
    private String secondStringNote;
    private String thirdStringNote;
    private String fourthStringNote;
    private String fifthStringNote;
    private String sixthStringNote;
    private String seventhStringNote;
    private String createdBy;
}
