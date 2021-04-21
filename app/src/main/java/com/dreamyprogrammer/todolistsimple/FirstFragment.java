package com.dreamyprogrammer.todolistsimple;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dreamyprogrammer.todolistsimple.adapters.AdapterTask;
import com.dreamyprogrammer.todolistsimple.elements.TaskElement;
import com.dreamyprogrammer.todolistsimple.utilities.FileUtility;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> list;
    private final static String FILENAME = "sample.txt"; // имя файла

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        FloatingActionButton myFab = getActivity().findViewById(R.id.fab);

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdapterTask adapter = new AdapterTask(readData(list,"Задача №2"));
                recyclerView.setAdapter(adapter);
            }
        });

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        findView(view);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        AdapterTask adapter = new AdapterTask(readData(list,"null"));
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<TaskElement> readData(List<String> list, String intStr) {
        String[] words;
        TaskElement taskElement;
        ArrayList<TaskElement> taskElements = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            words =list.get(i).split(";");
            if (words[2].equals(intStr)) {
                taskElement = new TaskElement(words[0], Integer.parseInt(words[1]));
                taskElements.add(taskElement);
            }
        }
        return taskElements;
    }

    private void findView(View view) {
        if (FileUtility.existFile(FILENAME,getContext())) {
            list = FileUtility.readFromFile(FILENAME,getContext());
        } else {
            FileUtility.createToFile(FILENAME,getContext());
            list = FileUtility.readFromFile(FILENAME,getContext());
        }
        recyclerView = view.findViewById(R.id.recyclerView);
    }
}