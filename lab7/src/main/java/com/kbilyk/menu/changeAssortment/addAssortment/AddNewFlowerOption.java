package com.kbilyk.menu.changeAssortment.addAssortment;

import com.kbilyk.itemDAO.FlowerDAO;
import com.kbilyk.menu.MenuOption;

public class AddNewFlowerOption implements MenuOption {

    @Override
    public void execute() {
        FlowerDAO fDao = new FlowerDAO();
        fDao.insertWithEntering();
    }

    @Override
    public String getOptionName() {
        return "Add new flower";
    }
}
