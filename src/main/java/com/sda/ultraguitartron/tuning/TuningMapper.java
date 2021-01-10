package com.sda.ultraguitartron.tuning;

import org.springframework.stereotype.Component;

@Component
public class TuningMapper {

    TuningDto mapToTuningDto(Tuning tuning) {
        return TuningDto.builder()
                .id(tuning.getId())
                .tuningName(tuning.getTuningName())
                .stringNumber(tuning.getStringNumber())
                .firstStringNote(tuning.getFirstStringNote())
                .secondStringNote(tuning.getSecondStringNote())
                .thirdStringNote(tuning.getThirdStringNote())
                .fourthStringNote(tuning.getFourthStringNote())
                .fifthStringNote(tuning.getFifthStringNote())
                .sixthStringNote(tuning.getFifthStringNote())
                .seventhStringNote(tuning.getSeventhStringNote())
                .createdBy(tuning.getCreatedBy())
                .build();
    }

    public Tuning mapToTuning(TuningDto tuningDto) {
        return Tuning.builder()
                .tuningName(tuningDto.tuningName)
                .stringNumber(tuningDto.stringNumber)
                .firstStringNote(tuningDto.firstStringNote)
                .secondStringNote(tuningDto.secondStringNote)
                .thirdStringNote(tuningDto.thirdStringNote)
                .fourthStringNote(tuningDto.fourthStringNote)
                .fifthStringNote(tuningDto.fifthStringNote)
                .sixthStringNote(tuningDto.sixthStringNote)
                .seventhStringNote(tuningDto.seventhStringNote)
                .build();
    }
}