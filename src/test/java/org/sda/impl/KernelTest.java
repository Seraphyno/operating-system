package org.sda.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class KernelTest {
    
    private Kernel target = new Kernel();
    private static final String STARTED_ERROR = "Target is started";
    private static final String NOT_STARTED_ERROR = "Target is not started";
    
    @Test
    public void a_testStartUp() {
        assertFalse(STARTED_ERROR, target.isStarted());
        target.startUp();
        assertTrue(NOT_STARTED_ERROR, target.isStarted());
    
        System.out.println("-------------------------------\n");
    }
    
    @Test
    public void b_testShutdown() {
        target.startUp();
        target.shutDown();
        assertFalse(STARTED_ERROR, target.isStarted());
    
        System.out.println("-------------------------------\n");
    }
    
    @Test
    public void c_testLogin() {
        target.startUp();
        String loginMessage = target.login("root", "root");
        assertNotNull(loginMessage);
        assertEquals("Login successful for user 'root'", loginMessage);
        
        loginMessage = target.login("student", "student");
        assertNotNull(loginMessage);
        assertEquals("Login failed. User 'root' is already logged in.", loginMessage);
        
        target.logout();
        loginMessage = target.login("Serafino", "123qweASD!");
        assertNotNull(loginMessage);
        assertEquals("Login failed for 'Serafino'", loginMessage);
    
        System.out.println("-------------------------------\n");
    }
    
    @Test
    public void d_testLogout() {
        target.startUp();
        target.login("root", "root");
        String logoutMessage = target.logout();
        
        assertNotNull(logoutMessage);
        assertEquals("Logging out user 'root'!", logoutMessage);
        
        logoutMessage = target.logout();
        assertNotNull(logoutMessage);
        assertEquals("User is not logged in!", logoutMessage);
    
        System.out.println("-------------------------------\n");
    }
}