package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import sahatara.com.sstservice.R;
import sahatara.com.sstservice.utility.GetDataFromServer;
import sahatara.com.sstservice.utility.MyAlertDialog;
import sahatara.com.sstservice.utility.MyConstant;

/**
 * Created by Aum on 14/12/2560.
 */

public class MainFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        registerController
            registerController();

//        Login Controller

            loginController();

    }   //  Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Initial Edit Text
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passEditText = getView().findViewById(R.id.edtPassword);

                String userString = userEditText.getText().toString().trim();
                String passString = passEditText.getText().toString().trim();

                if (userString.isEmpty() || passString.isEmpty()) {
                    //Have Space
                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                    myAlertDialog.normalDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));
                } else {
//                    No Space
                    try {
                        String tag = "20DecV1";
                        MyConstant myConstant = new MyConstant();
                        MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                        GetDataFromServer getDataFromServer = new GetDataFromServer(getActivity());
                        getDataFromServer.execute(myConstant.getUrlGetUserString());

                        String JsonString = getDataFromServer.get();
                        Log.d(tag, "JSON ==>" + JsonString);

                        boolean status = true;
                        String[] columnStrings = myConstant.getUserColumnStrings();
                        String[] loginStrings = new String[columnStrings.length];


                        JSONArray jsonArray = new JSONArray(JsonString);

                        for (int i=0; i<jsonArray.length(); i+=1) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userString.equals(jsonObject.getString(columnStrings[2]))) {

                                status = false;
                                for (int i1=0; i1<columnStrings.length; i1 += 1) {
                                    loginStrings[i1] = jsonObject.getString(columnStrings[i1]);
                                } //for   i++

                            }   //  if

                        }   // for

                       //gg

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }   // if

            }
        });
    }

//      Register Controller

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

 //      Replace Fragement
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();

            }   //  onClick
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }
}   //Main Class
