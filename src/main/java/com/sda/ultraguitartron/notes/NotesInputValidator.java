package com.sda.ultraguitartron.notes;

import com.sda.ultraguitartron.exceptions.InvalidNoteInputException;
import com.sda.ultraguitartron.exceptions.NoteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotesInputValidator {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    private final List<NoteInputModifier> noteInputModifiers;
    private final List<Integer> LIST_OF_COMPLICATED_NOTE_ENTRIES_IDS = List.of(2, 4, 7, 9, 11);

    public String validate(String input) {
        String validatedInput = toValidNoteRefactor(refactorToUppercaseAndValidateLength(input));
        finalValidator(validatedInput);
        return validatedInput;
    }

    public String refactorToUppercaseAndValidateLength(String input) {
        switch (input.length()) {
            case 1:
                input = modifyInput(input, input.length());
                validateCaseLengthEqualsOne(input);
                break;
            case 2:
                input = modifyInput(input, input.length());
                validateCaseLengthEqualsTwo(input);
                break;
            case 5:
                input = modifyInput(input, input.length());
                validateCaseLengthEqualsFive(input);
                break;
            default:
                throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
        return input;
    }

    private void validateCaseLengthEqualsOne(String input) {
        if (!input.matches("[A-G]")) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

    private void validateCaseLengthEqualsTwo(String input) {
        if (!input.matches("([a-g]{1}#)||([a-g]{1}b)||([A-G]{1}#||([A-G]{1}b))")) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

    private void validateCaseLengthEqualsFive(String input) {
        if (!input.matches("([A-G]{1}#/[A-G]{1}b)")) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

    private String modifyInput(String input, int index) {
        final NoteInputModifier noteInputModifier = noteInputModifiers.stream()
                .filter(x -> x.getId() == index)
                .findFirst()
                .get();
        return noteInputModifier.modify(input);
    }

    public String toValidNoteRefactor(String input) {
        for (int id : LIST_OF_COMPLICATED_NOTE_ENTRIES_IDS) {
            if (input.equals(fetchNoteValueById(id).substring(0, 2)) || input.equals(fetchNoteValueById(id).substring(3, 5))) {
                return input = fetchNoteValueById(id);
            }
        }
        return input;
    }

    public void finalValidator(String input) {
        if (!input.equals(fetchNoteValueByName(input))) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

//    public String alternativeToValidNoteRefactor(String input) {
//        String inputForStream = input;
//        Integer fullNoteId = LIST_OF_COMPLICATED_NOTE_ENTRIES_IDS.stream()
//                .filter(id -> inputForStream
//                        .equals(noteService.fetchNoteById((long) id)
//                                .getNote()
//                                .substring(0, 2))
//                        || inputForStream
//                        .equals(noteService.fetchNoteById((long) id)
//                                .getNote()
//                                .substring(3, 5)))
//                .collect(Collectors.toList())
//                .get(0);
//        return input = noteService.fetchNoteById((long) fullNoteId).getNote();
//    }

    private String fetchNoteValueById(int id) {
        return noteRepository.findById((long) id)
                .map(noteMapper::mapToNoteDto)
                .orElseThrow(() -> new NoteNotFoundException("Note not found")).getNote();
    }

    private String fetchNoteValueByName(String name) {
        return noteRepository.findByNote(name)
                .map(noteMapper::mapToNoteDto)
                .orElseThrow(() -> new NoteNotFoundException("Note not found")).getNote();
    }
}