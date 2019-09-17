package com.userhabit.todo.todoapp.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.userhabit.todo.todoapp.R;

import io.userhabit.service.Userhabit;

public class MoreFragment extends Fragment {

    Button buttonAction;

    public static Fragment newInstance() {
        return new MoreFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(
                R.layout.fragment_more,
                container,
                false
        );
        buttonAction = view.findViewById(R.id.buttonAction);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "More Button Click", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 사용자 터치 수집 제외하기.
         *  뷰 영역에 대한 터리를 수집하고 싶지 않다면 아래 API 호출
         **/
        Userhabit.addSecretView(buttonAction);
    }
}
