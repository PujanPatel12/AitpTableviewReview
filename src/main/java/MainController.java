import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class MainController {
    public TableColumn<Person,Integer> personIDcol;
    public TableColumn<Person,String> personNameCol;
    public TableColumn<Person,String> personEmailCol;
    public TableView<Person> persontb;



    public void initialize() throws SQLException{


        BasicDataSource bs = new BasicDataSource();
        bs.setUsername("postgres");
        bs.setPassword("postgres");
        bs.setUrl("jdbc:postgresql://localhost:5432/aitp");



        personIDcol.setCellValueFactory(new PropertyValueFactory<Person,Integer>("personid"));
        personNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("personname"));
        personEmailCol.setCellValueFactory(new PropertyValueFactory<Person,String>("personemail"));


        QueryRunner queryRunner = new QueryRunner(bs);
        ResultSetHandler<List<Person>> P = new BeanListHandler<Person>(Person.class);


        String sql = "Select * from person";

        List<Person> people = queryRunner.query(sql,P);

        persontb.setItems(FXCollections.observableArrayList(people));



    }
}
