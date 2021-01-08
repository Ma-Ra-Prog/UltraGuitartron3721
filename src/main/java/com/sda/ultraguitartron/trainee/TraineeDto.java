package com.sda.ultraguitartron.trainee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TraineeDto {

    Long id;
    String name;
    boolean adminPermission;
}
