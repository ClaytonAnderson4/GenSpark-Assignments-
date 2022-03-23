package com.company.test;

import com.company.Java.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
    assertEquals(true,Main.Resposes(1));
    assertEquals(true,Main.Resposes(2));
    assertEquals(false,Main.Resposes(5));



    }
}