package com.kbilyk;
import com.kbilyk.item.Accessory;
import com.kbilyk.itemDAO.AccessoryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kbilyk.menu.MainMenu;

import static com.kbilyk.constant.AccessoryType.BEAR;

/**
 * Квіти. Визначити ієрархію квітів. Створити кілька об’єктів-квітів.
 * Зібрати букет (використовуючи аксесуари) з визначенням його вартості.
 * Здійснити сортування квітів у букеті на основі рівня свіжості.
 * Знайти квітку в букеті, що відповідає заданому діапазону довжин стебел.
 */

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args){
//        AccessoryDAO accessoryDao = new AccessoryDAO();
//        Accessory accessory = Accessory.builder()
//                .setAccessoryType(BEAR)
//                .setColour("BLUE")
//                .setPrice(45.3)
//                .setInfo("RGRG")
//                .built();
//        accessoryDao.getById(4554);
        MainMenu mainMenu = new MainMenu();
        mainMenu.execute();
    }
}