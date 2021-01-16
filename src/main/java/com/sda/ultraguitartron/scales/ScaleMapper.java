package com.sda.ultraguitartron.scales;

import org.springframework.stereotype.Component;

@Component
public class ScaleMapper {

    public ScaleDto mapToScaleDto(Scale scale) {
        return ScaleDto.builder()
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

    public ScaleDefinition mapToDefinition(ScaleDto scaleDto) {
        return ScaleDefinition.builder()
                .scaleName(scaleDto.getScaleName())
                .firstNote(scaleDto.getFirstNote())
                .secondNote(scaleDto.getSecondNote())
                .thirdNote(scaleDto.getThirdNote())
                .fourthNote(scaleDto.getFourthNote())
                .fifthNote(scaleDto.getFifthNote())
                .sixthNote(scaleDto.getSixthNote())
                .seventhNote(scaleDto.getSeventhNote())
                .build();
    }

    public Scale mapToScale(ScaleDefinition scaleDefinition) {
        return Scale.builder()
                .scaleName(scaleDefinition.getScaleName())
                .firstNote(scaleDefinition.getFirstNote())
                .secondNote(scaleDefinition.getSecondNote())
                .thirdNote(scaleDefinition.getThirdNote())
                .fourthNote(scaleDefinition.getFourthNote())
                .fifthNote(scaleDefinition.getFifthNote())
                .sixthNote(scaleDefinition.getSixthNote())
                .seventhNote(scaleDefinition.getSeventhNote())
                .build();
    }
}
