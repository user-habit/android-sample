package com.userhabit.todo.todoapp.data.photo;

import com.userhabit.todo.todoapp.data.photo.Comments;
import com.userhabit.todo.todoapp.data.photo.Dates;
import com.userhabit.todo.todoapp.data.photo.Description;
import com.userhabit.todo.todoapp.data.photo.Notes;
import com.userhabit.todo.todoapp.data.photo.Owner;
import com.userhabit.todo.todoapp.data.photo.People;
import com.userhabit.todo.todoapp.data.photo.Tags;
import com.userhabit.todo.todoapp.data.photo.Title;
import com.userhabit.todo.todoapp.data.photo.Urls;
import com.userhabit.todo.todoapp.data.photo.Usage;
import com.userhabit.todo.todoapp.data.photo.Visibility;

public class PhotoDetail {

    String id;
    String secret;
    String server;
    String farm;
    String dateuploaded;
    String isfavorite;
    String safety_level;
    String rotation;
    Owner owner;
    Title title;
    Description description;
    Visibility visibility;
    Dates dates;
    Usage usage;
    Comments comments;
    Notes notes;
    People people;
    Urls urls;
    Tags tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getDateuploaded() {
        return dateuploaded;
    }

    public void setDateuploaded(String dateuploaded) {
        this.dateuploaded = dateuploaded;
    }

    public String getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(String isfavorite) {
        this.isfavorite = isfavorite;
    }

    public String getSafety_level() {
        return safety_level;
    }

    public void setSafety_level(String safety_level) {
        this.safety_level = safety_level;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getPhotoUrl() {
        return "https://farm" + getFarm() + ".staticflickr.com/" + getServer() + "/" + getId() + "_" + getSecret() + ".jpg";
    }

    public String getThumbnailUrl() {
        return "http://farm" + owner.iconfarm + ".staticflickr.com/" + owner.iconserver + "/buddyicons/" + owner.nsid + ".jpg";
    }
}






