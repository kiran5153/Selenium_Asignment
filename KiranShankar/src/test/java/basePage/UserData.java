package basePage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserData {

    private static List<Map<String, String>> userDetails = new LinkedList<>();

    public List<Map<String, String>> getUserDetails(){
        return userDetails;
    }

    public void setUserDetails(List<Map<String, String>> userData) {
         this.userDetails  = userData;
     }

    public void addUserDetails(Map<String, String> userData) {
        this.userDetails.add(userData);
    }

    public void clearDetails() {
        this.userDetails.clear();
    }

}
