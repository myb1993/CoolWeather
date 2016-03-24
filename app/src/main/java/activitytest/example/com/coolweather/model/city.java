package activitytest.example.com.coolweather.model;

/**
 * Created by myb19930730 on 2016/3/24.
 */
public class city {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id =id;
    }

    public String getcityName(){

        return cityName;
    }

    public void setcityName(String cityName){
        this.cityName = cityName;}

    public  String getcityCode(){
        return cityCode;
    }

    public void setcityCode(String cityCode){
        this.cityCode = cityCode;
    }

    public int getProvinceId(){
        return provinceId;
    }

    public void setProvinceId(int provinceId){
        this.provinceId = provinceId;
    }

}
