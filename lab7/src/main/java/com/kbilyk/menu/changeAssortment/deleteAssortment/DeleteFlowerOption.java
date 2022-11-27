package com.kbilyk.menu.changeAssortment.deleteAssortment;

import com.kbilyk.itemDAO.FlowerDAO;

public class DeleteFlowerOption implements com.kbilyk.menu.MenuOption {

    @Override
    public void execute() {
        FlowerDAO flowerDao = new FlowerDAO();
        flowerDao.deleteFromFiltered();
    }

    @Override
    public String getOptionName() {
        return "Delete flower from list";
    }
}
