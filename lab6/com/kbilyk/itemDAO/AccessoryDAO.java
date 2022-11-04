package com.kbilyk.itemDAO;

import com.kbilyk.item.Accessory;
import com.kbilyk.Database;
import com.kbilyk.inputOutput.InputControl;
import com.kbilyk.constant.AccessoryType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.kbilyk.Bouquet.bouquetAccessories;
import static com.kbilyk.inputOutput.InputControl.enterCorrectIndexAccessory;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printError;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printInfoEntering;
import static com.kbilyk.sortfilter.FilterAccessoriesWithEntering.filteredAccessories;


public class AccessoryDAO implements ItemDAO<Accessory> {
    private static final String GET_ACCESSORY_BY_ID = "SELECT * FROM accessories WHERE accessoryID = ?";
    private static final String DELETE_ACCESSORY_BY_ID = "DELETE FROM accessories WHERE accessoryID = ?";
    private static final String INSERT_ACCESSORY = "INSERT INTO accessories (accessoryTypeID, accessoryColour," +
            " accessoryPrice, accessoryInfo) VALUES( ?, ?, ?, ?);";


    @Override
    public Accessory getById(int id) {
        Database.connection = Database.getConnection();
        Accessory accessory = null;

        try {
            PreparedStatement ps = Database.connection.prepareStatement(GET_ACCESSORY_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                accessory = Accessory.builder()
                        .setId(rs.getInt("accessoryID"))
                        .setAccessoryType(AccessoryType.getAccessoryType(rs.getInt("accessoryTypeID")))
                        .setColour(rs.getString("accessoryColour"))
                        .setPrice(rs.getDouble("accessoryPrice"))
                        .setInfo(rs.getString("accessoryInfo"))
                        .built();
            }

            return accessory;

        } catch (SQLException e) {
            printError("An error occurred while searching accessory! Try again!");
        }
        return null;
    }

    @Override
    public int delete(Accessory accessory) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(DELETE_ACCESSORY_BY_ID);
            ps.setInt(1, accessory.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            printError("An error occurred while deleting accessory! Try again! ");
            return 0;
        }
    }

    @Override
    public int insert(Accessory accessory) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(INSERT_ACCESSORY);
            ps.setInt(1, accessory.getAccessoryType().getNumType());
            ps.setString(2, accessory.getColour());
            ps.setDouble(3,  accessory.getPrice());
            ps.setString(4,  accessory.getInfo());

            return ps.executeUpdate();

        } catch (SQLException e) {
            printError("An error occurred during insertion accessory! Try again! ");
            return 0;
        }
    }

    @Override
    public void insertWithEntering(){

        Accessory accessory = Accessory.builder()
                .setAccessoryType()
                .setColour()
                .setPrice()
                .setInfo()
                .built();

        printInfoEntering("Enter how many such accessories you want to add (is it one accessory or a whole batch)." +
                "\nEnter a number: ");

        int count = InputControl.enterCorrectInt();

        int added = 0;
        for(int i = 0; i < count; i++) if(insert(accessory) == 1) added++;

        if(added == count){
            System.out.println("\n The accessories were successfully added!");
        }
    }


    @Override
    public void deleteFromFiltered() {
        Accessory accessory = enterCorrectIndexAccessory(filteredAccessories);
        if(accessory != null){
            delete(accessory);
            filteredAccessories.set(filteredAccessories.indexOf(accessory), null);
        }
    }

    public void deleteAllFromBouquet(){
        for(Accessory accessory : bouquetAccessories){
            delete(accessory);
        }
        bouquetAccessories.clear();
    }
}
