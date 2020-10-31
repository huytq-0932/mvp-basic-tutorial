package com.tr4n.mvpbasic.data.repository;

import com.tr4n.mvpbasic.data.base.OnDataLoadedListener;
import com.tr4n.mvpbasic.data.model.Task;

import java.util.List;

/**
 * Interface để giap tiếp với tầng logic, Tầng logic sẽ giao tiếp với tầng data thông qua repository
 */
public interface TaskRepository {
    void getTasks(OnDataLoadedListener<List<Task>> callback);

    void getTaskById(String id, OnDataLoadedListener<Task> callback);
}
