package LLD.StackOverFlow;

public class User {
    private String UserId;
    private String name;
    private String email;
    private int reputation;

    public User(String userId, String name, String email) {
        UserId = userId;
        this.name = name;
        this.email = email;
        this.reputation=0;
    }

    public String getName() {
        return name;
    }
    public int getReputation() {
        return reputation;
    }
    public void increaseReputation(){
        this.reputation++;
    }
    public void decreaseReputation(){
        this.reputation--;
    }

}
