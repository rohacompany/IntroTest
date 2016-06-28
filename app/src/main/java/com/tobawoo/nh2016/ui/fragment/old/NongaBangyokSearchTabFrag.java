package com.tobawoo.nh2016.ui.fragment.old;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.tobawoo.nh2016.R;
import com.tobawoo.nh2016.data.NonggaType;
import com.tobawoo.nh2016.fixedtablelayout.TableFixHeaders;
import com.tobawoo.nh2016.ui.PopupActivity;
import com.tobawoo.nh2016.ui.adapter.StyledAdapter;
import com.tobawoo.nh2016.common.Logger;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;


public class NongaBangyokSearchTabFrag extends BaseV4Frag implements View.OnClickListener,StyledAdapter.OnTableItemClick{
    AQuery aq;
    private Boolean isFabOpen = false;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.view_search_box_type2, container , false);
        }

        ViewGroup parent = (ViewGroup) view.getParent();
        if(parent != null){
            parent.removeView(view);
        }

        aq = new AQuery(view);

//        aq.find(R.id.ibtn_type2_open_date_popup_start).clicked(this, "showDatePicker");
//        aq.find(R.id.ibtn_type2_open_date_popup_end).clicked(this, "showDatePicker");

        return view;
    }

    public void showDatePicker(View view){

        int targetTextView = -1;
//        switch (view.getId()){
//            case R.id.ibtn_type2_open_date_popup_start:
//                targetTextView = R.id.tv_type2_date_popup_start;//tv_type2_date_popup_start
//                break;
//            case R.id.ibtn_type2_open_date_popup_end:
//                targetTextView = R.id.tv_type2_date_popup_end;
//                break;
//        }

        targetDateTimeET = aq.id(targetTextView).getEditText();

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //setTableLayout();

//        init();

    }

    public void setTableLayout() {
        String[] mainHeaders = new String[]{
                "농가아이디",
                "지역(축협)",
                "농가코드",
                "축주명",
                "농가형태",
                "농가상태",
                "두수",
                "방역명",
                "방역자",
                "방역일시",
                "방역자수"
        };
        int[] mainWidths = {
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
        };

        NonggaType nt = new NonggaType();
        for (int i = 0; i < 100; i++) {
//            nt.list.add(new NonggaData("id" + i, "축협" + i, "code" + i, "테스트", "번식농가", "유지", "3" + i, "", "test2" + i, "test3" + i, "2015-12-08", "1" + i));
        }

        TableFixHeaders tableFixHeaders = (TableFixHeaders) getView().findViewById(R.id.table);
        StyledAdapter<String> matrixTableAdapter = new StyledAdapter<String>(getActivity(), mainHeaders, mainWidths, nt);
        tableFixHeaders.setAdapter(matrixTableAdapter);

        matrixTableAdapter.setOnTableItemClick(this);



    }
//
//    public void animateFAB(){
//
//        if(isFabOpen){
//
//            fab.startAnimation(rotate_backward);
//            fab1.startAnimation(fab_close);
//            fab2.startAnimation(fab_close);
//            fab1.setClickable(false);
//            fab2.setClickable(false);
//            isFabOpen = false;
//            Log.d("Raj", "close");
//
//        } else {
//
//            fab.startAnimation(rotate_forward);
//            fab1.startAnimation(fab_open);
//            fab2.startAnimation(fab_open);
//            fab1.setClickable(true);
//            fab2.setClickable(true);
//            isFabOpen = true;
//            Log.d("Raj","open");
//
//        }
//    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
//        switch (id){
//            case R.id.fab:
//                animateFAB();
//                break;
//            case R.id.fab1:
//
//                Log.d("Raj", "Fab 1");
//                break;
//            case R.id.fab2:
//
//                Log.d("Raj", "Fab 2");
//                break;
//        }
    }

    @Override
    public void onListItemClicked(View view, int position) {
        //테이블 아이템 클릭 이벤트 발생
//        DetailDialogFrag dialogFrag = new DetailDialogFrag();
//        dialogFrag.setStyle(DialogFragment.STYLE_NO_FRAME , R.style.CustomDialog);
//        dialogFrag.show(getFragmentManager() , "dialogFrag");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Logger.log("삭제하기");
            }
        });

        builder.setNegativeButton("수정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Logger.log("수정하기");
                Intent intent = new Intent(getActivity() , PopupActivity.class);
                intent.putExtra("flag" , PopupActivity._FRAGMENT_WRITE_NONGGA);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        builder.setMessage("해당 게시물을 수정하시겠습니까?");
        builder.show();
    }
}
