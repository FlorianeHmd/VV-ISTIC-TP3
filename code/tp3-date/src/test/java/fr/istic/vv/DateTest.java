package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    void testIsValidDate1() {
        assertTrue(Date.isValidDate(28,4,1997));
    }
    @Test
    void testIsValidDate2() {
        assertTrue(Date.isValidDate(29, 2, 2000));
    }
    //
    @Test
    void testiIsValidDate3() {
        assertFalse(Date.isValidDate(29, 2, 2001));
    }
    @Test
    void testIsValidDate4() {
        assertFalse(Date.isValidDate(1, 0, 2001));
    }
    @Test
    void testIsValidDate5() {
        assertFalse(Date.isValidDate(1, 13, 2001));
    }
    @Test
    void testIsValidDate6() {
        assertFalse(Date.isValidDate(0, 1, 2001));
    }
    @Test
    void testIsValidDate7() {
        assertFalse(Date.isValidDate(32, 1, 2001));
    }
    @Test
    void testIsValidDate8() {
        assertFalse(Date.isValidDate(0, 2, 2001));
    }
    @Test
    void testIsLeapYear1() {
        assertTrue(Date.isLeapYear(2004));
    }
    @Test
    void testIsLeapYear2() {
        assertFalse(Date.isLeapYear(2005));
    }
    @Test
    void testPreviousDate1() throws Exception {
        Date d = new Date(28,04,1997);
        Date result = d.previousDate();
        assertTrue(result.day == 27 && result.month == 4 && result.year == 1997);
    }
    @Test
    void testPreviousDate2() throws Exception {
        Date d = new Date(1,1,2000);
        Date result = d.previousDate();
        assertTrue(result.day == 31 && result.month == 12 && result.year == 1999);
    }
    @Test
    void testPreviousDate3() throws Exception {
        Date d = new Date(1,2,2000);
        Date result = d.previousDate();
        assertTrue(result.day == 31 && result.month == 1 && result.year == 2000);
    }
    @Test
    void testPreviousDate4() throws Exception {
        Date d = new Date(1,3,2000);
        Date result = d.previousDate();
        assertTrue(result.day == 29 && result.month == 2 && result.year == 2000);
    }
    @Test
    void testPreviousDate5() throws Exception {
        Date d = new Date(1,3,2001);
        Date result = d.previousDate();
        assertTrue(result.day == 28 && result.month == 2 && result.year == 2001);
    }
    @Test
    void testNextDate1() throws Exception {
        Date d = new Date(28,04,1997);
        Date result = d.nextDate();
        assertTrue(result.day == 29 && result.month == 4 && result.year == 1997);
    }
    @Test
    void testNextDate2() throws Exception {
        Date d = new Date(31,12,2000);
        Date result = d.nextDate();
        assertTrue(result.day == 1 && result.month == 1 && result.year == 2001);
    }
    @Test
    void testNextDate3() throws Exception {
        Date d = new Date(31,1,2000);
        Date result = d.nextDate();
        assertTrue(result.day == 1 && result.month == 2 && result.year == 2000);
    }
    @Test
    void testNextDate4() throws Exception {
        Date d = new Date(29,2,2000);
        Date result = d.nextDate();
        assertTrue(result.day == 1 && result.month == 3 && result.year == 2000);
    }
    @Test
    void testNextDate5() throws Exception {
        Date d = new Date(28,2,2000);
        Date result = d.nextDate();
        assertTrue(result.day == 29 && result.month == 2 && result.year == 2000);
    }
    @Test
    void testNextDate6() throws Exception {
        Date d = new Date(28,2,2001);
        Date result = d.nextDate();
        assertTrue(result.day == 1 && result.month == 3 && result.year == 2001);
    }
    @Test
    void testCompareTo1() throws Exception {
        Date d1 = new Date(28,2,2001);
        Date d2 = new Date(30,4,2000);
        assertTrue(d1.compareTo(d2) > 0 );
    }
    @Test
    void testCompareTo2() throws Exception {
        Date d1 = new Date(28,2,2000);
        Date d2 = new Date(30,4,2001);
        assertTrue(d1.compareTo(d2) < 0 );
    }
    @Test
    void testCompareTo3() throws Exception {
        Date d1 = new Date(28,6,2000);
        Date d2 = new Date(30,4,2000);
        assertTrue(d1.compareTo(d2) > 0 );
    }
    @Test
    void testCompareTo4() throws Exception {
        Date d1 = new Date(28,2,2000);
        Date d2 = new Date(30,4,2000);
        assertTrue(d1.compareTo(d2) < 0 );
    }
    @Test
    void testCompareTo5() throws Exception {
        Date d1 = new Date(28,2,2000);
        Date d2 = new Date(24,2,2000);
        assertTrue(d1.compareTo(d2) > 0 );
    }
    @Test
    void testCompareTo6() throws Exception {
        Date d1 = new Date(24,2,2000);
        Date d2 = new Date(28,2,2000);
        assertTrue(d1.compareTo(d2) < 0 );
    }
    @Test
    void testCompareTo7() throws Exception {
        Date d1 = new Date(24,2,2000);
        Date d2 = new Date(24,2,2000);
        assertTrue(d1.compareTo(d2) == 0 );
    }
}