package com.tr4n.mvpbasic.data.repository;

import com.tr4n.mvpbasic.data.base.OnDataLoadedListener;
import com.tr4n.mvpbasic.data.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public void getTasks(OnDataLoadedListener<List<Task>> callback) {
        // Thực hiện 1 công việc nặng nào đó mất 1 khoảng thời gian đáng kể
        // Vì không biết xong lúc nào nên cần có 1 listener để lắng nghe khi nào thực hiện xong
        // Giả sử ta dùng Handler để delay 1 công việc nào đó trong khoảng thời gian 2s
        // Do something after 2s = 2000ms
        // Khi xong việc kết quả trả về 1 list task
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("1", "1"));
        tasks.add(new Task("2", "2"));

        // Kiểm tra thực hiện nếu thành công thì gọi callback.onSuccess còn không thì gọi callback.onFail
        if (tasks == null) {
            callback.onFailure(new Exception("Unexpected Error"));
        } else {
            callback.onSuccess(tasks);
        }

    }

    @Override
    public void getTaskById(String id, OnDataLoadedListener<Task> callback) {
        if (!false) { // Trong trường hợp có lỗi xảy ra
            callback.onFailure(new Exception("Task is not exist"));
        } else {
            callback.onSuccess(new Task("3", "3"));
        }
    }
}
