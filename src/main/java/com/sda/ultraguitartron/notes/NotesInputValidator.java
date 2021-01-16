package com.sda.ultraguitartron.notes;

import java.util.List;

import com.sda.ultraguitartron.exceptions.InvalidNoteInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotesInputValidator {

    private final NoteService noteService;
    private List<NoteInputModifier> noteInputModifiers;

    public String refactorToUppercase(String input){
        String noteRefactorHelper;
        switch (input.length()){
            case 1:
                validateOne(input);
                return modifyInput(input, 1);
            case 2:
                validateTwo(input);
                return modifyInput(input, 2);
//                if (input.matches("([a-g]{1}#)||([a-g]{1}b)")) {
//                    noteRefactorHelper = input.substring(0, 1).toUpperCase();
//                    input = noteRefactorHelper + input.charAt(1);
//                } else if (!input.matches("([a-g]{1}#)||([a-g]{1}b)")&&!input.matches("([A-G]{1}#)||([A-G]{1}b)")){
//                    throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
//                }
                break;
            case 5:
                if (input.charAt(0) >= 'a' && input.charAt(0) <= 'g') {
                    noteRefactorHelper = input.substring(0, 1).toUpperCase();
                    input = noteRefactorHelper + input.substring(1, 5);
                } else if (!(input.charAt(0) >= 'A' && input.charAt(0) <= 'G')){
                    throw new InvalidNoteInputException("Invalid note input: " + input + " available notes are: C, C#/Db, D, D#/Eb, E, F, F#/Gb, G, G#/Ab, A, A#/Bb, B");
                }

                if (input.charAt(3) >= 'a' && input.charAt(3) <= 'g') {
                    noteRefactorHelper = input.substring(0, 3);
                    input = noteRefactorHelper + input.substring(3, 4).toUpperCase() + input.charAt(4);
                } else if (!(input.charAt(0) >= 'A' && input.charAt(0) <= 'G')) {
                    throw new InvalidNoteInputException("Invalid note input: " + input + " available notes are: C, C#/Db, D, D#/Eb, E, F, F#/Gb, G, G#/Ab, A, A#/Bb, B");
                }
                break;
            default:
                throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
        return input;
    }

    private void validateOne(String input) {
        if (!input.matches("[A-G]")) {
            throw new InvalidNoteInputException("Invalid note input: " + input + " try format X#/Yb or X# or Yb");
        }
    }

    private String modifyInput(String input, int idx) {
        final NoteInputModifier noteInputModifier = noteInputModifiers.stream()
            .filter(x -> x.getId() == idx)
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
