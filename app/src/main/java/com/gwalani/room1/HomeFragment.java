package com.gwalani.room1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private Button addButton, viewButton,delButton,updateButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        addButton = view.findViewById(R.id.add_user);
        addButton.setOnClickListener(this);

        viewButton = view.findViewById(R.id.view_users);
        viewButton.setOnClickListener(this);

        delButton = view.findViewById(R.id.delete_user);
        delButton.setOnClickListener(this);

        updateButton = view.findViewById(R.id.update_user);
        updateButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new AddUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_layout, new UpdateUserFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
