package co.devhack.todoapp.presentation.view.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import co.devhack.todoapp.R;
import co.devhack.todoapp.presentation.presenter.AddTodoContract;
import co.devhack.todoapp.presentation.presenter.AddTodoPresenter;
import co.devhack.todoapp.presentation.view.activity.AuthActivity;

/**
 * Created by diegocortes on 12/8/17.
 */
public class AddTodoFragment extends Fragment implements AddTodoContract.View {

    private AddTodoContract.UserActionListener mActionListener;
    private TextInputLayout tilNewTask;
    private TextView tvDateSelected;
    private TextView tvAddPhoto;
    private ImageButton btnSelectDate;
    private ImageView ivNewImage;
    private Button btnSave;

    public AddTodoFragment() {
    }

    public static AddTodoFragment getInstance() {return new AddTodoFragment();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_todo, container, false);

        mActionListener = new AddTodoPresenter(this);

        tilNewTask = view.findViewById(R.id.tilNewTask);
        tvDateSelected = view.findViewById(R.id.tvDateSelected);
        tvAddPhoto = view.findViewById(R.id.tvAddPhoto);
        btnSelectDate = view.findViewById(R.id.btnSelectDate);
        ivNewImage = view.findViewById(R.id.ivNewImage);
        btnSave = view.findViewById(R.id.btnSave);

        return view;
    }

    @Override
    public void save() {

        String description = tilNewTask.getEditText().getText().toString();
        String finishDate = tvDateSelected.getText().toString();


        //mActionListener.addTodo();

    }

    @Override
    public void goToViewTodoItem() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void showErrorMessage(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
