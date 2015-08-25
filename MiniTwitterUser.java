import java.util.*;

public class MiniTwitterUser implements User, Visitor {
    
    private String userID;
    
    MiniTwitterUser(String uID){
        userID = uID;
    }
    
    public String getUID(){
        return userID;
    }
    @Override
    public void update(Observable feed, Object arg){
        
    }
}
