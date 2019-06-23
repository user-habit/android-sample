package com.userhabit.todo.todoapp.domain;

import android.arch.lifecycle.MediatorLiveData;

abstract class MediatorUseCase<P, R> {

    protected MediatorLiveData<R> result = new MediatorLiveData<>();

    public MediatorLiveData<R> obseve() {
        return result;
    }

    public abstract void execute(P parameter);
}
