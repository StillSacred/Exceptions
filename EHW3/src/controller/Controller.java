package EHW3.src.controller;

import EHW3.src.model.DataSaver;
import EHW3.src.model.StringParser;
import EHW3.src.model.exceptions.ExtraDataException;
import EHW3.src.model.exceptions.InvalidCharactersException;
import EHW3.src.model.exceptions.InvalidGenderException;
import EHW3.src.model.exceptions.NotEnoughDataException;
import EHW3.src.model.exceptions.WrongDateException;

public class Controller {
    private static StringParser stringParser;
    private static DataSaver dataSaver;

    public Controller(StringParser stringParser, DataSaver dataSaver) {
        this.stringParser = stringParser;
        this.dataSaver = dataSaver;
    }

    public static void saveData(String input) throws InvalidCharactersException, WrongDateException,
            InvalidGenderException, ExtraDataException, NotEnoughDataException {
        dataSaver.saveData(stringParser.parseString(input));
    }
}