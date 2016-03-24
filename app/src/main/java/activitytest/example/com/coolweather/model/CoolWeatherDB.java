package activitytest.example.com.coolweather.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.coolweather.db.CoolWeatherOpenHelper;

/**
 * Created by myb19930730 on 2016/3/24.
 */
public class CoolWeatherDB {
    public static final String DB_NAME = "cool_weather";    //数据库名
    public static final int VERSION = 1;     //数据库版本
    private SQLiteDatabase db;
    private static CoolWeatherDB coolWeatherDB;

    private CoolWeatherDB(Context context){                   //将构造方法私有化
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance(Context context){        //获得CoolWeatherDB 的实例
        if (coolWeatherDB ==null){
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    public void saveProvince(Province province){        //将Province实例存储到数据库
        if (province != null){
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }

    public List<Province> loadProvinces(){           //从数据库读取全国所有的省份信息
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
        }return list;
    }

    public void saveCity(City city){        //将City实例存储到数据库
        if (city != null){
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            values.put("province_id",city.getProvinceId());
            db.insert("City",null,values);
        }
    }

    public List<City> loadCities(int provinceId){           //从数据库读取某省下所有城市的信息
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City",null,"province_id = ?",new String[]{String.valueOf(provinceId)},null,null,null);
        if (cursor.moveToFirst()){
            do {
               City city = new City();
               city.setId(cursor.getInt(cursor.getColumnIndex("id")));
               city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
               city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                list.add(city);
            }while (cursor.moveToNext());
        }return list;
    }

    public void saveCounty(County county){        //将County实例存储到数据库
        if (county != null){
            ContentValues values = new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCountyCode());
            values.put("city_id",county.getCityId());
            db.insert("County",null,values);
        }
    }

    public List<County> loadCounties(int cityId){           //从数据库读取某城市下所有的县信息
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County",null,"city_id = ?",new String[]{String.valueOf(cityId)},null,null,null,null);
        if (cursor.moveToFirst()){
            do {
               County county =new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                list.add(county);
            }while (cursor.moveToNext());
        }return list;
    }

}
