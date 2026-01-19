package com.carro.admin.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.carro.admin.ui.fragment.booking.BusBookingFragment;
import com.carro.admin.ui.fragment.booking.CabBookingFragment;
import com.carro.admin.ui.fragment.booking.LuxuryBookingFragment;
import com.carro.admin.ui.fragment.booking.SelfBookingFragment;


public class BookingsTabAdapter extends FragmentStateAdapter {

//    public CourseDetailsModel courseDetailsModel;

//    public BookingsTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, CourseDetailsModel courseDetailsModel) {
//        super(fragmentManager, lifecycle);
//        this.courseDetailsModel = courseDetailsModel;
//    }

        public BookingsTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SelfBookingFragment();
            case 2:
                return new LuxuryBookingFragment();
            case 3:
                return new BusBookingFragment();
            default:
                return new CabBookingFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
