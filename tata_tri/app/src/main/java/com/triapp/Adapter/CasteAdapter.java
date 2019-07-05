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
import com.triapp.R;

import java.util.ArrayList;

public class CasteAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<CastListModel> mCastList;
    ArrayList<CastListModel> mFilteredCastList;
    ValueFilter valueFilter;

    public CasteAdapter(Context registerEnterpreniourActivity, ArrayList<CastListModel> mCastList) {
        mcontext = registerEnterpreniourActivity;
        this.mCastList = mCastList;
        this.mFilteredCastList = mCastList;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mCastList.size();
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
                for (int i = 0; i < mFilteredCastList.size(); i++) {
                    if ( (mFilteredCastList.get(i).getCastName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())){

                        CastListModel country = new CastListModel(mFilteredCastList.get(i).getCastName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredCastList.size();
                results.values = mFilteredCastList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mCastList = (ArrayList<CastListModel>) results.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder {
        TextView txtCastName , txtCastID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ViewHolder();

            holder.txtCastName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtCastID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try{
            holder.txtCastName.setText(mCastList.get(position).getCastName());
            holder.txtCastID.setText("" + mCastList.get(position).getCastID());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
