package com.example.assignment4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private RecyclerView rvBook;
    private ArrayList<BookModel> listBook = new ArrayList<>();

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvBook = view.findViewById(R.id.RecyclerView);
        rvBook.setHasFixedSize(true);
        listBook.addAll(BookData.getListData());

        rvBook.setLayoutManager(new LinearLayoutManager(getContext()));
        BookAdapter bookAdapter = new BookAdapter(getContext(), BookData.getListData());
        bookAdapter.setBookModels(listBook);
        rvBook.setAdapter(bookAdapter);
    }
}