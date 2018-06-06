package com.example.aprian_pc.akonline.Pages;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aprian_pc.akonline.Fragment.LayananFragment;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.TabHerbal.Barang;
import com.example.aprian_pc.akonline.TabHerbal.BarangAdapter;

import java.util.ArrayList;
import java.util.List;

public class Troli extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BarangAdapter adapter;
    private CheckBox checkbox;
    private List<Barang> BarangList;
    private Button delete, checkout;
    String TAG = "Ardhan";
    StringBuffer sb = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troli);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        delete = (Button) findViewById(R.id.delete);
        checkout = (Button) findViewById(R.id.checkout);
        checkbox = (CheckBox) findViewById(R.id.checkbox);

        BarangList = new ArrayList<>();
        adapter = new BarangAdapter(this, BarangList);



        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new Troli.GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BarangList.size()>0) {
                    BarangList.remove(0);
                    adapter.notifyItemRemoved(0);
                }
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Troli.this, Checkout.class);
                startActivity(intent);
            }
        });


    }


    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.bantuan,
                R.drawable.cari,
                R.drawable.anak,
                R.drawable.antibiotik,
                R.drawable.kesehatan,
                R.drawable.herbal,
                R.drawable.resep
        };

        Barang a = new Barang("Paracetamol", 500000, covers[0], "+", "-", 0);
        BarangList.add(a);

        a = new Barang("Bodrex", 200000, covers[1], "+", "-", 0);
        BarangList.add(a);

        a = new Barang("Ultraflu", 150000, covers[2], "+", "-", 0);
        BarangList.add(a);

        a = new Barang("Konimex", 155000, covers[3], "+", "-", 0);
        BarangList.add(a);

        a = new Barang("Sangobion", 160000, covers[4], "+", "-", 0);
        BarangList.add(a);

        a = new Barang("Antimo", 145000, covers[5], "+", "-", 0);
        BarangList.add(a);

        a = new Barang("Komix", 135000, covers[6], "+", "-", 0);
        BarangList.add(a);

        adapter.notifyDataSetChanged();
    }

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
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }



}
