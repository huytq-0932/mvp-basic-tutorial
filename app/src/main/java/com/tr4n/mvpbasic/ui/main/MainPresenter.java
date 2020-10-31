package com.tr4n.mvpbasic.ui.main;

import com.tr4n.mvpbasic.data.base.OnDataLoadedListener;
import com.tr4n.mvpbasic.data.model.Task;
import com.tr4n.mvpbasic.data.repository.TaskRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    // Presenter sẽ giữ interface View để giao tiếp khi cần View thực hiện các công việc hiển thị
    // Presenter là tầng logic nên sẽ đảm bảo trách nhiệm logic,
    // Presenter sẽ giữ reference tầng data là repository, tầng View là view
    // Không khởi tạo Repository ở tầng Presenter => Sai nguyên lý SOLID mà cần truyền từ bên ngoài vào thông qua constructor

    private MainContract.View view;
    private TaskRepository taskRepository;

    public MainPresenter(MainContract.View view, TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.view = view;
    }

    @Override
    public void getTasks() {
        // Ở đây khởi tạo listener và truyền xuống dưới tầng Model để thực hiện công việc lắng nghe
        taskRepository.getTasks(new OnDataLoadedListener<List<Task>>() {
            @Override
            public void onSuccess(List<Task> data) {
                view.showTasks(data);
            }

            @Override
            public void onFailure(Exception exception) {
                String msg = exception.getMessage();
                view.notifyMsg(msg);
            }
        });
    }

    @Override
    public void getTaskById(String id) {
        taskRepository.getTaskById(id, new OnDataLoadedListener<Task>() {
            @Override
            public void onSuccess(Task data) {
                // Xử lý logic ở đây không phải truyền hết dữ liệu có được từ tầng Model lên View
                if (data == null) {
                    view.notifyMsg("Dữ liệu không tồn tại");
                    return;
                }
                view.updateTaskContent(data);
            }

            @Override
            public void onFailure(Exception exception) {
                String msg = exception.getMessage();
                view.notifyMsg(msg);
            }
        });

    }
}
