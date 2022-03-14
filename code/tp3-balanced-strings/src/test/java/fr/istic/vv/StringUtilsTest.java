package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    void testIsBalancedEmptyString() {
        assertTrue(isBalanced(""));
    }
    @Test
    void testIsBalancedParenthesis() {
        assertTrue(isBalanced("()"));
    }
    @Test
    void testIsBalancedBracket() {
        assertTrue(isBalanced("[]"));
    }
    @Test
    void testIsBalancedAccolade() {
        assertTrue(isBalanced("{}"));
    }
    @Test
    void testIsBalancedAccolade1() {
        assertTrue(isBalanced("{[][]}(())"));
    }
    @Test
    void testIsBalancedAccolade2() {
        assertFalse(isBalanced("]["));
    }
    @Test
    void testIsBalancedAccolade3() {
        assertFalse(isBalanced("([)]"));
    }
    @Test
    void testIsBalancedAccolade4() {
        assertFalse(isBalanced("{"));
    }
    @Test
    void testIsBalancedAccolade5() {
        assertFalse(isBalanced("{(}{}"));
    }
}