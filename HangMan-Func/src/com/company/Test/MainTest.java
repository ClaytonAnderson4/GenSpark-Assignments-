package com.company.Test;

import com.company.Java.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void main(){
        HashSet<Character> chkSet= new HashSet<>();
        chkSet.add('a');
        chkSet.add('c');

        assertTrue(Main.inSet('c',chkSet));
        assertFalse(Main.inSet('g',chkSet));


        assertTrue(Main.isLetter('g'));
        assertFalse(Main.isLetter('5'));
        assertFalse(Main.isLetter('G'));

        assertEquals('a',Main.toLower('a'));
        assertEquals('a',Main.toLower('A'));
        assertEquals('z',Main.toLower('z'));
        assertEquals('z',Main.toLower('Z'));




    }


}
