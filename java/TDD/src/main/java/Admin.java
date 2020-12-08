import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Admin {
    List<Airmen> users;
    Admin(List<Airmen> people) {
        users = people;
    }

    void allUsersDaysOff() throws ParseException {
        for (Airmen airman : users) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse("01/01/2020");
            System.out.println(String.format("UserID %d : Leave %d", airman.getId(), airman.checkLeave(d)));
        }
    }
}
