package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import sahatara.com.sstservice.MainActivity;
import sahatara.com.sstservice.R;
import sahatara.com.sstservice.utility.MyAlertDialog;
import sahatara.com.sstservice.utility.MyConstant;
import sahatara.com.sstservice.utility.PostUserToServer;

/**
 * Created by Aum on 14/12/2560.
 */

public class RegisterFragment extends Fragment {

    //  Explicit
    private String nameString, userString, passwordString;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);

        createToolbar();

    }   //  Main Method

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_register, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemSave) {

            saveController();

        }   //  if

        return super.onOptionsItemSelected(item);

    }

    private void saveController() {

//        Initial EditeText View
        EditText nameEditText = getView().findViewById(R.id.edtName);
        EditText userEditText = getView().findViewById((R.id.edtUser));
        EditText passwordEditText = getView().findViewById((R.id.edtPassword));

//      Get Value From EditText
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

//        Check Space

        if (nameString.isEmpty() || userString.isEmpty() || passwordString.isEmpty()) {
//            Have Space
            MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
            myAlertDialog.normalDialog(getString(R.string.title_have_space),
                                       getString(R.string.message_have_space));

        } else {
//            No Space
            try {

                MyConstant myConstant = new MyConstant();
                String tag = "20DecV1";
                PostUserToServer postUserToServer = new PostUserToServer(getActivity());

                    postUserToServer.execute(nameString, userString, passwordString,
                        myConstant.getUrlPostUserString());
                    String resultString = postUserToServer.get();
                Log.d(tag, "Result ==>" + resultString);

                if (Boolean.parseBoolean(resultString)) {
                    getActivity().getSupportFragmentManager().popBackStack();
                    Toast.makeText(getActivity(),"Upload New User Success",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),"Upload New User Non Success",
                            Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }   //  if

    }   //  SaveController

    //   Create Toolbar
    private void createToolbar() {

        //       Setup Toolbar nd title
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.register));

        //       Setup Navigator Icon

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager()
                        .popBackStack();

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        return view;
    }

}   //  Main Class
