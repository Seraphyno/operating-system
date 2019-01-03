package org.sda.api;

/**
 * Interface which defines the behavior of the OS
 */
public interface IKernel {
    
    /**
     * Start the OS
     */
    void startUp();
    
    /**
     * Close the OS
     */
    void shutDown();
    
    /**
     * Login a given user by credentials
     * @return A message: "Login successful" / "Login failed"
     */
    String login(String username, String password);
    
    /**
     * Log out the current user
     * @return A message: "Logout successful" / "Logout failed"
     */
    String logout();
    
}
