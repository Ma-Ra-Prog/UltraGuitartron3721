package com.sda.ultraguitartron.notes;

import com.sda.ultraguitartron.exceptions.InvalidNoteInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NotesInputValidator {

    private final NoteService noteService;
    private final List<NoteInputModifier> noteInputModifiers;

    public String refactorToUppercase(String input){
        String noteRefactorHelper;
        switch (input.length()){
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

    private void validateCaseLengthEqualsOne(String input){
        if (!input.matches("[A-G]")) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

    private void validateCaseLengthEqualsTwo(String input){
        if (!input.matches("([a-g]{1}#)||([a-g]{1}b)||([A-G]{1}#||([A-G]{1}b))")) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

    private void validateCaseLengthEqualsFive(String input){
        if (!input.matches("([A-G]{1}#/[A-G]{1}b)")){
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

    public String toValidNoteRefactor(String input){
        int id = 2; //2 because it's first record in db with more complicated entry that would need input validation
        boolean isOver12 = false;
        while(input.length() > 1 && !input.equals(noteService.fetchNoteById((long) id).getNote()) && !isOver12){
            if (!input.equals(noteService.fetchNoteById((long) id).getNote().substring(0, 2)) && !input.equals(noteService.fetchNoteById((long) id).getNote().substring(3, 5))) {
                switch(id) {
                    case 2:
                        id = 4;
                        break;
                    case 4:
                        id = 7;
                        break;
                    case 7:
                        id = 9;
                        break;
                    case 9:
                        id = 11;
                    default:
                        isOver12 = true;
                        break;
                }
            } else {
                input = noteService.fetchNoteById((long) id).getNote();
            }
        }return input;
    }
}