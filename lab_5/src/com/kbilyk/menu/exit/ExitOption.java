package com.kbilyk.menu.exit;

import com.kbilyk.menu.MenuOption;

public class ExitOption  implements MenuOption {

    private final String name = "Exit";

    public ExitOption() {}

    @Override
    public void execute() {
        System.out.println("---------------------------------------------------");
        System.out.println("Program execution is complete. Have a nice day! =)");
        System.out.println("---------------------------------------------------");
        System.exit(0);
    }

    public String getOptionName(){
        return name;
    }
}
