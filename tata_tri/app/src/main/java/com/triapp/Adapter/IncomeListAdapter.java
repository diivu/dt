package com.triapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.triapp.R;

public class IncomeListAdapter extends BaseAdapter {

        Context mcontext;
        String[] currentIncomList;

        public IncomeListAdapter(Context mcontext, String[] currentIncomList) {
            this.mcontext = mcontext;
            this.currentIncomList = currentIncomList;

        }

        @Override
        public int getCount() {
            return currentIncomList.length;
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
            TextView txtIncomeName,txtID ;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.raw_serachview_dialog_items, parent, false);

                holder = new ViewHolder();

                holder.txtIncomeName = (TextView) convertView.findViewById(R.id.txtItemname);
                holder.txtID = (TextView) convertView.findViewById(R.id.txtID);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();

            }

            try{
                holder.txtIncomeName.setText(currentIncomList[position]);
                holder.txtID.setText(""+(position +1));

            } catch (Exception e){
                e.printStackTrace();
            }

            return convertView;
        }

    }