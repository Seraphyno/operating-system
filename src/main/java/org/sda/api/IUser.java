package org.sda.api;

import org.sda.impl.Password;

/**
 * Interface to define User behavior
 */
public interface IUser {
   
   /**
    * Retrieve the username
    * @return username as a string
    */
   String getUsername();
   
   /**
    * Retrieve the password
    * @return password as an object
    */
   Password getPassword();
}
