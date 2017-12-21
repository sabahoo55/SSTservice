package sahatara.com.sstservice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sahatara.com.sstservice.MainActivity;
import sahatara.com.sstservice.R;

/**
 * Created by pracha on 21/12/2560.
 */

public class detail_fragment extends Fragment{
    private String idString,nameString,catString,imageString,priceString,detailString;


    public static detail_fragment detailInstanc(String idString,
                                                String nameString,
                                                String catstring,
                                                String imageString,
                                                String priceString,
                                                String detailString) {
       detail_fragment detailFragment = new  detail_fragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",idString);
        bundle.putString("Name",nameString);
        bundle.putString("Category",catstring);
        bundle.putString("Image",imageString);
        bundle.putString("Price",priceString);
        bundle.putString("Detail",detailString);
        detailFragment.setArguments(bundle);
        return detailFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Argument

        getArgument();


//show viwe
        showViwe();


        // Create Toolbar

        Toolbar toolbar = getToolbar();

toolbar.setNavigationOnClickListener(new View.OnClickListener() {
    @Override




    public void onClick(View view) {
        getActivity().getSupportFragmentManager().popBackStack();
    }
});




    }//Main Method

    private Toolbar getToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarDetailfragment);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle(nameString);
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return toolbar;
    }

    private void showViwe() {
        TextView catTextview = getView().findViewById(R.id.txtCategory);
        catTextview.setText(catString);
        ImageView imageView = getView().findViewById(R.id.imvImageFood);
        Picasso.with(getActivity()).load(imageString).into(imageView);

        TextView priceTextView = getView().findViewById(R.id.txtPrice);
        priceTextView.setText(priceString+" THB.");

        TextView detailTextView = getView().findViewById(R.id.txtDetail);
       detailTextView.setText(detailString);


    }

    private void getArgument() {
        idString= getArguments().getString("id");
        nameString= getArguments().getString("Name");
        catString= getArguments().getString("Category");
        imageString= getArguments().getString("Image");
        priceString= getArguments().getString("Price");
        detailString= getArguments().getString("Detail");
    }

    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_detail,container,false);

               return  view;
    }
}//Main Class
