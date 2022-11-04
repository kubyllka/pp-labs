package com.kbilyk.menu.changeAssortment.addAssortment;

import com.kbilyk.itemDAO.AccessoryDAO;
import com.kbilyk.menu.MenuOption;

public class AddNewAccessoryOption implements MenuOption {

    @Override
    public void execute(){
        AccessoryDAO aDao = new AccessoryDAO();
        aDao.insertWithEntering();
    }

    @Override
    public String getOptionName() {
        return "Add new accessory";
    }
}
