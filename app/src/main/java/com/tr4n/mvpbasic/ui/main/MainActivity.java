package com.tr4n.mvpbasic.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tr4n.mvpbasic.R;
import com.tr4n.mvpbasic.data.model.Task;
import com.tr4n.mvpbasic.data.repository.TaskRepository;
import com.tr4n.mvpbasic.data.repository.TaskRepositoryImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        initData();
    }

    private void setupUI() {
        // Setup Khung của View với data rỗng
    }

    private void initData() {
        initPresenter();
        presenter.getTasks();
    }

    private void initPresenter() {
        TaskRepository repository = new TaskRepositoryImpl();
        presenter = new MainPresenter(this, repository);
    }

    @Override
    public void showTasks(List<Task> tasks) {
        Log.d("TAG", "showTasks: " + tasks);
    }

    @Override
    public void updateTaskContent(Task task) {
        Log.d("TAG", "updateTaskContent: " + task);
    }

    @Override
    public void notifyMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
