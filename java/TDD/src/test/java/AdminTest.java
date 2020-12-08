import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    Admin admin;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void init() {
        List<Airmen> users = new ArrayList<Airmen>(){{
                                                    add(new Airmen(0));
                                                    add(new Airmen(1));
                                                    add(new Airmen(2));
                                                    }};
        admin = new Admin(users);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void allUsersDaysOff() throws ParseException {
        admin.allUsersDaysOff();
        assertEquals("UserID 0 : Leave 30\n" +
                        "UserID 1 : Leave 30\n" +
                        "UserID 2 : Leave 30\n", outContent.toString(),
                "Did not show user info!");
    }





}
