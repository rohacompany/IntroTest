package com.tobawoo.nh2016.common;

/**
 * Created by tommy on 2016-05-26.
 */
public class URLManager {
    public static final String _HOST = "http://nh2016.cafe24.com";

    public static final String _MAIN_HOST = _HOST + "/mobile/";

    public static final String _LOGIN_PRO = _MAIN_HOST + "loginPro.php";
    public static final String _UPDATE_PROFILE_IMAGE = _MAIN_HOST + "updateProfile.php"; //프로필 이미지만 업데이트

    public static final String _GET_NOTICE_LIST = _MAIN_HOST + "getNoticeList.php";//공지사항

    public static final String _GET_SI_DO = _MAIN_HOST + "getSiDo.php";
    public static final String _GET_NONGA_LIST = _MAIN_HOST + "getNongaList.php";
    public static final String _GET_GAECHE_LIST = _MAIN_HOST + "getGaecheList.php";
    public static final String _GET_GYOBAEJEONGBO_LIST = _MAIN_HOST + "getGyobaejeongboList.php";
    public static final String _GET_BUNMANJEONGBO_LIST = _MAIN_HOST + "getBunmanjeongboList.php";
    public static final String _GET_CHOEUMPAJEONGBO_LIST = _MAIN_HOST + "getChoeumpaList.php";
    public static final String _GET_CHULHAJEONGBO_LIST = _MAIN_HOST + "getChulhajeongboList.php";

    public static final String _GET_NONGA_SUMMARY_LIST = _MAIN_HOST + "getNongaSummary.php";
    public static final String _GET_GYOBAE_SUMMARY_LIST = _MAIN_HOST + "getGyobaeSummary.php";
    public static final String _GET_BUNMAN_SUMMARY_LIST = _MAIN_HOST + "getBunmanSummary.php";
    public static final String _GET_CHULHA_SUMMARY_LIST = _MAIN_HOST + "getChulhaSummary.php";

    public static final String _GET_GASANG_GYOBAE_LIST = _MAIN_HOST + "calGasang.php";

    public static final String _GET_CHULHA_SUMMARY_CHART_TYPE1_LIST = _MAIN_HOST + "getChulhaSummaryChart1.php";
    public static final String _GET_CHULHA_SUMMARY_CHART_TYPE2_LIST = _MAIN_HOST + "getChulhaSummaryChart2.php";
    public static final String _GET_CHULHA_SUMMARY_CHART_TYPE3_LIST = _MAIN_HOST + "getChulhaSummaryChart3.php";

    public static final String _URL_APK_DONWLOAD = _HOST + "/apk/app-release.apk";
    public static final String _URL_CHECK_APP_VERSION = _MAIN_HOST + "app_version.txt";
}
