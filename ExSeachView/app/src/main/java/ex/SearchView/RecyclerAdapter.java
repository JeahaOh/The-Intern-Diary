package ex.SearchView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mCtx;

    private List<Recent> items= null;
    private ArrayList<Recent> arrayList;

    public RecyclerAdapter(Context context, List<Recent> items) {
        this.mCtx=context;
        this.items=items;
        arrayList = new ArrayList<Recent>();
        arrayList.addAll(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent,null);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recent item=items.get(position);

        holder.tv_address.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if (charText.length() == 0) {
            items.addAll(arrayList);
        } else {
            for (Recent recent : arrayList) {
                String name = recent.getAddress();
                if (name.toLowerCase().contains(charText)) {
                    items.add(recent);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_address;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_address= (TextView) itemView.findViewById(R.id.tvAddress);
        }


    }
}
