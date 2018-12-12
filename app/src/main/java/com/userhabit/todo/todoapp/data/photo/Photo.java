package com.userhabit.todo.todoapp.data.photo;

public class Photo {

    String id;
    String owner;
    String secret;
    String server;
    String title;

    int farm;
    int ispublic;
    int isfriend;
    int isfamily;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public String getPhotoUrl() {
        return "https://farm"+getFarm()+".staticflickr.com/"+getServer()+"/"+getId()+"_"+getSecret()+".jpg";
    }
}
