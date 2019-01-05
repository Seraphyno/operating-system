package org.sda.lib;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserDatabaseTest {
    
    @Test
    public void testValidate() {
        assertTrue(UserDatabase.validate("root", "root"));
        assertTrue(UserDatabase.validate("admin", "123qweASD!"));
        assertTrue(UserDatabase.validate("student", "student"));
        assertFalse(UserDatabase.validate("Serafino", "123qweASD$!"));
    }
    
}