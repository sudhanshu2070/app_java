package com.example.some_app.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.some_app.R;
import com.example.some_app.modal.BeansSiteView;

import java.util.List;

public class SiteAdapter extends ArrayAdapter<BeansSiteView> {
    private Context context;
    private List<BeansSiteView> siteList;

    public SiteAdapter(Context context, List<BeansSiteView> siteList) {
        super(context, 0, siteList);
        this.context = context;
        this.siteList = siteList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_schedule, parent, false);
        }

        // Get the site for this position
        BeansSiteView site = getItem(position);

        // Populate the data into the template view
        TextView tvPmTktId = convertView.findViewById(R.id.tvPmTktId);
        TextView tvSidName = convertView.findViewById(R.id.tvSidName);
        TextView status = convertView.findViewById(R.id.status);
        TextView crdDt = convertView.findViewById(R.id.crdDt);

        tvPmTktId.setText(site.getPmTktId());
        tvSidName.setText(site.getSidName());
        status.setText(site.getACTIVITY_STATUS());
        crdDt.setText(site.getCreatedDt());

        return convertView;
    }
}