package com.example.aprian_pc.akonline.Pages;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.TabBarang.Barang;
import com.example.aprian_pc.akonline.TabBarang.BarangAdapter;
import com.example.aprian_pc.akonline.TabPesanan.Pesanan;
import com.example.aprian_pc.akonline.TabPesanan.PesananAdapter;

import java.util.ArrayList;
import java.util.List;

public class KonfirmasiPesanan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PesananAdapter adapter;
    private List<Pesanan> PesananList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pesanan);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        PesananList = new ArrayList<>();
        adapter = new PesananAdapter(this, PesananList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new KonfirmasiPesanan.GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();
    }

    private void prepareAlbums() {

        Pesanan p = new Pesanan("Tersedia", "AK001", "Batalkan", "Konfirmasi");
        PesananList.add(p);
        p = new Pesanan("Tersedia", "AK002", "Batalkan", "Konfirmasi");
        PesananList.add(p);

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

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
