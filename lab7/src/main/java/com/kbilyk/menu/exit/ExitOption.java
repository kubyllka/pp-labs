package com.kbilyk.menu.exit;

import com.kbilyk.menu.MenuOption;

import static com.kbilyk.inputOutput.MakeBeautyOutput.printBanner;

public class ExitOption  implements MenuOption {

    public ExitOption() {}

    @Override
    public void execute() {
        printBanner("Program execution is complete. Have a nice day! =)");
        System.exit(0);
    }

    public String getOptionName(){
        return "Exit";
    }
}
