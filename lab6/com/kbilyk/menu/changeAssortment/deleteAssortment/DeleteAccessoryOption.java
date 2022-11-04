package com.kbilyk.menu.changeAssortment.deleteAssortment;

import com.kbilyk.itemDAO.AccessoryDAO;
import com.kbilyk.menu.MenuOption;

public class DeleteAccessoryOption implements MenuOption {

    @Override
    public void execute() {
        AccessoryDAO accessoryDao = new AccessoryDAO();
        accessoryDao.deleteFromFiltered();
    }

    @Override
    public String getOptionName() {
        return null;
    }
}
