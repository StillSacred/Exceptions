package EHW3.src.model;

import EHW3.src.model.exceptions.ExtraDataException;
import EHW3.src.model.exceptions.InvalidCharactersException;
import EHW3.src.model.exceptions.InvalidGenderException;
import EHW3.src.model.exceptions.NotEnoughDataException;
import EHW3.src.model.exceptions.WrongDateException;

public class StringParser {
    private final InputValidator inputValidator = new InputValidator();

    public String[] parseString(String inputString) throws InvalidCharactersException,
            WrongDateException, InvalidGenderException, ExtraDataException, NotEnoughDataException,
            IllegalArgumentException {
        if (inputValidator.validate(inputString)) {
            return inputString.split(" ");
        } else throw new IllegalArgumentException("Invalid data was entered");
    }
}