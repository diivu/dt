package com.triapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.triapp.Models.ReligionListModel;
import com.triapp.R;

import java.util.ArrayList;

public class ReligionAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<ReligionListModel> mReligionList;
    ArrayList<ReligionListModel> mFilteredReligionList;
    ValueFilter valueFilter;

    public ReligionAdapter(Context mcontext, ArrayList<ReligionListModel> mReligionList) {

        this.mcontext = mcontext;
        this.mReligionList = mReligionList;
        this.mFilteredReligionList = mReligionList;
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mReligionList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {

        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;

    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<ReligionListModel> filterList = new ArrayList<>();
                for (int i = 0; i < mFilteredReligionList.size(); i++) {
                    if ( (mFilteredReligionList.get(i).getReligionName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())){

                        ReligionListModel country = new ReligionListModel(mFilteredReligionList.get(i).getReligionName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredReligionList.size();
                results.values = mFilteredReligionList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mReligionList = (ArrayList<ReligionListModel>) results.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder {
        TextView txtReligionName , txtReligionID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ViewHolder();

            holder.txtReligionName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtReligionID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try{


            holder.txtReligionName.setText(mReligionList.get(position).getReligionName());
            holder.txtReligionID.setText("" + mReligionList.get(position).getReligionID());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
