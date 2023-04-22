package EHW3.src.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import EHW3.src.model.exceptions.ExtraDataException;
import EHW3.src.model.exceptions.InvalidCharactersException;
import EHW3.src.model.exceptions.InvalidGenderException;
import EHW3.src.model.exceptions.NotEnoughDataException;
import EHW3.src.model.exceptions.WrongDateException;

public class InputValidator {
    private final String nameFormat = "[a-zA-Z]+";
    private final String phoneFormat = "7\\d{10}";
    private final String genderMale = "m";
    private final String genderFemale = "f";
    private final String dateForomat = "dd.MM.yyyy";

    public boolean validate(String str)
            throws NotEnoughDataException, ExtraDataException, InvalidCharactersException, WrongDateException,
            InvalidGenderException {
        String[] strArray = str.split(" ");
        validateDataCount(strArray);
        if (!validateName(strArray[0]) || !validateName(strArray[1]) || !validateName(strArray[2])) {
            throw new InvalidCharactersException("Invalid characters were entered in the name");
        }
        if (!validateDate(strArray[3])) {
            throw new WrongDateException("Wrong date was entered");
        }
        if (!validateGender(strArray[4])) {
            throw new InvalidGenderException("Invalid gender was entered");
        }
        if (!validatePhoneNumber(strArray[5])) {

            throw new InvalidCharactersException("The length of the phone number must be strictly 11 characters. " +
                    "The number must start with the number 7.");
        }
        return true;
    }

    private boolean validateDataCount(String[] strArray) throws NotEnoughDataException, ExtraDataException {
        if (strArray.length > 6) {
            throw new ExtraDataException("Extra data was entered");
        } else if (strArray.length < 6) {
            throw new NotEnoughDataException("Insufficient data was entered");
        } else return true;
    }

    private boolean validateName(String str) {
        return str.matches(nameFormat);
    }

    private boolean validateGender(String str) {
        return str.equals(genderFemale) || str.equals(genderMale);
    }

    private boolean validateDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat(dateForomat);
        format.setLenient(false);
        try {
            Date inputDate = format.parse(strDate);
            if (inputDate.after(new Date()) || inputDate.before(format.parse("01.01.1900"))) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean validatePhoneNumber(String str) {
        return str.matches(phoneFormat);
    }
}