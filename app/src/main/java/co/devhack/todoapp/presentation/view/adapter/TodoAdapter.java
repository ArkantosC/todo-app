package co.devhack.todoapp.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.devhack.todoapp.R;
import co.devhack.todoapp.domain.model.Todo;

/**
 * Created by diegocortes on 12/8/17.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private List<Todo> dataSet;

    public TodoAdapter(List<Todo> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {

        Todo todo = dataSet.get(position);

        holder.cbFinshed.setChecked(todo.isFinished());
        holder.cbFinshed.setText(todo.getDescription());
        // TODO holder.ivPhoto
        // TODO FORMATEAR FECHA USANDO JAVA.TEXT.SIMPLEDATAFORMAT.
        holder.tvFinishDate.setText(todo.getFinishDate().toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        public CheckBox cbFinshed;
        public ImageView ivPhoto;
        public TextView tvFinishDate;

        public TodoViewHolder(View itemView) {
            super(itemView);

            cbFinshed = itemView.findViewById(R.id.cbFinished);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvFinishDate = itemView.findViewById(R.id.tvFinishDate);
        }
    }

}
