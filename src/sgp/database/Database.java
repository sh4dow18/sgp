
package sgp.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class Database {
    private static Database instance;
    private final Connection_Manager connection;
    
    public Database() {
        connection = new Connection_Manager();
    }
    
    public static Database get_instance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection get_connection() {
       return connection.get_connection();
    }
    public boolean is_on() {
        return connection.is_on();
    }
    public int add_register(int identification, String services, String description, String created, String promotions) {
        int result = 0;
        try {
            PreparedStatement statement = get_connection().prepareStatement("INSERT INTO registers (id, services, details, created, finished, delivered, promotions) VALUES (?,?,?,?,?,?,?)");
            statement.setInt(1, identification);
            statement.setString(2, services);
            statement.setString(3, description);
            statement.setString(4, created);
            statement.setString(5, "Not Yet");
            statement.setString(6, "Not Yet");
            statement.setString(7, promotions);
            if (statement.executeUpdate() != 1) {
                result = 2;
            }
        }
        catch (SQLException e) {
            result = 1;
            System.err.println(e);
        }
        connection.close();
        return result;
    }
    public int add_service(String name, int garanty, int price) {
        int result = 0;
        try {
            PreparedStatement statement = get_connection().prepareStatement("INSERT INTO services (name, garanty, price) VALUES (?,?,?);");
            statement.setString(1, name);
            statement.setInt(2, garanty);
            statement.setInt(3, price);
            if (statement.executeUpdate() != 1) {
                result = 2;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            result = 1;
        }
        connection.close();
        return result;
    }    
    public boolean are_services_in() {
        int counter = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM services;");
            while (query.next()) {
                counter = counter + 1;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        if (counter == 0) {
            return false;
        }
        return true;
    }
    public boolean are_clients_in() {
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT COUNT(*) FROM clients;");
            if (query.next()) {
                if (query.getInt(1) > 0) {
                    return true;
                }
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return false;
    }
    public String[] show_services() {
        ArrayList<String> services = new ArrayList();
        try {
            Statement statement  = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM services;");
            while (query.next()) {
                services.add(query.getString("name"));
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return Arrays.copyOf(services.toArray(), services.size(), String[] .class);
    }
    public DefaultTableModel obtain_model_for_registers(String query_string) {
        int number_of_registers = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery(query_string.replace("*", "COUNT(*)"));
            if (query.next()) {
                number_of_registers = query.getInt(1);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        int counter = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery(query_string);
            String columns[] = {"Code", "Identification", "Created on", "Services"};
            String data[][] = new String[number_of_registers][4];
            while (query.next()) {
                data[counter][0] = String.format("%05d", query.getInt(1));
                data[counter][1] = query.getInt(2) + "";
                data[counter][2] = query.getString(5);
                data[counter][3] = obtain_services_names(query.getString(3));
                counter++;
            }
            connection.close();
            return new DefaultTableModel(data, columns);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return new DefaultTableModel();
    }
    public int obtain_service_code(String service) {
        int result = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM services WHERE name = '" + service + "';");
            if (query.next()) {
                result = query.getInt(1);
            }
        }
        catch (SQLException e) {
            result = -1;
            System.err.println(e);
        }
        connection.close();
        return result;
    }
    public DefaultTableModel obtain_model_for_services() {
        int number_of_registers = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT COUNT(*) FROM services;");
            if (query.next()) {
                number_of_registers = query.getInt(1);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        int counter = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM services;");
            String columns[] = {"Name", "Garanty", "Price"};
            String data[][] = new String[number_of_registers][3];
            while (query.next()) {
                data[counter][0] = query.getString(2);
                data[counter][1] = query.getInt(3) + "";
                data[counter][2] = query.getInt(4) + "";
                counter++;
            }
            connection.close();
            return new DefaultTableModel(data, columns);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return new DefaultTableModel();
    }
    public String obtain_service_name(int code) {
        String service = "";
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM services WHERE id = " + code + ";");
            if (query.next()) {
                service = query.getString(2);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return service;
    }
    public String obtain_services_names(String codes) {
        ArrayList<String> codes_array = new ArrayList(Arrays.asList(codes.split("\\s*, \\s*")));
        String codes_string = "";
        for (int iterator = 0; iterator < codes_array.size(); iterator++) {
            codes_string = codes_string + obtain_service_name(Integer.parseInt(codes_array.get(iterator)));
            if (iterator != codes_array.size() - 1) {
                codes_string = codes_string + ",";
            }
        }
        return codes_string;
    }
    public ArrayList<String> obtain_register(int code) {
        ArrayList<String> register = new ArrayList();
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM registers WHERE code = " + code + ";");
            if (query.next()) {
                register.add(code + "");
                register.add(query.getInt(2) + "");
                register.add(query.getString(3));
                register.add(query.getString(4));
                register.add(query.getString(5));
                register.add(query.getString(6));
                register.add(query.getString(7));
                register.add(query.getString(8));
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return register;
    }
    public int remove_register(int code) {
        int result = 0;
        try {
            PreparedStatement statement = get_connection().prepareStatement("DELETE FROM registers WHERE code = ?;");
            statement.setInt(1, code);
            if (statement.executeUpdate() != 1) {
                result = 2;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            result = 1;
        }
        connection.close();
        return result;
    }
    public int save_dates(int code, String finished, String delivered) {
        int result = 0;
        try {
            PreparedStatement statement = get_connection().prepareStatement("UPDATE registers SET finished = ?, delivered = ? WHERE code = ?;");
            statement.setString(1, finished);
            statement.setString(2, delivered);
            statement.setInt(3, code);
            if (statement.executeUpdate() != 1) {
                result = 2;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            result = 1;
        }
        connection.close();
        return result;
    }
    public ArrayList<String> obtain_service(int code) {
        ArrayList<String> service = new ArrayList();
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM services WHERE id = " + code + ";");
            if (query.next()) {
                service.add(query.getInt(1) + "");
                service.add(query.getString(2));
                service.add(query.getInt(3) + "");
                service.add(query.getInt(4) + "");
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return service;
    }
    public ArrayList<String> obtain_client(int id) {
        ArrayList<String> client = new ArrayList();
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM clients WHERE id = " + id + ";");
            if (query.next()) {
                client.add(query.getInt(1) + "");
                client.add(query.getString(2));
                client.add(query.getInt(3) + "");
                client.add(query.getString(4));
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return client;
    }
    public int add_client(int id, String name, int phone, String email) {
        int result = 0;
        try {
            PreparedStatement statement = get_connection().prepareStatement("INSERT INTO clients (id, name, phone, email) VALUES (?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, phone);
            statement.setString(4, email);
            if (statement.executeUpdate() != 1) {
                result = 2;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            result = 1;
        }
        connection.close();
        return result;
    }
    public DefaultTableModel obtain_model_for_clients(String query_string, boolean recorted) {
        int number_of_registers = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery(query_string.replace("*", "COUNT(*)"));
            if (query.next()) {
                number_of_registers = query.getInt(1);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        int counter = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery(query_string);
            int number_of_columns = 2;
            if (recorted == false) {
                number_of_columns = 4;
            }
            String columns[] = new String[number_of_columns];
            columns[0] = "Identification";
            columns[1] = "Name";
            if (recorted == false) {
                columns[2] = "Phone";
                columns[3] = "Email";
            }
            String data[][] = new String[number_of_registers][number_of_columns];
            while (query.next()) {
                data[counter][0] = query.getInt(1) + "";
                data[counter][1] = query.getString(2);
                if (number_of_columns == 4) {
                    data[counter][2] = query.getInt(3) + "";
                    data[counter][3] = query.getString(4);
                }
                counter++;
            }
            connection.close();
            return new DefaultTableModel(data, columns);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return new DefaultTableModel();
    }
    public String obtain_email_from_id(int id) {
        String email = "";
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM clients WHERE id = " + id + ";");
            if (query.next()) {
                email = query.getString(4);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return email;
    }
    public int add_promotion(String name, int discount) {
        int result = 0;
        try {
            PreparedStatement statement = get_connection().prepareStatement("INSERT INTO promotions (name, discount) VALUES (?,?);");
            statement.setString(1, name);
            statement.setInt(2, discount);
            if (statement.executeUpdate() != 1) {
                result = 2;
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            result = 1;
        }
        connection.close();
        return result;
    }
    public DefaultTableModel obtain_model_for_promotions() {
        int number_of_registers = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT COUNT(*) FROM promotions;");
            if (query.next()) {
                number_of_registers = query.getInt(1);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        int counter = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM promotions;");
            String columns[] = {"Name", "Discount"};
            String data[][] = new String[number_of_registers][3];
            while (query.next()) {
                data[counter][0] = query.getString(2);
                data[counter][1] = query.getInt(3) + "";
                counter++;
            }
            connection.close();
            return new DefaultTableModel(data, columns);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return new DefaultTableModel();
    }
    public String obtain_promotion_name(int code) {
        String promotion = "";
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM promotions WHERE code = " + code + ";");
            if (query.next()) {
                promotion = query.getString(2);
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return promotion;
    }
    public String[] show_promotions() {
        ArrayList<String> promotions = new ArrayList();
        try {
            Statement statement  = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM promotions;");
            while (query.next()) {
                promotions.add(query.getString("name"));
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return Arrays.copyOf(promotions.toArray(), promotions.size(), String[] .class);
    }
    public boolean are_promotions_in() {
        boolean are_in = true;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT COUNT(*) FROM promotions;");
            while (query.next()) {
                if (query.getInt(1) == 0) {
                    are_in = false;
                }
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return are_in;
    }
    public int obtain_promotion_code(String promotion) {
        int result = 0;
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM promotions WHERE name = '" + promotion + "';");
            if (query.next()) {
                result = query.getInt(1);
            }
        }
        catch (SQLException e) {
            result = -1;
            System.err.println(e);
        }
        connection.close();
        return result;
    }
    public ArrayList<String> obtain_promotion(int code) {
        ArrayList<String> service = new ArrayList();
        try {
            Statement statement = get_connection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM promotions WHERE code = " + code + ";");
            if (query.next()) {
                service.add(query.getInt(1) + "");
                service.add(query.getString(2));
                service.add(query.getInt(3) + "");
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        connection.close();
        return service;
    }
}