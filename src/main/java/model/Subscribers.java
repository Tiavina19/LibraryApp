package model;

public class Subscribers {
    private int subscriberId;
    private String name;
    private String address;

    public Subscribers(int subscriberId, String name, String address) {
        this.subscriberId = subscriberId;
        this.name = name;
        this.address = address;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Subscribers{" +
                "subscriberId=" + subscriberId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
