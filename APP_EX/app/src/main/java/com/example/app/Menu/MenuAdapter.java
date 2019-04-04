package com.example.app.Menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<Menu> menuBoard;
    private Menu menu;

    public MenuAdapter( List<Menu> menuBoard ){
        this.menuBoard = menuBoard;
        Log.d(menuBoard.toString(), "MenuAdapter Called!!");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from( viewGroup.getContext() )
                .inflate( R.layout.menu_list_row, viewGroup, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        menu = menuBoard.get( i );

        viewHolder.menu.setText( menu.getMenu() );
        viewHolder.price.setText( menu.getPrice() + " 원" );
    }

    @Override
    public int getItemCount() {
        return menuBoard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView menu, price;

        public ViewHolder( View view ) {
            super( view );
            menu  = view.findViewById( R.id.menu );
            price = view.findViewById( R.id.price );

        }
    }
}
