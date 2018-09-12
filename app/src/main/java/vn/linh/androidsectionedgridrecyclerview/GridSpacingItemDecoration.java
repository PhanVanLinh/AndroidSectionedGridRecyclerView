package vn.linh.androidsectionedgridrecyclerview;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * https://stackoverflow.com/a/30701422/5381331
 */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        outRect.bottom = spacing;

        if((position+1)%spanCount != 0) {
            outRect.right = spacing;
        }else{
            outRect.right = 20;
        }



//        outRect.top = 0;
//        outRect.left = 0;
//        try {
//            if (((GridLayoutManager) parent.getLayoutManager()).getSpanSizeLookup()
//                    .getSpanIndex(position + 1, spanCount) != 0) {
//                outRect.right = spacing;
//            } else {
//                outRect.right = 0;
//            }
//        } catch (Exception ex) {
//
//        }

        Log.i("TAG", "pos: "
                + position
                + " top:"
                + outRect.top
                + " right:"
                + outRect.right
                + " bottom:"
                + outRect.bottom
                + " left:"
                + outRect.left);
    }
}