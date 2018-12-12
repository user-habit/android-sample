package com.userhabit.todo.todoapp.data.photo;

public class Tag {
    String id;
    String author;
    String authorname;
    String raw;
    String _content;
    String machine_tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public String getMachine_tag() {
        return machine_tag;
    }

    public void setMachine_tag(String machine_tag) {
        this.machine_tag = machine_tag;
    }
}
