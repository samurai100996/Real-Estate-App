package com.example.project1662.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.project1662.Domain.PropertyDomain;
import com.example.project1662.R;

import java.util.ArrayList;

public class PropertyAdapter extends ArrayAdapter<PropertyDomain> {
    private ArrayList<PropertyDomain> properties;
    private Context context;

    public PropertyAdapter(Context context, ArrayList<PropertyDomain> properties) {
        super(context, 0, properties);
        this.context = context;
        this.properties = properties;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.propertyviewholder, parent, false);
        }

        // Get property at current position
       final PropertyDomain property = getItem(position);

        // Bind data to views
        TextView titleTextView = convertView.findViewById(R.id.titleTxt);
        TextView typeTextView = convertView.findViewById(R.id.typeTxt);
        TextView addressTextView = convertView.findViewById(R.id.addressTxt);
        TextView priceTextView = convertView.findViewById(R.id.priceTxt);

        titleTextView.setText(property.getTitle());
        typeTextView.setText(property.getType());
        addressTextView.setText(property.getAddress());
        priceTextView.setText("$" + property.getPrice());

        // Set OnClickListener for the convertView
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open DetailActivity and pass property details
                Intent intent = new Intent(context, PropDetails.class);
                intent.putExtra("property", property);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
