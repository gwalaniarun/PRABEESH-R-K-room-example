package com.gwalani.room1;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userId, userName, userEmail;
    private Button saveButton;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        userId = view.findViewById(R.id.user_id);
        userName = view.findViewById(R.id.user_name);
        userEmail = view.findViewById(R.id.user_email);
        saveButton = view.findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int muserId = Integer.parseInt(userId.getText().toString());
                String muserName = userName.getText().toString();
                String muserEmail = userEmail.getText().toString();

                User user = new User();
                user.setId(muserId);
                user.setName(muserName);
                user.setEmail(muserEmail);

                addUserThroughAsyncTask(user);

            }
        });

        return view;
    }

    @SuppressLint("StaticFieldLeak")
    public void addUserThroughAsyncTask(User user) {
        new AsyncTask<User, Void, Void>() {

            @Override
            protected Void doInBackground(User... users) {
                MainActivity.myAppDatabase.myDao().addUser(users[0]);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(getActivity(), "User Added successfully", Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        }.execute(user);
    }

}
