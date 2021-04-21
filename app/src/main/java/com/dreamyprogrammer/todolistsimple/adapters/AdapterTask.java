package com.dreamyprogrammer.todolistsimple.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamyprogrammer.todolistsimple.elements.TaskElement;
import com.dreamyprogrammer.todolistsimple.R;

import java.util.ArrayList;

public class AdapterTask extends RecyclerView.Adapter<AdapterTask.ViewHolder> {

    private ArrayList<TaskElement> taskElements;
    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    public AdapterTask(ArrayList<TaskElement> taskElements) {
        this.taskElements = taskElements;
    }
    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NonNull
    @Override
    public AdapterTask.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Создаем новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_task_layout, viewGroup, false);
        // Здесь можно установить всякие параметры
        return new ViewHolder(v);
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull AdapterTask.ViewHolder viewHolder, int i) {
        // Получить элемент из источника данных (БД, интернет...)
        // Вынести на экран используя ViewHolder
        // Заполнение View вынести в отдельный метод
        viewHolder.tv_task.setText(taskElements.get(i).getName());
        if (taskElements.get(i).getTypeElement() == 1) {
            viewHolder.imageView.setVisibility(View.VISIBLE);
            viewHolder.checkBox2.setVisibility(View.GONE);
            viewHolder.imageView.setImageResource(R.drawable.folder_icon);
        } else if (taskElements.get(i).getTypeElement() == 2) {
            viewHolder.imageView.setVisibility(View.VISIBLE);
            viewHolder.checkBox2.setVisibility(View.GONE);
            viewHolder.imageView.setImageResource(R.drawable.list_icon);
        }
        else {
            viewHolder.imageView.setVisibility(View.GONE);
            viewHolder.checkBox2.setVisibility(View.VISIBLE);
        }
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return taskElements == null ? 0 : taskElements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_task;
        private ImageView imageView;
        private CheckBox checkBox2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_task = itemView.findViewById(R.id.tv_task);
            imageView = itemView.findViewById(R.id.imageView);
            checkBox2 = itemView.findViewById(R.id.checkBox2);
        }
    }
}
