package com.sda.ultraguitartron.scales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class SpecificScale {

private String name;
private List<String> noteList;
}
