package com.logic.hard.projecthardlogic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;

/**
 * Created by Vincent on 5/18/2016.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextView usernameView, passwordView;
    private EditText usernameET, passwordET;
    private Button loginButton;

    public LoginFragment() {
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        usernameView = (TextView) view.findViewById(R.id.et_username);
        passwordView = (TextView) view.findViewById(R.id.et_password);
        usernameET = (EditText) view.findViewById(R.id.et_username);
        passwordET = (EditText) view.findViewById(R.id.et_password);
        loginButton = (Button) view.findViewById(R.id.btn_login);
        return view;
    }

    /*@Override
    public void onViewCreated(Bundle savedInstanceState) {
        loginButton = (Button) getActivity().findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                //getContext().startActivity();
            }
        });
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                //getContext().startActivity();
                break;
            default:
                //Something went wrong!
                break;
        }
    }
}
