package dao;

import api.UserDao;
import entity.User;

import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class UserDaoImpl implements UserDao {

    private Connection connection;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "admin";

    private static UserDaoImpl instance = null;

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public UserDaoImpl() {
        init();
    }


    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysq://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveUser(User user) {

        PreparedStatement statement;
        try {
            String query = "insert into" + tableName + "(login, password) values (?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void removeUserById(Long userId) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + "where ID = ?";
            statement = connection.prepareStatement(query);

            statement.setLong(1, userId);

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserByLogin(String login) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + "where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, login);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long id = resultSet.getLong("ID");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");

                User user = new User(id, login, password);
                users.add(user);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(User user) {
        PreparedStatement statement;
        try {
            String query = "update " + tableName + "set login = ?, password = ? " +
                    "where ID = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setLong(3, user.getId());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

































/*public class UserDaoImpl implements UserDao {

    private static final String fileName="users.data";
    private static UserDaoImpl instance = null;

    private UserDaoImpl()
    {
        try{
            FileUtils.createNewFile(fileName);
        } catch (IOException e)
        {
            System.out.println("Error with file path");
            System.exit(-1); // <-- close app
        }
    }

    public static UserDaoImpl getInstance()
    {
        if(instance == null)
        {
           instance =  new UserDaoImpl();
        }
        return instance;
    }

    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();

    }

    public void removeUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).getId().equals(userId);
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).getLogin().equals(login);
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String readLine = bufferedReader.readLine();
        while(readLine != null)
        {
            User user = UserParser.stringToUser(readLine);
            if (user != null) users.add(user);
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        return users;
    }
}

*/
