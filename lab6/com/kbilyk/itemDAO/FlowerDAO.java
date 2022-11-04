package com.kbilyk.itemDAO;
import com.kbilyk.*;
import com.kbilyk.constant.FlowerType;
import com.kbilyk.inputOutput.InputControl;
import com.kbilyk.item.Flower;

import java.sql.*;

import static com.kbilyk.Bouquet.bouquetFlowers;
import static com.kbilyk.inputOutput.InputControl.enterCorrectIndexFlowers;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printError;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printInfoEntering;
import static com.kbilyk.sortfilter.FilterFlowersWithEntering.filteredFlowers;

public class FlowerDAO implements ItemDAO<Flower> {
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

            return flower;

        } catch (SQLException e) {
            printError("An error occurred while searching flower! Try again!");
        }
        return null;
    }

    @Override
    public int delete(Flower flower) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(DELETE_FLOWER_BY_ID);
            ps.setInt(1, flower.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            printError("An error occurred while deleting flower! Try again! ");
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

            return ps.executeUpdate();

        } catch (SQLException e) {
            printError("An error occurred during insertion flower! Try again! ");
            return 0;
        }
    }

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

    @Override
    public void deleteFromFiltered() {
        Flower flower = enterCorrectIndexFlowers(filteredFlowers);
        if(flower != null){
            delete(flower);
            filteredFlowers.set(filteredFlowers.indexOf(flower), null);
        }
    }

    public void deleteAllFromBouquet(){
        for(Flower flower : bouquetFlowers){
            delete(flower);
        }
        bouquetFlowers.clear();
    }
}
