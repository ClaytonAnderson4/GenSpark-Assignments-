package com.company.Test;

import com.company.Java.DrawBoard;

import com.company.Java.Main;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class DrawBoardTest {

    @Test
    void main(){

        HashSet<Character> chkSet= new HashSet<>();
        chkSet.add('a');
        chkSet.add('c');

        assertTrue(DrawBoard.Correct(chkSet,"ac"));
        assertFalse(DrawBoard.Correct(chkSet,"acdc"));

        chkSet.add('s');
        chkSet.add('v');
        chkSet.add('g');

        assertFalse(DrawBoard.UpdateML(chkSet));

        chkSet.add('i');
        chkSet.add('p');
        assertTrue(DrawBoard.UpdateML(chkSet));



    }

}
