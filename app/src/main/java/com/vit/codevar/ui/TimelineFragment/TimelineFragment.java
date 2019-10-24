package com.vit.codevar.ui.TimelineFragment;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.txusballesteros.widgets.FitChart;
import com.txusballesteros.widgets.FitChartValue;
import com.vit.codevar.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;


public class TimelineFragment extends Fragment
{
    private FitChart timelineChart;
    private Long startTime, endTime, currentTime, doneTime;
    private TextView currentRoundName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_timeline,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        timelineChart = view.findViewById(R.id.timelineChart);
        currentRoundName = view.findViewById(R.id.currentRoundName);
        timelineChart.setMinValue(0);
        timelineChart.setMaxValue(1440);
        startTime = 1575725400000L; //7 DEC 2019 7:00 PM
        endTime = 1575811800000L; //8 DEC 2019 7:00 PM

        final Resources resources = getResources();
        final Collection<FitChartValue> values = new ArrayList<>();

        if(Calendar.getInstance().getTimeInMillis() <= endTime)
        {
            new CountDownTimer(endTime-startTime,60000) {
                @Override
                public void onTick(long l) {
                    currentTime = Calendar.getInstance().getTimeInMillis();
                    doneTime = (currentTime-startTime)/(1000*60);
                    Log.i("INFO",String.valueOf(doneTime));

                    if(doneTime < 0)
                    {
                        //Event Not Started
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.defaultRoundName);

                    }
                    else if(doneTime >= 0 && doneTime <= 120)
                    {
                        //Participant's Arrival
                        values.add(new FitChartValue(doneTime, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(120-doneTime, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.participantsArrival);
                    }
                    else if(doneTime > 120 && doneTime <= 300)
                    {
                        //Round 1
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(doneTime - 120, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180 - (doneTime - 120), resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.roundOne);
                    }
                    else if(doneTime > 300 && doneTime <= 420)
                    {
                        //Pizza
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(doneTime - 300, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(120 - (doneTime - 300), resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.pizza);
                    }
                    else if(doneTime > 420 && doneTime <= 660)
                    {
                        //Round2
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(doneTime - 420, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(240 - (doneTime - 420), resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.roundTwo);
                    }
                    else if(doneTime > 660 && doneTime <= 840)
                    {
                        //Fun Event
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(doneTime - 660, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(180 - (doneTime - 660), resources.getColor(R.color.funBreakInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.funEvent);
                    }
                    else if(doneTime > 840 && doneTime <= 900)
                    {
                        //Breakfast
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(doneTime - 840, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(60 - (doneTime - 840), resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.breakfast);
                    }
                    else if(doneTime > 900 && doneTime <= 1080)
                    {
                        //Round 3
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(doneTime - 900, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180 - (doneTime - 900), resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.roundThree);
                    }
                    else if(doneTime > 1080 && doneTime <= 1200)
                    {
                        //Lunch
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(doneTime - 1080, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(120 - (doneTime - 1080), resources.getColor(R.color.foodInactive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.lunch);
                    }
                    else if(doneTime > 1200 && doneTime <= 1380)
                    {
                        //Round 4
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(doneTime - 1200, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180 - (doneTime - 1200), resources.getColor(R.color.roundInactive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.roundFour);
                    }
                    else if(doneTime > 1380 && doneTime <= 1440)
                    {
                        //Break
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(60f, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(120, resources.getColor(R.color.foodActive)));
                        values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                        values.add(new FitChartValue(doneTime - 1380, resources.getColor(R.color.funBreakActive)));
                        values.add(new FitChartValue(60 - (doneTime - 1380), resources.getColor(R.color.funBreakInactive)));

                        currentRoundName.setText(R.string.breakEnd);
                    }
                    timelineChart.setValues(values);
                }

                @Override
                public void onFinish() {
                    //Event Over
                    values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                    values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                    values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                    values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
                    values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
                    values.add(new FitChartValue(60f, resources.getColor(R.color.foodActive)));
                    values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                    values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
                    values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
                    values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakActive)));

                    currentRoundName.setText(R.string.eventEnd);
                }
            }.start();
        }
        else
        {
            //Event Over
            values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
            values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
            values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
            values.add(new FitChartValue(240f, resources.getColor(R.color.roundActive)));
            values.add(new FitChartValue(180f, resources.getColor(R.color.funBreakActive)));
            values.add(new FitChartValue(60f, resources.getColor(R.color.foodActive)));
            values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
            values.add(new FitChartValue(120f, resources.getColor(R.color.foodActive)));
            values.add(new FitChartValue(180f, resources.getColor(R.color.roundActive)));
            values.add(new FitChartValue(60f, resources.getColor(R.color.funBreakActive)));

            currentRoundName.setText(R.string.eventEnd);

            timelineChart.setValues(values);
        }
    }
}
