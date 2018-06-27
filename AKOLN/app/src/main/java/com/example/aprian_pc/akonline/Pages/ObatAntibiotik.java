package com.example.aprian_pc.akonline.Pages;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import com.example.aprian_pc.akonline.TabHerbal.PaketAdapter;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.TabHerbal.Paket;

public class ObatAntibiotik extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PaketAdapter adapter;
    private List<Paket> paketList;
//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obat_antibiotik);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        paketList = new ArrayList<>();
        adapter = new PaketAdapter(this, paketList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

//        try {
//            Glide.with(this).load(R.drawable.img2).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
//    private void initCollapsingToolbar() {
//        final CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbar.setTitle(" ");
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
//        appBarLayout.setExpanded(true);
//
//        // hiding & showing the title when toolbar expanded & collapsed
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbar.setTitle(getString(R.string.app_name));
//                    toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbar.setTitle(" ");
//                    isShow = false;
//                }
//            }
//        });
//    }

    /**
     * Adding few albums for testing
     */
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

        Paket a = new Paket("Paracetamol",  500000, covers[0],"Beli","Detail");
        paketList.add(a);

        a = new Paket("Bodrex",  200000, covers[1],"Beli","Detail");
        paketList.add(a);

        a = new Paket("Ultraflu",  150000, covers[2],"Beli","Detail");
        paketList.add(a);

        a = new Paket("Konimex",  155000, covers[3],"Beli","Detail");
        paketList.add(a);

        a = new Paket("Sangobion",160000, covers[4],"Beli","Detail");
        paketList.add(a);

        a = new Paket("Antimo",145000, covers[5],"Beli","Detail");
        paketList.add(a);

        a = new Paket("Komix",135000, covers[6],"Beli","Detail");
        paketList.add(a);

//        a = new Paket("Saya", 120000, covers[7]);
//        paketList.add(a);
//
//        a = new Paket("Sayaka", 170000, covers[8]);
//        paketList.add(a);
//
//        a = new Paket("Hirasa", 190000, covers[9]);
//        paketList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
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
