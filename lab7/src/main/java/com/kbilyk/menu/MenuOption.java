package com.kbilyk.menu;

public interface MenuOption {

     /**
      * Method that executes an option or menu
      */
     void execute();

     /**
      * Get the name of option
      * @return The option name
      */
     String getOptionName();
}
