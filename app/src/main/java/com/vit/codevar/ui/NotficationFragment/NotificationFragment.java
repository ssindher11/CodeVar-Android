package com.vit.codevar.ui.NotficationFragment;

import android.app.Notification;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vit.codevar.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_notification,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        List<NotificationRVData> RVData =new ArrayList<>();

        NotificationRVData TestData1=new NotificationRVData("Notification-1","21.30");
        NotificationRVData TestData2=new NotificationRVData("Notification-2","21.30");

        RVData.add(TestData1);
        RVData.add(TestData2);

        RecyclerView recyclerView =view.findViewById(R.id.notificationRecyclerView);
        NotificationRecyclerViewAdapter adapter = new NotificationRecyclerViewAdapter(getContext(),RVData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
