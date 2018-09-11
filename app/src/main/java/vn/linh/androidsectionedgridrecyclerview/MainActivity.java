package vn.linh.androidsectionedgridrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import vn.linh.androidsectionedgridrecyclerview.model.ItemImage;
import vn.linh.androidsectionedgridrecyclerview.model.ItemSection;
import vn.linh.androidsectionedgridrecyclerview.model.RecyclerViewItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Grid Recycler View Use Spacing");

        mRecyclerView = findViewById(R.id.recycler_view);

        ArrayList<RecyclerViewItem> data = new ArrayList<>();
        data.add(new ItemImage("a", "b"));
        data.add(new ItemImage("c", "b"));
        data.add(new ItemSection());
        data.add(new ItemImage("d", "b"));
        data.add(new ItemImage("e", "b"));
        data.add(new ItemImage("f", "b"));
        data.add(new ItemImage("g", "b"));
        data.add(new ItemSection());
        data.add(new ItemImage("h", "b"));
        data.add(new ItemSection());
        data.add(new ItemImage("j", "b"));
        data.add(new ItemImage("k", "b"));
        data.add(new ItemImage("l", "b"));
        data.add(new ItemImage("m", "b"));

        // set up the RecyclerView
        int numberOfColumns = 3;
        GridLayoutManager grid = new GridLayoutManager(this, numberOfColumns);
        grid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(adapter.getItemViewType(position) == MyRecyclerViewAdapter.TYPE_SECTION){
                    return 3;
                }
                return 1;
            }
        });
        mRecyclerView.setLayoutManager(grid);
        adapter = new MyRecyclerViewAdapter(this);

        adapter.set(data);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 20, true));
    }
}
