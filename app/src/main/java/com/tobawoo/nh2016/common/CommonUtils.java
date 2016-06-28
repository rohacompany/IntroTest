package com.tobawoo.nh2016.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.EditText;

import com.google.gson.Gson;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.UserInfo;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by tommy on 2015-01-19.
 */
public class CommonUtils {
    public static final String _TAG = "KTH";

    public static final int ID_VIEW_DETAIL = 1;
    public static final int ID_VIEW_MODIFY = 2;
    public static final int ID_VIEW_SEARCH_GAECHE = 3;
    public static final int ID_VIEW_DELETE = 4;

    public static final String _NOTICE_VERSION_KEY = "notice_key";

    static UserInfo userInfo;

    public static String getImageNameToUri(Context mContext,Uri data) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(mContext, data, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public static boolean isNull(String obj){
        if(obj == null || obj.equalsIgnoreCase("")){
            return true;
        }
        return false;
    }
    public static boolean isOnlyNull(String str){
        if(str == null){
            return true;
        }
        return false;
    }
    public static String fixNull(String str){
        if(isOnlyNull(str) || str.trim().equalsIgnoreCase("전체"))
            return "";
        return str;
    }
    public static String fixNull(String str , String repStr){
        if(isOnlyNull(str))
            return repStr;
        return str;
    }
    public static String formatMoney(String val){
        if(isNull(val))
            return "";
        if(!isNumeric(val)){
            return val;
        }
        return formatMoney(Integer.parseInt(val)) + "만원";
    }
	public static String formatMoney(String val , String won){
		if(isNull(val))
			return "";
		if(!isNumeric(val)){
			return val;
		}
		return formatMoney(Integer.parseInt(val)) + won;
	}
    public static String formatMoney(int val){
        return String.format("%,d", val);
    }
    // 숫자인지 체크
    public static boolean isNumeric(String str) {

        Pattern pattern = Pattern.compile("[+-]?\\d+");
        return pattern.matcher(str).matches();
    }

    public static int getImageOrientation(String imagePath){
        int rotate = 0;
        try {

            File imageFile = new File(imagePath);
            ExifInterface exif = new ExifInterface(
                    imageFile.getAbsolutePath());
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rotate;
    }
    public static HashMap<String,Integer> getCurrentDataInfo(){
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        Calendar calendar = Calendar.getInstance();
        map.put("year",calendar.get(Calendar.YEAR));
        map.put("month",calendar.get(Calendar.MONTH) + 1);
        map.put("day",calendar.get(Calendar.DAY_OF_MONTH));
        map.put("hour",calendar.get(Calendar.HOUR));
        map.put("min",calendar.get(Calendar.MINUTE) + 1);
        return map;
    }

    /**
     * 주어진 리스트내용을 널값 빼고 ","로 바꾸기
     * @param msgs
     * @return
     */
    public static String join(List<String> msgs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<msgs.size();i++){
            String s = msgs.get(i);
            if(!isNull(s)){
                sb.append(s);
                if(i < msgs.size()-1){
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
    /**
     * 주어진 리스트내용을 널값 빼고 ","로 바꾸기
     * @param msgs
     * @return
     */
    public static String join(String[] msgs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<msgs.length;i++){
            String s = msgs[i];
            if(!isNull(s)){
                sb.append(s);
                if(i < msgs.length-1){
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static String getUserPhoneNumber(Context context){
        String phonenumber = null;
        TelephonyManager telManager = (TelephonyManager)context.getApplicationContext().getSystemService(context.TELEPHONY_SERVICE);

        String phoneNum = telManager.getLine1Number();

        if(phoneNum!=null) {
            if (!phoneNum.substring(0, 3).equals("010")) {

                phonenumber = ("0" + phoneNum.substring(3, 5) + phoneNum.substring(5, 9) + phoneNum.substring(9));

            } else {

                phonenumber = (phoneNum.substring(0, 3) + phoneNum.substring(3, 7) + phoneNum.substring(7));

            }
        }
        return phonenumber;
    }

    // 값 불러오기
    public static String getPreferences(Context context,String key){
        SharedPreferences pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        return pref.getString(key, "");
    }

    // 값 저장하기
    public static void savePreferences(Context context,String key,String value){
        SharedPreferences pref = context.getSharedPreferences("pref",  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value );
        editor.commit();
    }

    // 값(Key Data) 삭제하기
    public static void removePreferences(Context context,String key){
        SharedPreferences pref = context.getSharedPreferences("pref",  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }

    // 값(ALL Data) 삭제하기
    public static void removeAllPreferences(Context context){
        SharedPreferences pref = context.getSharedPreferences("pref",  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    public static AlertDialog showAlertDialog(Context context,String titie,String msg , DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(titie);
        builder.setMessage(msg);
        builder.setPositiveButton("확인", listener);
        return builder.create();
    }

    public static UserInfo getUserInfoFormPreference(Context context){

        String userInfoValue = getPreferences(context,"member");
        Gson gson = new Gson();
        userInfo = gson.fromJson(userInfoValue,UserInfo.class);
        return userInfo;
    }

    /**
     * 이메일 체크
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email==null) return false;
        boolean b = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", email.trim());
        return b;
    }

    public static AlertDialog getSimpleDialog(Context context,String content,DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("알림창");
        builder.setMessage(content);
        builder.setPositiveButton("확인", listener);
        return builder.create();
    }

    public static final int SEC = 60;
    public static final int MIN = 60;
    public static final int HOUR = 24;
    public static final int DAY = 30;
    public static final int MONTH = 12;

	public static String calculateTime(String sDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String resultDate = null;
		try {
			Date date = sdf.parse(sDate);
			resultDate = calculateTime(date);
		} catch (Exception e) {
			Logger.log("error->" + e.getMessage());
			e.printStackTrace();
		}
		return resultDate;
	}

    public static String calculateTime(Date date)
    {

        long curTime = System.currentTimeMillis();
        long regTime = date.getTime();
        long diffTime = (curTime - regTime) / 1000;

        String msg = null;

        if (diffTime < SEC)
        {
            // sec
            msg = diffTime + "초전";
        }
        else if ((diffTime /= SEC) < MIN)
        {
            // min
            System.out.println(diffTime);

            msg = diffTime + "분전";
        }
        else if ((diffTime /= MIN) < HOUR)
        {
            // hour
            msg = (diffTime ) + "시간전";
        }
        else if ((diffTime /= HOUR) < DAY)
        {
            // day
            msg = (diffTime ) + "일전";
        }
        else if ((diffTime /= DAY) < MONTH)
        {
            // day
			msg = (diffTime ) + "달전";
        }
        else
        {
            msg = (diffTime) + "년전";
        }

        return msg;
    }


	public static ProgressDialog pd;
	public static ProgressDialog getProgressDialog(Context context){
        pd = new ProgressDialog(context);
        pd.setMessage("로딩중입니다...");
        return pd;
    }

	public static void dismissProgressDialog(){
		if(pd!=null)
			pd.dismiss();
	}

	public static void hideKeyboard(Activity activity) {
		InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

	}

	public static boolean isValidateURL(String url){
		if(isNull(url)){
			return false;
		}

		return URLUtil.isValidUrl(url);
	}

	public static String getMyPhoneNumber(Context context){
		TelephonyManager tMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String mPhoneNumber = tMgr.getLine1Number();
        if(CommonUtils.isNull(mPhoneNumber)){
            return "000-0000-0000";
        }
        if(mPhoneNumber.startsWith("82")){
            mPhoneNumber = "0"+mPhoneNumber.substring(2,mPhoneNumber.length());
        }else if(mPhoneNumber.startsWith("+82")){
            mPhoneNumber = "0"+mPhoneNumber.substring(3,mPhoneNumber.length());
        }
		return mPhoneNumber;
	}

	public static String getFormmattedDate(String time){
		String resultDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(time);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH시 mm분");
			resultDate = sdf2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	public static String getFormmattedDate(String time , String format){
		String resultDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(time);
			SimpleDateFormat sdf2 = new SimpleDateFormat(format);
			resultDate = sdf2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	public static void closeKeyBoard(Context context , EditText et){
		InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
	}

    public static int[] getDeviceInfo(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        return new int[]{width , height};
    }

    public static void printMap(Map<String,String> paramMap){
        Logger.log("printMap start");
        for(Map.Entry<String,String> entry : paramMap.entrySet()){
            Logger.log("printMap : " + entry.getKey() + " : " + entry.getValue());
        }
    }

    public static int randomColor(Context context , int idx){
        int color = -1;
        switch (idx){
            case 0:
                color = context.getResources().getColor(R.color.md_blue_500);
                break;
            case 1:
                color = context.getResources().getColor(R.color.md_red_500);
                break;
            case 2:
                color = context.getResources().getColor(R.color.md_amber_500);
                break;
            case 3:
                color = context.getResources().getColor(R.color.md_green_500);
                break;
            case 4:
                color = context.getResources().getColor(R.color.md_blue_grey_500);
                break;
            case 5:
                color = context.getResources().getColor(R.color.md_indigo_500);
                break;
            case 6:
                color = context.getResources().getColor(R.color.md_cyan_500);
                break;
            case 7:
                color = context.getResources().getColor(R.color.md_deep_orange_200);
                break;
        }
        return color;
    }

    public static ProgressDialog getBarProgressDialog(Context context){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage("업데이트중입니다...\n잠시만 기다려주세요");
        dialog.setIndeterminate(false);
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(true);
        return dialog;
    }

    public static int getCurrentAppVersionCode(Context context){
        int versionCode = 0;
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            versionCode = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versionCode;
    }

}
