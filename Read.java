import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {

    static final String URL = "jdbc:mysql://localhost:3306/movie";
    static final String USER = "root";
    static final String PASS = "Akhilesh@034";

    public static void main(String[] args) {

        readMovies();
    }

    static void readMovies() {

        String sql = "SELECT * FROM movies";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                System.out.println("----- Movie List -----");

                while (rs.next()) {

                   
                    String movieName = rs.getString("moviename");
                    String genre = rs.getString("genre");
                    float rating = rs.getFloat("rating");
                    String status = rs.getString("status");

                    System.out.println(
                            
                            movieName + " | " +
                            genre + " | " +
                            rating + " | " +
                            status
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
