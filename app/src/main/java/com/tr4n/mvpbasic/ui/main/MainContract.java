package com.tr4n.mvpbasic.ui.main;

import com.tr4n.mvpbasic.data.model.Task;

import java.util.List;

/**
 * Chứa bản hợp đồng giữa View và Presenter(tầng logic)
 * Ở đây sẽ miêu tả các công việc của View và Presenter
 * Lưu ý: View và Presenter không nên biết rõ công việc của nhau
 * View không cần biết logic mà chỉ quan tâm các việc như: Hiển thị(show, display), Thông báo(notify), Cập nhật UI(update)
 * Còn những hành động lấy dữ liệu thành công, thất bại, ... không quan tâm
 */
public interface MainContract {

    interface View {
        void showTasks(List<Task> tasks);

        void updateTaskContent(Task task);

        void notifyMsg(String msg);
    }

    interface Presenter {
        void getTasks();

        void getTaskById(String id);
    }
}
