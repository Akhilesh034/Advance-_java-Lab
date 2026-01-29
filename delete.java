import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie";
        String user = "root";
        String pass = "Akhilesh@034";

        String sql = "DELETE FROM movies WHERE moviename = ?";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter movie name to delete: ");
            String movieName = sc.nextLine();

            ps.setString(1, movieName);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Movie deleted successfully 🗑️");
            } else {
                System.out.println("Movie not found ");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

