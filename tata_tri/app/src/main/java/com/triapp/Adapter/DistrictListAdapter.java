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
import com.triapp.Models.DistrinctListModel;
import com.triapp.Models.StateListModel;
import com.triapp.R;

import java.util.ArrayList;

public class DistrictListAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<DistrinctListModel> mDistrictList;
    ArrayList<DistrinctListModel> mFilteredDistrictList;
    ValueFilter valueFilter;

    public DistrictListAdapter(Context registerEnterpreniourActivity, ArrayList<DistrinctListModel> mDistrictList) {
        mcontext = registerEnterpreniourActivity;
        this.mDistrictList = mDistrictList;
        this.mFilteredDistrictList = mDistrictList;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mDistrictList.size();
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
                ArrayList<CastListModel> filterList = new ArrayList<>();
                for (int i = 0; i < mFilteredDistrictList.size(); i++) {
                    if ( (mFilteredDistrictList.get(i).getStrDistrictName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())){

                        CastListModel country = new CastListModel(mFilteredDistrictList.get(i).getStrDistrictName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredDistrictList.size();
                results.values = mFilteredDistrictList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDistrictList = (ArrayList<DistrinctListModel>) results.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder {
        TextView txtDistrictName , txtDistrinctID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ViewHolder();

            holder.txtDistrictName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtDistrinctID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try{
            holder.txtDistrictName.setText(mDistrictList.get(position).getStrDistrictName());
            holder.txtDistrinctID.setText("" + mDistrictList.get(position).getIntDistrinctID());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
