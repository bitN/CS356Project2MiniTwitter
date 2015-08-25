import java.util.*;

public class MiniTwitterFeed extends Observable implements SocialFeed, Visitable {
    String ownerUID;
    ArrayList<String> posts = new ArrayList();
    ArrayList<MiniTwitterUser> followers = new ArrayList<MiniTwitterUser>();
    
    MiniTwitterFeed(String uID){
        ownerUID = uID;
    }
    
    public void addFollower(MiniTwitterUser newFollower){
        followers.add(newFollower);
    }
    public void updateFollowers(){
        //foreach in followers
                //followers.get .update()
    }
}
