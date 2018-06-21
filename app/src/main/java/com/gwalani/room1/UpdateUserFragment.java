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
public class UpdateUserFragment extends Fragment {


    private EditText userId, userName, userEmail;
    private Button updateButton;

    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);
        userId = view.findViewById(R.id.user_id_update);
        userName = view.findViewById(R.id.user_name_update);
        userEmail = view.findViewById(R.id.user_email_update);
        updateButton = view.findViewById(R.id.btn_update);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int mUserId = Integer.parseInt(userId.getText().toString());
                String mUserName = userName.getText().toString();
                String mUserEmail = userEmail.getText().toString();

                User user = new User();
                user.setId(mUserId);
                user.setName(mUserName);
                user.setEmail(mUserEmail);

                upateUserbyId(user);
            }
        });

        return view;
    }

    @SuppressLint("StaticFieldLeak")
    public void upateUserbyId(User user){
        new AsyncTask<User,Void,Void>(){
            @Override
            protected Void doInBackground(User... users) {
                MainActivity.myAppDatabase.myDao().updateUser(users[0]);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(getActivity(), "User updated successfully", Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");

            }
        }.execute(user);
    }

}
