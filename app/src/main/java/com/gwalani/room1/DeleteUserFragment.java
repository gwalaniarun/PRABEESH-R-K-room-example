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
public class DeleteUserFragment extends Fragment {

    private EditText deleteId;
    private Button deleteButton;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        deleteId = view.findViewById(R.id.delete_id);
        deleteButton = view.findViewById(R.id.button_delete_by_id);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(deleteId.getText().toString());
                User user = new User();
                user.setId(id);

                deleteUSerById(user);

               // MainActivity.myAppDatabase.myDao().deleteUser(user);
                }
        });
        return view;
    }

    @SuppressLint("StaticFieldLeak")
    public void deleteUSerById(User user){
        new AsyncTask<User,Void,Void>(){
            @Override
            protected Void doInBackground(User... users) {
                MainActivity.myAppDatabase.myDao().deleteUser(users[0]);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(getActivity(), "User deleted", Toast.LENGTH_SHORT).show();

                deleteId.setText("");


            }
        }.execute(user);
    }


}
