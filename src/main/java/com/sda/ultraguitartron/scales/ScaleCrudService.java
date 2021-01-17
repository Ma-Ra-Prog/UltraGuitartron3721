package com.sda.ultraguitartron.scales;

import com.sda.ultraguitartron.exceptions.ScaleNotFoundException;
import com.sda.ultraguitartron.notes.NoteService;
import com.sda.ultraguitartron.trainee.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class ScaleCrudService {

    private final ScaleRepository scaleRepository;
    private final ScaleMapper scaleMapper;
    private final NoteService noteService;

    ScaleDto fetchScaleById(Long id) {
        return scaleRepository.findById(id)
                .map(scaleMapper::mapToScaleDto)
                .orElseThrow(() -> new ScaleNotFoundException("Cannot find scale with ID: " + id));
    }

    List<ScaleDto> fetchAllScales() {
        return scaleRepository.findAll()
                .stream()
                .map(scaleMapper::mapToScaleDto)
                .collect(Collectors.toList());
    }

    ScaleDto createNewScale(ScaleDto scaleDto, Trainee trainee) {
        ScaleDefinition scaleDefinition = scaleMapper.mapToDefinition(scaleDto);
        Scale scale = scaleMapper.mapToScale(scaleDefinition);
        scale.setCreatedBy(trainee.getName());
        final Scale savedScale = scaleRepository.save(scale);
        return scaleMapper.mapToScaleDto(savedScale);
    }

    public ScaleDto fetchScaleByName(String name) {
        return scaleRepository.findByName(name)
                .map(scaleMapper::mapToScaleDto)
                .orElseThrow(NoSuchElementException::new);
    }

    public SpecificScale fetchScaleByNameAndRootNote(String scaleName, String rootNote) {
        ScaleDto scaleDto = fetchScaleByName(scaleName);
        Long rootNoteId = noteService.fetchNoteByName(rootNote).getId() - 1;
        List<String> noteList = new ArrayList<>();

        Stream.of(scaleDto.getFirstNote(), scaleDto.getSecondNote())
            .map(x -> ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(x) + rootNoteId))
            .collect(Collectors.toList());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getFirstNote()) + rootNoteId))
                .getNote());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getSecondNote()) + rootNoteId))
                .getNote());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getThirdNote()) + rootNoteId))
                .getNote());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getFourthNote()) + rootNoteId))
                .getNote());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getFifthNote()) + rootNoteId))
                .getNote());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getSixthNote()) + rootNoteId))
                .getNote());

        noteList.add(noteService
                .fetchNoteById(ifGreaterThanTwelveThenMinusTwelve(Long.valueOf(scaleDto.getSeventhNote()) + rootNoteId))
                .getNote());

        return new SpecificScale(scaleName, noteList);
    }

    private Long ifGreaterThanTwelveThenMinusTwelve(Long input) {
        if (input > 12) {
            return input - 12;
        } else {
            return input;
        }
    }
}
