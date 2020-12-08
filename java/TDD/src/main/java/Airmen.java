import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Airmen {
    Integer id = new Integer(0);
    int leave = 30;
    List<Integer> leaveRequests = new ArrayList<Integer>();
    Airmen(Integer id) {
        this.id = id;
    }

    public void takeLeave() {
        if (leave != 0){
            this.leave -= 1;
        }
    }

    public int checkLeave(Date d) {
        return leave;
    }

    public void requestLeave() {
        if (leave == 0) {
            System.out.print("You have zero days of leave left!");
        } else {
            System.out.print("Leave request submitted to admins");
            leaveRequests.add(new Integer(leaveRequests.size()));
        }
    }

    public void openRequests() {
        System.out.print(leaveRequests);
    }

    public Integer getId() {
        return id;
    }

}
