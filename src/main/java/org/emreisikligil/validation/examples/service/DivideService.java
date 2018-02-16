package org.emreisikligil.validation.examples.service;

import org.emreisikligil.validation.examples.validator.AssertTotal;

public class DivideService {

    @AssertTotal(100)
    public void divide(long x, long y) {
        System.out.println("Divided as " + x + " " + y);
    }
}
