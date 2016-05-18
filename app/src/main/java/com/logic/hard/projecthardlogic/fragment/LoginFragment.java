package com.logic.hard.projecthardlogic.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.logic.hard.projecthardlogic.R;

/**
 * Created by Vincent on 5/18/2016.
 */
public class LoginFragment extends Fragment {
    private TextView usernameView, passwordView;
    private Button loginButton;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        usernameView = (TextView) view.findViewById(R.id.et_username);
        passwordView = (TextView) view.findViewById(R.id.et_password);
        loginButton = (Button) view.findViewById(R.id.btn_login);
        return view;
    }
}
