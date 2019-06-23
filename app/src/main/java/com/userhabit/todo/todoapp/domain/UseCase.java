package com.userhabit.todo.todoapp.domain;


import android.arch.lifecycle.MutableLiveData;

public abstract class UseCase<P, R> {

    /**
     * TODO:thread pool create
     */
    public void buildUseCaseObserve(P parameter, MutableLiveData<R> result) {
        if (execute(parameter) != null) {
            result.postValue(execute(parameter));
        }
    }

    protected abstract R execute(P parameter);
}
