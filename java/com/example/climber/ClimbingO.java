package com.example.climber;

public class ClimbingO {
    private String name;
    private String info;
    private String grade;
    private String profilePic;
    private boolean permission;

    public ClimbingO() {
    }


    public ClimbingO(String name, String info, String profilePic, boolean permission, String grade) {
        this.name = name;
        this.info = info;
        this.profilePic = profilePic;
        this.permission = permission;
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
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
