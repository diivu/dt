package com.triapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.triapp.Models.CreateEnterpreneurModel.DataBean;
import com.triapp.Models.CreateEnterpreneurModel;
import com.triapp.Models.CreateEnterpreneurModel.DataBean;
import com.triapp.R;

import java.util.ArrayList;

public class EnterpreneurListForEnterpriseAdapter extends BaseAdapter implements Filterable {

    Context mcontext;
    ArrayList<CreateEnterpreneurModel.DataBean> mEnterpreneurList;
    ArrayList<CreateEnterpreneurModel.DataBean> mEnterpreneurFilterList;
    ValueFilter valueFilter;

    public EnterpreneurListForEnterpriseAdapter(Context registerEnterpreniourActivity, ArrayList<CreateEnterpreneurModel.DataBean> mEnterpreneurList) {
        mcontext = registerEnterpreniourActivity;
        this.mEnterpreneurList = mEnterpreneurList;
        this.mEnterpreneurFilterList = mEnterpreneurList;
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mEnterpreneurList.size();
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
                ArrayList<CreateEnterpreneurModel.DataBean> filterList = new ArrayList<>();
                for (int i = 0; i < mEnterpreneurFilterList.size(); i++) {

                    if ( (mEnterpreneurFilterList.get(i).getFullName().toUpperCase() ).contains(constraint.toString().toUpperCase())){

                        CreateEnterpreneurModel.DataBean country = new CreateEnterpreneurModel.DataBean(mEnterpreneurFilterList.get(i).getFullName());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mEnterpreneurFilterList.size();
                results.values = mEnterpreneurFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mEnterpreneurList = (ArrayList<CreateEnterpreneurModel.DataBean>) results.values;
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
            holder.txtStateName.setText(""+mEnterpreneurList.get(position).getFullName());
            holder.txtStateID.setText("" + mEnterpreneurList.get(position).getEnterpreneurID());


        } catch (Exception e){
            e.printStackTrace();
        }

        return convertView;
    }

}
