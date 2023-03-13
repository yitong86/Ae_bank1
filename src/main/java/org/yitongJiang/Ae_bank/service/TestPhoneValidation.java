package org.yitongJiang.Ae_bank.service;

import org.yitongJiang.Ae_bank.repositories.PhoneValidationService;

import java.util.regex.Pattern;


//phone service valid
public class TestPhoneValidation implements PhoneValidationService {

    private final Pattern phoneRegex = Pattern.compile("^\\+?(?:[0-9] ?){6,14}[0-9]$");

    @Override
    public boolean validatePhone(String phone) {
        return phone != null && phoneRegex.matcher(phone).matches();
    }

}