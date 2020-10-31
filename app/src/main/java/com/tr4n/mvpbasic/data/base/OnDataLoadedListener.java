package com.tr4n.mvpbasic.data.base;

public interface OnDataLoadedListener<T> {
    void onSuccess(T data);

    void onFailure(Exception exception);
}
