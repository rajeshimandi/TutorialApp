package com.example.anuraj.tutorialsapplication.activities.home;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;

import java.util.ArrayList;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.MenuViewHolder> {

    private ArrayList<String> mMenuList;
    private final MenuItemSelectedListener itemSelectedListener;

    public HomeListAdapter(ArrayList<String> menuList, MenuItemSelectedListener listener) {
        mMenuList = menuList;
        itemSelectedListener = listener;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_menuitem, parent, false);

        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {

        holder.menuName.setText(mMenuList.get(position));

        holder.menuName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelectedListener.onMenuItemSelected(position, mMenuList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMenuList != null ? mMenuList.size() : 0;
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {

        TextView menuName;

        public MenuViewHolder(View itemView) {
            super(itemView);
            menuName = itemView.findViewById(R.id.menuName);

        }
    }

}
