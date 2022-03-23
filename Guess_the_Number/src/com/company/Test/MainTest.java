package com.company.Test;

import com.company.Java.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        assertEquals(true, Main.Checker(19,19));
        assertEquals(false, Main.Checker(20,19));
        assertEquals(false, Main.Checker(18,19));
    }
}