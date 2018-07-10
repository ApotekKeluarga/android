package com.example.aprian_pc.akonline.Fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.aprian_pc.akonline.Pages.Troli;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.TabBarang.Barang;
import com.example.aprian_pc.akonline.TabTransaksi.Transaksi;
import com.example.aprian_pc.akonline.TabTransaksi.TransaksiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aprian-PC on 27/04/2018.
 */

public class RiwayatFragment extends Fragment {
    private RecyclerView recyclerView;
    private TransaksiAdapter adapter;
    private List<Transaksi> TransaksiList;
    private Button delete;
    StringBuffer sb = null;

    public RiwayatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_riwayat, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view3);


        TransaksiList = new ArrayList<>();
        adapter = new TransaksiAdapter(RiwayatFragment.this.getActivity(), TransaksiList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(RiwayatFragment.this.getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new RiwayatFragment.GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        return rootView;
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

        Transaksi a = new Transaksi("Paracetamol", 500000, covers[0], "Detail", "Detaila", 0, "2 Mei 2018", "001");
        TransaksiList.add(a);

        a = new Transaksi("Bodrex", 200000, covers[1], "Detail", "Detaila", 5, "3 Mei 2018", "002");
        TransaksiList.add(a);

        a = new Transaksi("Ultraflu", 150000, covers[2], "Detail", "Detaila", 5, "3 Mei 2018", "003");
        TransaksiList.add(a);

        a = new Transaksi("Konimex", 155000, covers[3], "Detail", "Detaila", 5, "3 Mei 2018", "004");
        TransaksiList.add(a);

        a = new Transaksi("Sangobion", 160000, covers[4], "Detail", "Detaila", 4, "3 Mei 2018", "005");
        TransaksiList.add(a);

        a = new Transaksi("Antimo", 145000, covers[5], "Detail", "Detaila", 3, "3 Mei 2018", "006");
        TransaksiList.add(a);

        a = new Transaksi("Komix", 135000, covers[6], "Detail", "Detaila", 2, "3 Mei 2018", "007");
        TransaksiList.add(a);

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
