package com.sda.ultraguitartron.utils;

import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeCrudService;
import com.sda.ultraguitartron.trainee.TraineeMapper;
import com.sda.ultraguitartron.trainee.TraineeUserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {

    private final TraineeCrudService traineeCrudService;
    private final TraineeMapper traineeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Trainee trainee = traineeMapper.mapToTrainee(traineeCrudService.fetchTraineeByName(username));

        return new TraineeUserAdapter(trainee);
    }
}

//powiedziec springowi, aby używał tego servisu jako domyślny
//sprawdzić czy traineeMapper może mieć metodę publiczną.