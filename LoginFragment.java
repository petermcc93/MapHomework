package edu.lclark.maphomework;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Peter on 4/5/2016.
 */
public class LoginFragment extends Fragment {

    @Bind(R.id.fragment_login_add_user_button)
    Button mAddUserButton;

    @Bind(R.id.fragment_login_login_button)
    Button mLoginButton;

    @Bind(R.id.fragment_login_login_edittext)
    EditText mLoginEditText;

    @Bind(R.id.fragment_login_main_relative_layout)
    RelativeLayout mRelativeLayout;

    public static LoginFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_fragment, container, false);

        ButterKnife.bind(this,rootView);


        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @OnClick(R.id.fragment_login_login_button)
    public void onLoginButtonClick(){
        UserSQLiteHelper instance = UserSQLiteHelper.getInstance(this);
        if(!instance.addUser(mLoginEditText.getText().toString())) {
            //Login, change fragments
        } else{
            Snackbar snackbar = Snackbar.make(mRelativeLayout,"Username does not exist", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
    }

    @OnClick(R.id.fragment_login_add_user_button)
    public void onAddUserButtonClick() {
        UserSQLiteHelper instance = UserSQLiteHelper.getInstance(this);
        if (!instance.addUser(mLoginEditText.getText().toString())) {
            //ErrorSnackbar
            Snackbar snackbar = Snackbar.make(mRelativeLayout,"Username already exists", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } else{
            //Login, change fragments
        }


    }
}
