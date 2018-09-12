package vn.linh.androidsectionedgridrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.linh.androidsectionedgridrecyclerview.model.ItemImage;
import vn.linh.androidsectionedgridrecyclerview.model.RecyclerViewItem;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<RecyclerViewItem> dataSet;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public static final int TYPE_SECTION = 1;
    public static final int TYPE_ITEM = 2;

    public MyRecyclerViewAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void set(List<RecyclerViewItem> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_ITEM) {
            View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
            viewHolder = new ItemViewHolder(view);
        } else {
            View view = mInflater.inflate(R.layout.item_section, parent, false);
            viewHolder = new SectionHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemImage itemImage = (ItemImage) dataSet.get(position);
           // ((ItemViewHolder) holder).myTextView.setText(itemImage.getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof ItemImage) {
            return TYPE_ITEM;
        } else {
            return TYPE_SECTION;
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //public TextView myTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            //myTextView = (TextView) itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public class SectionHolder extends RecyclerView.ViewHolder {

        public SectionHolder(View itemView) {
            super(itemView);
        }
    }

    public RecyclerViewItem getItem(int id) {
        return dataSet.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}