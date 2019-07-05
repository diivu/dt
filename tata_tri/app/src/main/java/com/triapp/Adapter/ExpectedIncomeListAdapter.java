package com.triapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.triapp.Models.CastListModel;
import com.triapp.Models.VillegeListModel;
import com.triapp.R;

import java.util.ArrayList;

public class ExpectedIncomeListAdapter extends BaseAdapter {

    Context mcontext;
    String[] expectedIncomList;

    public ExpectedIncomeListAdapter(Context mcontext, String[] expectedIncomList) {
        this.mcontext = mcontext;
        this.expectedIncomList = expectedIncomList;

    }

    @Override
    public int getCount() {
        return expectedIncomList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtExpectedItemName,txtID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ExpectedIncomeListAdapter.ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ExpectedIncomeListAdapter.ViewHolder();

            holder.txtExpectedItemName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ExpectedIncomeListAdapter.ViewHolder) convertView.getTag();

        }

        try{
            holder.txtExpectedItemName.setText(expectedIncomList[position]);
            holder.txtID.setText(""+(position +1));

        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}