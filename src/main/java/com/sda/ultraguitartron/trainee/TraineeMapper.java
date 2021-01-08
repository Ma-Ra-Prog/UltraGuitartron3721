package com.sda.ultraguitartron.trainee;

import org.springframework.stereotype.Component;

@Component
public class TraineeMapper {

    TraineeDto mapToTraineeDto(Trainee trainee){
        return new TraineeDto().builder()
                .id(trainee.getId())
                .name(trainee.getName())
                .adminPermission(trainee.isAdminPermission())
                .build();
    }
}
