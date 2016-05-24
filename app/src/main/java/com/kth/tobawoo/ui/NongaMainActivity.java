package com.kth.tobawoo.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import com.androidquery.AQuery;
import com.kth.tobawoo.R;
import com.kth.tobawoo.common.OnEventClickListener;
import com.kth.tobawoo.data.NonggaSearchResultData;
import com.kth.tobawoo.ui.animations.AnimatorPath;
import com.kth.tobawoo.ui.animations.PathEvaluator;
import com.kth.tobawoo.ui.animations.PathPoint;
import com.kth.tobawoo.ui.fragment.NongaMainFrag;
import com.kth.tobawoo.utils.Logger;

public class NongaMainActivity extends SubBaseActivity implements OnEventClickListener{


    public View mFab;
    public final static float SCALE_FACTOR      = 30f;
    public final static int ANIMATION_DURATION  = 300;
    public final static int MINIMUN_X_DISTANCE  = 200;

    private float mFabSize;

    private boolean mRevealFlag;

    NongaMainFrag nongaMainFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonga_main);

        mFabSize = getResources().getDimensionPixelSize(R.dimen.fab_size);

        aq = new AQuery(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NongaMainActivity.this, PopupActivity.class);
                intent.putExtra("flag", PopupActivity._FRAGMENT_WRITE_NONGGA);
                startActivity(intent);
            }
        });

        init();
    }

    public void init(){

        nongaMainFrag = new NongaMainFrag();

        addFragment( nongaMainFrag );

        mFab = aq.id(R.id.fab).getView();
        //aq.id(R.id.fab).clicked(this , "onFabPressed");



    }
    public void onFabPressed(View view) {
        final float startX = mFab.getX();

        AnimatorPath path = new AnimatorPath();
        path.moveTo(0, 0);
        path.curveTo(-200, 500, -400, 600, -600, 600);

        final ObjectAnimator anim = ObjectAnimator.ofObject(this, "fabLoc",
                new PathEvaluator(), path.getPoints().toArray());

        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(ANIMATION_DURATION);
        anim.start();

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (Math.abs(startX - mFab.getX()) > MINIMUN_X_DISTANCE) {
                    if (!mRevealFlag) {
                        //mFabContainer.setY(mFabContainer.getY() + mFabSize / 2);

                        mFab.animate()
                                .scaleXBy(SCALE_FACTOR)
                                .scaleYBy(SCALE_FACTOR)
                                .setListener(mEndRevealListener)
                                .setDuration(ANIMATION_DURATION);

                        mRevealFlag = true;
                    }
                }
            }
        });
    }

    private AnimatorListenerAdapter mEndRevealListener = new AnimatorListenerAdapter() {

        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);

            mFab.setVisibility(View.INVISIBLE);

           // aq.find(R.id.ll_nonga_edittext_container).visibility(View.VISIBLE);

            //mFabContainer.setBackgroundColor(getResources()
                   // .getColor(R.color.GreenYellow));

//            LinearLayout mControlsContainer = (LinearLayout) aq.id(R.id.content_nonga_main_container).getView();
//
//            for (int i = 0; i < mControlsContainer.getChildCount(); i++) {
//                View v = mControlsContainer.getChildAt(i);
//                ViewPropertyAnimator animator = v.animate()
//                        .scaleX(1).scaleY(1)
//                        .setDuration(ANIMATION_DURATION);
//
//                animator.setStartDelay(i * 50);
//                animator.start();
//            }
        }
    };

    /**
     * We need this setter to translate between the information the animator
     * produces (a new "PathPoint" describing the current animated location)
     * and the information that the button requires (an xy location). The
     * setter will be called by the ObjectAnimator given the 'fabLoc'
     * property string.
     */
    public void setFabLoc(PathPoint newLoc) {
        mFab.setTranslationX(newLoc.mX);

        if (mRevealFlag)
            mFab.setTranslationY(newLoc.mY - (mFabSize / 2));
        else
            mFab.setTranslationY(newLoc.mY);
    }

    @Override
    public void onOptionClicked() {
        Intent intent = new Intent(this , TableMainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){

            NonggaSearchResultData resultData = myApplication.getNonggaSearchResultData();
            if(resultData!=null) {
                Logger.log(resultData.toString() + ",");

                nongaMainFrag.setNonggaData(resultData);
            }
//            String name = data.getStringExtra("name");
        }
    }


}
