/*
 * UCF COP3330 Fall 2021 Assignment 4 Solution
 * Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item testItem = new Item();

    @Test
    @DisplayName("Testing if setting description works correctly")
    public void test_setDescription_works() {
        testItem.setDescription("Testing");
        String actual = testItem.getDescription();
        String expected = "Testing";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Testing setting date to default, if not in proper format")
    public void test_setDueDate_default_improper_format() {
        testItem.setDueDate("");
        String actual = testItem.getDueDate();
        String expected = "YYYY-MM-DD";
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Testing setDueDate to default if day is not in correct format")
    public void test_setDueDate_invalid_day() {
        testItem.setDueDate("2021-11-55");
        String actual = testItem.getDueDate();
        String expected = "YYYY-MM-DD";
        assertEquals(expected, actual);
    }
}