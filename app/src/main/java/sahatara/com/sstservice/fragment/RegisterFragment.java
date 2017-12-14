package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sahatara.com.sstservice.MainActivity;
import sahatara.com.sstservice.R;

/**
 * Created by Aum on 14/12/2560.
 */

public class RegisterFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        createToolbar();

    }   //  Main Method

 //   Create Toolbar
    private void createToolbar() {

 //       Setup Toolbar nd title
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
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
