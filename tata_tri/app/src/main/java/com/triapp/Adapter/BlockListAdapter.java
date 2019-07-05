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
import com.triapp.Models.DistrinctListModel;
import com.triapp.R;

import java.util.ArrayList;

public class BlockListAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<BlockListModel> mBlockList;
    ArrayList<BlockListModel> mFilteredBlockList;
    ValueFilter valueFilter;

    public BlockListAdapter(Context registerEnterpreniourActivity, ArrayList<BlockListModel> mBlockList) {
        mcontext = registerEnterpreniourActivity;
        this.mBlockList = mBlockList;
        this.mFilteredBlockList = mBlockList;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mBlockList.size();
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
                for (int i = 0; i < mFilteredBlockList.size(); i++) {
                    if ( (mFilteredBlockList.get(i).getBlockName().toUpperCase() )
                            .contains(constraint.toString().toUpperCase())){

                        CastListModel country = new CastListModel(mFilteredBlockList.get(i).getBlockName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mFilteredBlockList.size();
                results.values = mFilteredBlockList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mBlockList = (ArrayList<BlockListModel>) results.values;
            notifyDataSetChanged();
        }
    }

    public class ViewHolder {
        TextView txtBlockName , txtBlockID ;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

            holder = new ViewHolder();

            holder.txtBlockName = (TextView) convertView.findViewById(R.id.txtItemname);
            holder.txtBlockID = (TextView) convertView.findViewById(R.id.txtID);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try{
            holder.txtBlockName.setText(mBlockList.get(position).getBlockName());
            holder.txtBlockID.setText("" + mBlockList.get(position).getBlockId());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
