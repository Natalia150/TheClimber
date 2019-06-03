package com.example.climber;

public class HikesClass {
    private String name;
    private String info;
    private String altitude;
    private String profilePic;
    private boolean permission;

    public HikesClass() {
    }


    public HikesClass(String name, String info, String profilePic, boolean permission, String altitude) {
        this.name = name;
        this.info = info;
        this.profilePic = profilePic;
        this.permission = permission;
        this.altitude = altitude;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getAltitude(){
        return altitude;
    }

    public void setAltitude(String altitude){
        this.altitude = altitude;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
