package com.userhabit.todo.todoapp.domain;

public class GetPicturesUseCaseParameters {

    String keyword;
    int safe;
    int page;
    int perPage;

    public GetPicturesUseCaseParameters(String keyword, int safe, int page, int perPage) {
        this.keyword = keyword;
        this.safe = safe;
        this.page = page;
        this.perPage = perPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}