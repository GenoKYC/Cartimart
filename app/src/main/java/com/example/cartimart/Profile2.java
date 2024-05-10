package com.example.cartimart;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.cartimart.R;

public class Profile2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile2, container, false);

        // Find the ConstraintLayout for Address
        ConstraintLayout addressLayout = view.findViewById(R.id.address_scr);
        ConstraintLayout autoschedLayout = view.findViewById(R.id.autosched_scr);
        ConstraintLayout historyLayout = view.findViewById(R.id.history_scr);

        // Set click listener for Address
        addressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define what should happen when addressLayout is clicked
                openAddressActivity();
            }
        });

        autoschedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define what should happen when addressLayout is clicked
                openAutoSchedActivity();
            }
        });

        historyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define what should happen when addressLayout is clicked
                openHistoryLayout();
            }
        });

        return view;
    }

    // Method to open AddressActivity
    private void openAddressActivity() {
        Intent intent = new Intent(getActivity(), Address.class);
        startActivity(intent);
    }

    private void openAutoSchedActivity() {
        Intent intent = new Intent(getActivity(), AutoSchedule.class);
        startActivity(intent);
    }

    private void openHistoryLayout() {
        Intent intent = new Intent(getActivity(), History.class);
        startActivity(intent);
    }
}
