package com.sda.ultraguitartron.utils;

import com.sda.ultraguitartron.trainee.Trainee;
import com.sda.ultraguitartron.trainee.TraineeFetchService;
import com.sda.ultraguitartron.trainee.TraineeUserAdapter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserService implements UserDetailsService {

    private final TraineeFetchService traineeFetchService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Trainee trainee = traineeFetchService.fetchTraineeByName(s);

        return new TraineeUserAdapter(trainee);
    }
}

//powiedziec springowi, aby używał tego servisu jako domyślny