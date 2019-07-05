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
import com.triapp.Models.StateListModel;
import com.triapp.R;

import java.util.ArrayList;

public class StateListAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<StateListModel> mStateList;
    ArrayList<StateListModel> mFilteredStateList;
    ValueFilter valueFilter;

    public StateListAdapter(Context registerEnterpreniourActivity, ArrayList<StateListModel> mStateList) {
        mcontext = registerEnterpreniourActivity;
        this.mStateList = mStateList;
        this.mFilteredStateList = mStateList;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mStateList.size();
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
                for (int i = 0; i < mFilteredStateList.size(); i++) {
                    if ( (mFilteredStateList.get(i).getStrStateName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())){

                        CastListModel country = new CastListModel(mFilteredStateList.get(i).getStrStateName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredStateList.size();
                results.values = mFilteredStateList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mStateList = (ArrayList<StateListModel>) results.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder {
        TextView txtStateName , txtStateID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ViewHolder();

            holder.txtStateName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtStateID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try{
            holder.txtStateName.setText(mStateList.get(position).getStrStateName());
            holder.txtStateID.setText("" + mStateList.get(position).getIntStateID());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
