package com.kbilyk.sortfilter;

import com.kbilyk.item.Flower;
import com.kbilyk.Database;
import com.kbilyk.constant.FlowerType;
import com.kbilyk.constant.OrderSort;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.kbilyk.Database.getConnection;
import static com.kbilyk.inputOutput.MakeBeautyOutput.printError;


public class SortFilterFlowersDAO implements SortFilterFlowersInter {

    private static final String GET_ALL_FLOWER = "SELECT * FROM flowers";

    private static final String SORT_BY_TYPE_FLOWER = "SELECT * FROM flowers WHERE flowerTypeID = ?";

    private static final String SORT_BY_FRESH_FLOWER = "SELECT flowerID, flowerTypeID, flowerColour, flowerLength, " +
            "flowerPrice, fDateDelivery FROM flowers ORDER BY fDateDelivery ";

    private static final String FILTER_FLOWERS_IN_PRICE_RANGE = "SELECT * FROM flowers WHERE flowerPrice >= ? AND" +
            " flowerPrice <= ? ";

    private static final String FILTER_FLOWERS_IN_LENGTH_RANGE = "SELECT * FROM flowers WHERE flowerLength >= ? AND" +
            " flowerLength <= ? ";

    private static final String MIN_PRICE_FLOWER = "SELECT MIN(flowerPrice) FROM flowers";

    private static final String MAX_PRICE_FLOWER = "SELECT MAX(flowerPrice) FROM flowers";

    private static final String MIN_LENGTH_FLOWER = "SELECT MIN(flowerLength) FROM flowers";

    private static final String MAX_LENGTH_FLOWER = "SELECT MAX(flowerLength) FROM flowers";


    /**
     * The method that returns all flowers from database
     * @return The list of all flowers from database
     */
    @Override
    public ArrayList<Flower> getAll() {
        Database.connection = getConnection();
        ArrayList<Flower> flowers = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(GET_ALL_FLOWER);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Flower flower = Flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setFlowerType(FlowerType.getFlowerType(rs.getInt("flowerTypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();

                flowers.add(flower);
            }
        } catch (SQLException e) {
            printError("Something went wrong! Сan`t get all flowers! Try again!");
        }
        return flowers;
    }


    public ArrayList<Flower> filterInRangeWithStatement(double min, double max, String statement){
        Database.connection = getConnection();
        ArrayList<Flower> flowers = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connection.prepareStatement(statement);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Flower flower = Flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setFlowerType(FlowerType.getFlowerType(rs.getInt("flowerTypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();

                flowers.add(flower);
            }
        } catch (SQLException e) {
            printError("Something went wrong! Сan`t get flowers by range! Try again!");
        }
        return flowers;
    }

    /**
     * The method that searches for flowers in a price range in database
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of flowers in the price range in database
     */
    @Override
    public ArrayList<Flower> filterInPriceRange(double min, double max) {
        return filterInRangeWithStatement(min, max, FILTER_FLOWERS_IN_PRICE_RANGE);
    }

    /**
     * The method that searches for flowers in a length range from database
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of flowers in the length range from database
     */
    @Override
    public ArrayList<Flower> filterInLengthRange(double min, double max) {
        return filterInRangeWithStatement(min, max, FILTER_FLOWERS_IN_LENGTH_RANGE);
    }

    /**
     * The method that searches for flowers of a given type from database
     * @param flowerType The flower type
     * @return The list of flowers of a given type
     */
    @Override
    public ArrayList<Flower> sortByType(FlowerType flowerType) {
        Database.connection = getConnection();
        ArrayList<Flower> flowers = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(SORT_BY_TYPE_FLOWER);
            ps.setInt(1, flowerType.getNumType());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Flower flower = Flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setFlowerType(FlowerType.getFlowerType(rs.getInt("flowerTypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();

                flowers.add(flower);
            }
        } catch (SQLException e) {
            printError("Something went wrong! Сan`t get flowers filtered by type! Try again!");
        }
        return flowers;
    }

    /**
     * The method that sorts all flowers in ascending or descending order of freshness from database
     * @param sort Sorting type (ascending OR descending)
     * @return The list of all flowers in ascending or descending order of freshness from database
     */
    @Override
    public ArrayList<Flower> sortByFresh(OrderSort sort) {
        Database.connection = getConnection();
        ArrayList<Flower> flowers = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(SORT_BY_FRESH_FLOWER + sort);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Flower flower = Flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setFlowerType(FlowerType.getFlowerType(rs.getInt("flowerTypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();

                flowers.add(flower);
            }
        } catch (SQLException e) {
            printError("Something went wrong! Сan`t get flowers sorted by fresh! Try again!");
        }
        return flowers;
    }

    /**
     * The method that processes a sql query to find some maximum or minimum value from database
     * @param statement The statement of sql query
     * @return The min or max value
     */
    public Double minOrMaxStatement(String statement){
        Database.connection = getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            printError("Something went wrong! Try again!");
        }
        return null;
    }

    /**
     * The method that looks for the maximum price of a flower in database
     * @return The maximum price of a flower in database
     */
    @Override
    public Double maxPrice() {
        return minOrMaxStatement(MAX_PRICE_FLOWER);
    }

    /**
     * The method that looks for the minimum price of a flower in database
     * @return The minimum price of a flower in database
     */
    @Override
    public Double minPrice() {
        return minOrMaxStatement(MIN_PRICE_FLOWER);
    }

    /**
     * The method that looks for the minimum length of a flower in database
     * @return The minimum price of a flower
     */
    @Override
    public Double minLength(){
        return minOrMaxStatement(MIN_LENGTH_FLOWER);
    }

    /**
     * The method that looks for the maximum length of a flower in database
     * @return The maximum length of a flower in database
     */
    @Override
    public Double maxLength(){
        return minOrMaxStatement(MAX_LENGTH_FLOWER);
    }
}
