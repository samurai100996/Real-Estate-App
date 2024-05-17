package com.example.project1662.Adapter;

import android.content.Context;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project1662.R;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Property> {

    private Context mContext;
    private int mResource;

    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<Property> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.pic = view.findViewById(R.id.pic);
            holder.typeTxt = view.findViewById(R.id.typeTxt);
            holder.titleTxt = view.findViewById(R.id.titleTxt);
            holder.addressTxt = view.findViewById(R.id.addressTxt);
            holder.priceTxt = view.findViewById(R.id.priceTxt);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Property property = getItem(position);

       /* if (property != null) {
            holder.pic.setImageResource(property.getImageId());
            holder.typeTxt.setText(property.getType());
            holder.titleTxt.setText(property.getTitle());
            holder.addressTxt.setText(property.getAddress());
            holder.priceTxt.setText("$" + property.getPrice());
        }*/

        return view;
    }

    static class ViewHolder {
        ImageView pic;
        TextView typeTxt;
        TextView titleTxt;
        TextView addressTxt;
        TextView priceTxt;
    }
}
