import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AirmenTest {
    Airmen airmen;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void init() {
        airmen = new Airmen(1);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testCheckLeave() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("01/01/2020");
        assertEquals(30, airmen.checkLeave(d), "Invalid January Date for check leave");
    }

    @Test
    public void testReduceLeave() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("01/01/2020");
        airmen.takeLeave();
        assertEquals(29, airmen.checkLeave(d), "Did not lose a date of leave!");
    }

    @Test
    public void testRequestLeave() {
        airmen.requestLeave();
        assertEquals("Leave request submitted to admins", outContent.toString(),
                "Did not display message!");
    }

    @Test
    public void testRequestLeaveZero() {
        for (int i = 0; i < 35; i++) {
            airmen.takeLeave();
        }
        airmen.requestLeave();
        assertEquals("You have zero days of leave left!", outContent.toString(),
                "Did not display message!");
    }

    @Test
    public void openRequests() {
        for (int i = 0; i < 30; i++) {
            airmen.requestLeave();
        }
        System.setOut(originalOut);
        System.setErr(originalErr);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        airmen.openRequests();
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, " +
                        "18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]", outContent.toString(),
                "Did show leave!");
    }

    @Test
    public void getId() {
        assertEquals(new Integer(1), airmen.getId(), "Got wrong id!");
    }
}
