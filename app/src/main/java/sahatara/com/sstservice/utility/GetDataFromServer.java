package sahatara.com.sstservice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Aum on 20/12/2560.
 */

public class GetDataFromServer extends AsyncTask<String, Void, String>{   //3

    private Context context; //1

    public GetDataFromServer(Context context) {
        this.context = context;
    }//2

    @Override
    protected String doInBackground(String... strings) {

        try {       //5

            OkHttpClient okHttpClient = new OkHttpClient(); //  8
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();    //11

            return response.body().string();

        } catch (Exception e) { //6
            e.printStackTrace();    // 7
            return null;                // 12
        }



    }   //4
}//Main Class
