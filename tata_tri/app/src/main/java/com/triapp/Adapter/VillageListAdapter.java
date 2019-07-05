package com.triapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.triapp.Models.BlockListModel;
import com.triapp.Models.CastListModel;
import com.triapp.Models.VillegeListModel;
import com.triapp.R;

import java.util.ArrayList;

public class VillageListAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<VillegeListModel> mVillegeList;
    ArrayList<VillegeListModel> mFilteredVillegeList;
    ValueFilter valueFilter;

    public VillageListAdapter(Context registerEnterpreniourActivity, ArrayList<VillegeListModel> mVillegeList) {
        mcontext = registerEnterpreniourActivity;
        this.mVillegeList = mVillegeList;
        this.mFilteredVillegeList = mVillegeList;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mVillegeList.size();
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
                for (int i = 0; i < mFilteredVillegeList.size(); i++) {
                    if ( (mFilteredVillegeList.get(i).getVillegeName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())){

                        CastListModel country = new CastListModel(mFilteredVillegeList.get(i).getVillegeName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredVillegeList.size();
                results.values = mFilteredVillegeList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mVillegeList = (ArrayList<VillegeListModel>) results.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder {
        TextView txtVillegeName , txtVillegeID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ViewHolder();

            holder.txtVillegeName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtVillegeID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try{
            holder.txtVillegeName.setText(mVillegeList.get(position).getVillegeName());
            holder.txtVillegeID.setText("" + mVillegeList.get(position).getVillegeId());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
