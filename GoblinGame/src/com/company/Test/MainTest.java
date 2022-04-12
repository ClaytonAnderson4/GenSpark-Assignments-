package com.company.Test;

import com.company.Java.Land;
import com.company.Java.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void main(){
        assertTrue(Main.CheckInput('n'));
        assertTrue(Main.CheckInput('s'));
        assertTrue(Main.CheckInput('e'));
        assertTrue(Main.CheckInput('w'));
        assertFalse(Main.CheckInput('N'));
        assertFalse(Main.CheckInput('g'));

        assertEquals('a',Main.convertCase('A'));
        assertEquals('z',Main.convertCase('Z'));
        assertEquals('a',Main.convertCase('a'));
        assertEquals('z',Main.convertCase('z'));


    }

}
