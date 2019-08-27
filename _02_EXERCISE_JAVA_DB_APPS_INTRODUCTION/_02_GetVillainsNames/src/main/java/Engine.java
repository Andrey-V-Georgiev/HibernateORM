import java.sql.*;

public class Engine implements Runnable {
    private Connection connection;

    Engine() throws SQLException {
        this.connection = Config.createConection();
    }

    @Override
    public void run() {
        String queryString = QueryStrings.villainsHavingOver15Minions();

        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(queryString);
            prepareStatement.setInt(1, 15);
            ResultSet result = prepareStatement.executeQuery();

            while (result.next()) {
                System.out.printf("%s %d\n",
                        result.getString("name"),
                        result.getInt("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
