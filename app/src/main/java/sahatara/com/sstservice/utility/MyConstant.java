package sahatara.com.sstservice.utility;

/**
 * Created by Aum on 20/12/2560.
 */

public class MyConstant {

//    About URL
    private String urlPostUserString = "http://androidthai.in.th/sst/addDataAUM.php";
    private String urlGetUserString = "http://androidthai.in.th/sst/getAllDataAUM.php";
    private String urlGetFoodString = "http://androidthai.in.th/sst/getAllFoodAUM.php";


    //   About Array
    private String[] userColumnStrings = new String[]{
            "id", "Name", "User", "Password"};

    private String[] foodColumnStrings = new String[]{
            "id", "Category", "BarCode", "QRcode", "NameFood", "Price", "Detail", "ImagePath"};

    public String[] getFoodColumnStrings() {
        return foodColumnStrings;
    }

    public String getUrlGetFoodString() {
        return urlGetFoodString;
    }

    public String[] getUserColumnStrings() {
        return userColumnStrings;
    }//3

    public String getUrlGetUserString() {

        return urlGetUserString;
    }//2

    public String getUrlPostUserString() {

        return urlPostUserString;
    }//1
}   //  Main    Class
