package com.kbilyk.itemDAO;
import com.kbilyk.*;
import com.kbilyk.constant.FlowerType;
import com.kbilyk.inputOutput.InputControl;
import com.kbilyk.item.Flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.kbilyk.Bouquet.bouquetFlowers;
import static com.kbilyk.inputOutput.InputControl.enterCorrectIndexFlowers;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printError;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printInfoEntering;
import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filteredFlowers;

public class FlowerDAO implements ItemDAO<Flower> {

    private static final Logger logger = LogManager.getLogger(FlowerDAO.class);
    private static final String GET_FLOWER_BY_ID = "SELECT * FROM flowers WHERE flowerID = ?";
    private static final String DELETE_FLOWER_BY_ID = "DELETE FROM flowers WHERE flowerID = ?";
    private static final String INSERT_FLOWER = "INSERT INTO flowers ( flowerTypeID, flowerColour, flowerLength," +
            " flowerPrice) VALUES( ?, ?, ?, ?);";

    @Override
    public Flower getById(int id) {
       Database.connection = Database.getConnection();
        Flower flower = null;

        try {
            PreparedStatement ps = Database.connection.prepareStatement(GET_FLOWER_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                flower = Flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setFlowerType(FlowerType.getFlowerType(rs.getInt("flowerTypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();
            }

            if(flower == null){
                logger.info("Cannot find the flower with id = " + id + " in database.");
            }else{
                logger.info("The flower with id = " + id + " was found in database.");
            }

            return flower;

        } catch (SQLException e) {
            logger.error("An error occurred while searching flower with id = " + id + ".\n" + e.getMessage());
        }
        return null;
    }

    @Override
    public int delete(Flower flower) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(DELETE_FLOWER_BY_ID);
            ps.setInt(1, flower.getId());
            int res = ps.executeUpdate();

            if(res == 0){
                logger.info("The flower " + flower + " was NOT deleted from database.");
            }else{
                logger.info("The flower " + flower + " was deleted from database.");
            }

            return res;

        } catch (SQLException e) {
            logger.error("An error occurred while deleting flower" + flower + ".\n " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int insert(Flower flower) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(INSERT_FLOWER);
            ps.setInt(1, flower.getFlowerType().getNumType());
            ps.setString(2, flower.getColour());
            ps.setDouble(3,  flower.getLength());
            ps.setDouble(4,  flower.getPrice());

            int res = ps.executeUpdate();

            if(res == 0){
                logger.info("The flower " + flower + " was NOT inserted to database.");
            }else{
                logger.info("The flower " + flower + " was inserted to database.");
            }

            return res;

        } catch (SQLException e) {
            logger.error("An error occurred during insertion new flower" + flower + ".\n " + e.getMessage());
        }
        return 0;
    }

    /**
     * Method that inserts the new flower/flowers to the database
     * Method asks user to create a new accessory to insert
     */
    @Override
    public void insertWithEntering(){
        Flower flower = Flower.builder()
                .setFlowerType()
                .setColour()
                .setLength()
                .setPrice()
                .built();

        printInfoEntering("Enter how many such flowers you want to add (is it one flower or a whole batch)." +
                " Enter a number: ");

        int count = InputControl.enterCorrectInt();
        int added = 0;
        for(int i = 0; i < count; i++) if(insert(flower) == 1) added++;

        if(added == count){
            System.out.println("\n The flowers were successfully added!");
        }
    }

    /**
     * Method deletes one flower that is in filtered list from database
     * Method asks the user to choose the flower to delete
     */
    @Override
    public void deleteFromFiltered() {
        Flower flower = enterCorrectIndexFlowers(filteredFlowers);
        if(flower != null){
            delete(flower);
            filteredFlowers.set(filteredFlowers.indexOf(flower), null);
        }
    }

    /**
     * Method deletes all flowers that is in bouquet from database
     */
    @Override
    public void deleteAllFromBouquet(){
        for(Flower flower : bouquetFlowers){
            delete(flower);
        }
        bouquetFlowers.clear();
    }
}
