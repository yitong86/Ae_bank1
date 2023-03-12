package com.capstone.Ae_bank;

import com.capstone.Ae_bank.repositories.PhoneValidationService;
import com.capstone.Ae_bank.service.TestPhoneValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.IntPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class testPhone {
    private final PhoneValidationService phoneValidationService = new TestPhoneValidation();


    @ParameterizedTest
    @ValueSource(strings = {"222 222 22 22", "2222222222", "+12222222222"})
    void testProcessValidPhones(String phone) {
        assertTrue(phoneValidationService.validatePhone(phone));
    }

    @ParameterizedTest
    @ValueSource(strings = {"22", "@+12222222222", "test"})
    void testProcessInvalidPhones(String phone) {
        assertFalse(phoneValidationService.validatePhone(phone));
    }

}


