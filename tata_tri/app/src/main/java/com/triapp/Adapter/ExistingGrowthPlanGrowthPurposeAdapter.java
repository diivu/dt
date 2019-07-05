package com.triapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.triapp.Models.GrowthPlanGrowthPurposeListModel;
import com.triapp.R;

import java.util.ArrayList;

/**
 * Created by ISHER TECH on 10/8/2016.
 */
public class ExistingGrowthPlanGrowthPurposeAdapter extends BaseAdapter {

    Context mcontext;
    ArrayList<GrowthPlanGrowthPurposeListModel.DataBean.ListGPPurposeBean> mPurposeListItems;
    boolean[] itemChecked;
    public static ArrayList<Long> clickedItem = new ArrayList<>();
    public static ArrayList<String> clickedValues = new ArrayList<>();


    public ExistingGrowthPlanGrowthPurposeAdapter(Context mContext, ArrayList<GrowthPlanGrowthPurposeListModel.DataBean.ListGPPurposeBean> mPurposeListItems, ArrayList<Long> etBuyersDetailsIDS, ArrayList<String> stringArrayList) {

        this.mcontext = mContext;
        this.mPurposeListItems = mPurposeListItems;
        this.clickedValues= stringArrayList;
        this.clickedItem = etBuyersDetailsIDS;
        this.itemChecked = new boolean[mPurposeListItems.size()];
        this.notifyDataSetChanged();

    }


    @Override
    public int getCount() {
        return mPurposeListItems.size();
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


        public CheckBox chkSelect;
        public TextView txtItemTwo,txtItemOne;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_multi_checkbox, parent, false);

            holder = new ViewHolder();

            holder.chkSelect = (CheckBox) convertView.findViewById(R.id.chkSelect);
            holder.txtItemOne = (TextView) convertView.findViewById(R.id.txtItemOne);
            holder.txtItemTwo = (TextView) convertView.findViewById(R.id.txtItemTwo);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }

        try {

            holder.txtItemOne.setText(mPurposeListItems.get(position).getValue());
            holder.txtItemTwo.setText("" + mPurposeListItems.get(position).getId());


            if (clickedItem.contains(mPurposeListItems.get(position).getId())) {
                holder.chkSelect.setChecked(true);
            } else {
                holder.chkSelect.setChecked(false);
            }


            holder.chkSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (holder.chkSelect.isChecked()) {
                        itemChecked[position] = true;
                        clickedItem.add(mPurposeListItems.get(position).getId());
                        clickedValues.add(mPurposeListItems.get(position).getValue());
                    } else {
                        itemChecked[position] = false;
                        clickedItem.remove(mPurposeListItems.get(position).getId());
                        clickedValues.remove(mPurposeListItems.get(position).getValue());
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
