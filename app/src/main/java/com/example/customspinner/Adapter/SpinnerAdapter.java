package com.example.customspinner.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customspinner.R;
import com.example.customspinner.model.ViewPerson;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<ViewPerson> {
    private static final int CLOSE = 645;
    private static final int OPEN = 974;
    private LayoutInflater inflater;


    public SpinnerAdapter(Context mContext, ArrayList<ViewPerson> arrayList){

        super(mContext, R.layout.spinner_item_open,arrayList);
        inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position,parent,CLOSE);
    }




    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position,parent,OPEN);
    }





    public View getCustomView(int position, ViewGroup viewGroup, int type){
        View mView = null;
        if(type == OPEN)
            mView=inflater.inflate(R.layout.spinner_item_open,viewGroup,false);
        else if(type == CLOSE)
            mView=inflater.inflate(R.layout.spinner_item_close,viewGroup,false);


        TextView txtName = mView.findViewById(R.id.txtName);
        txtName.setText(getItem(position).getName());

        if(type == OPEN){
            ImageView imgPic = mView.findViewById(R.id.imgPic);
            imgPic.setImageResource(getItem(position).getResId());
        }


        return mView;
    }
}
