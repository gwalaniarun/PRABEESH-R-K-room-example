package com.gwalani.room1;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView textInfo;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        textInfo = view.findViewById(R.id.name);

        loadUsers();
        return view;
    }

    public void loadUsers() {
        new MyAsyncTask().execute();
    }


    public class MyAsyncTask extends AsyncTask<String, Void, List<User>> {

        @Override
        protected List<User> doInBackground(String... strings) {
            return MainActivity.myAppDatabase.myDao().getUsers();
        }

        @Override
        protected void onPostExecute(List<User> user) {
            String info = "";

            for (User usr : user) {

                int id = usr.getId();
                String name = usr.getName();
                String email = usr.getEmail();

                info = info + "\n\n" + "ID: " + id + "\nName: " + name + "\nEmail: " + email;
            }

            textInfo.setText(info);
        }
    }

}
