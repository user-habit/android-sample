package com.userhabit.todo.todoapp.data.photo;

public class Dates {

    String posted;
    String taken;
    int takengranularity;
    int takenunknown;
    String lastupdate;
    int views = 0;

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }

    public int getTakengranularity() {
        return takengranularity;
    }

    public void setTakengranularity(int takengranularity) {
        this.takengranularity = takengranularity;
    }

    public int getTakenunknown() {
        return takenunknown;
    }

    public void setTakenunknown(int takenunknown) {
        this.takenunknown = takenunknown;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
