package com.logic.hard.projecthardlogic.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.logic.hard.projecthardlogic.R;
import com.logic.hard.projecthardlogic.activity.ReportListActivity;

/**
 * Created by Vincent on 5/18/2016.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private static String FILENAME = "Credentials";
    private ImageView iv_logo;
    private TextView usernameView, passwordView;
    private EditText usernameET, passwordET;
    private Button loginButton;
    private CheckBox ch_remember;


    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";

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
        iv_logo = (ImageView) view.findViewById(R.id.iv_logo);
        usernameView = (TextView) view.findViewById(R.id.et_username);
        passwordView = (TextView) view.findViewById(R.id.et_password);
        usernameET = (EditText) view.findViewById(R.id.et_username);
        passwordET = (EditText) view.findViewById(R.id.et_password);
        loginButton = (Button) view.findViewById(R.id.btn_login);
        loginButton.setOnClickListener(this);
        ch_remember = (CheckBox) view.findViewById(R.id.cb_remember);


        get();



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
                Log.v("BtnClick", "Login Button Clicked");
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

//                //TODO new URLconnection
//                new UrlConnection(getContext()).execute(username, password);



                if(ch_remember.isChecked()){
                    save(username, password);
                }
                Intent intent = new Intent(getActivity(), ReportListActivity.class);
                intent.putExtra(PREF_USERNAME, username);
                startActivity(intent);
                break;
            default:
                //Something went wrong!
                break;
        }
    }

    private void save(String uName, String uPassword){
        getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                .putString(PREF_USERNAME, uName)
                .putString(PREF_PASSWORD, uPassword).commit();
    }
    private void get(){
        SharedPreferences s = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String userName = s.getString(PREF_USERNAME, null);
        usernameET.setText(userName);
        String userPw = s.getString(PREF_PASSWORD, null);
        passwordET.setText(userPw);

        if(userName == null || userPw == null){
            Toast.makeText(getContext(), "geen opgeslagen gebruiker", Toast.LENGTH_SHORT).show();

        }
    }





}
