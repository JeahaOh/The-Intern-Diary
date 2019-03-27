package ex.SearchView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mCtx;

    private List<Recent> originList = null;
    private ArrayList<Recent> filteredList;

    public RecyclerAdapter(Context context, List<Recent> originList) {
        this.mCtx=context;
        this.originList = originList;
        filteredList = new ArrayList<Recent>();
        filteredList.addAll(originList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent,null);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recent item= originList.get(position);

        holder.tv_address.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return this.originList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_address;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_address= (TextView) itemView.findViewById(R.id.tvAddress);
        }


    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        originList.clear();
        if (charText.length() == 0) {
            originList.addAll(filteredList);
        } else {
            for (Recent recent : filteredList) {
                String name = recent.getAddress();
                if (name.toLowerCase().contains(charText)) {
                    originList.add(recent);
                    //System.out.println( originList.toString() );
                }
            }
        }
        notifyDataSetChanged();
    }
}
