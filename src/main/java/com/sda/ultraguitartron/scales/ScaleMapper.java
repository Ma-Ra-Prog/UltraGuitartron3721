package com.sda.ultraguitartron.scales;

import org.springframework.stereotype.Component;

@Component
public class ScaleMapper {

    ScaleDto mapToScaleDto(Scale scale){
        return new ScaleDto().builder()
                .id(scale.getId())
                .scaleName(scale.getScaleName())
                .firstNote(scale.getFirstNote())
                .secondNote(scale.getSecondNote())
                .thirdNote(scale.getThirdNote())
                .fourthNote(scale.getFourthNote())
                .fifthNote(scale.getFifthNote())
                .sixthNote(scale.getSixthNote())
                .seventhNote(scale.getSeventhNote())
                .build();
    }
}
