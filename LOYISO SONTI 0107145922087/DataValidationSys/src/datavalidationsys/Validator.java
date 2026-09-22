package datavalidationsys;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Validator {

    public static String validateName(String name, String fieldName) {

        if (name.trim().isEmpty()) {
            return fieldName + " is required.";
        }

        if (!name.matches("[a-zA-Z ]+")) {
            return fieldName + " can only contain letters and spaces.";
        }

        if (name.trim().length() < 2) {
            return fieldName + " must contain at least 2 characters.";
        }

        if (name.trim().length() > 50) {
            return fieldName + " must not exceed 50 characters.";
        }

        return "";
    }

    public static String validateStudentNumber(String studentNumber) {

        if (studentNumber.trim().isEmpty()) {
            return "Student number is required.";
        }

        if (!studentNumber.matches("[0-9]+")) {
            return "Student number must contain numbers only.";
        }

        if (studentNumber.length() < 8 ||
                studentNumber.length() > 13) {

            return "Student number must contain between 8 and 13 digits.";
        }

        return "";
    }

    public static String validateDateOfBirth(String dateOfBirth) {

        if (dateOfBirth.trim().isEmpty()) {
            return "Date of birth is required.";
        }
        if (!dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Date of birth must use YYYY-MM-DD.";
        }
        try {

            LocalDate date =
                    LocalDate.parse(dateOfBirth);

            LocalDate today =
                    LocalDate.now();

            if (date.isAfter(today)) {
                return "Date of birth cannot be in the future.";
            }

            int age =
                    Period.between(date, today).getYears();

            if (age < 16 || age > 120) {
                return "Please enter a realistic date of birth.";
            }

        } catch (Exception e) {

            return "Please enter a valid date of birth.";
        }

        return "";
    }

    public static String validateContactNumber(String contact) {

        if (contact.trim().isEmpty()) {
            return "Contact number is required.";
        }

        if (!contact.matches("[0-9]+")) {
            return "Contact number must contain numbers only.";
        }

        if (contact.length() != 10) {
            return "Contact number must contain exactly 10 digits.";
        }

        if (!contact.startsWith("0")) {
            return "Contact number must start with 0.";
        }

        return "";
    }

    public static String validateEmail(String email) {

        if (email.trim().isEmpty()) {
            return "Email address is required.";
        }

        String emailPattern =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!Pattern.matches(emailPattern, email)) {
            return "Please enter a valid email address.";
        }

        return "";
    }

    public static String validatestudentnumber(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

