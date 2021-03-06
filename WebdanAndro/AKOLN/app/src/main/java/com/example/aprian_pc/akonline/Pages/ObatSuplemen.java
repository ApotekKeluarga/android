package com.example.aprian_pc.akonline.Pages;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aprian_pc.akonline.TabAntibiotik.Antibiotik;
import com.example.aprian_pc.akonline.TabHerbal.Herbal;
import com.example.aprian_pc.akonline.TabHerbal.HerbalAdapter;
import com.example.aprian_pc.akonline.R;
import com.example.aprian_pc.akonline.TabSuplemen.Suplemen;
import com.example.aprian_pc.akonline.TabSuplemen.SuplemenAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

public class ObatSuplemen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SuplemenAdapter adapter;
    private List<Suplemen> paketList;
    private ProgressDialog pd;
    final String URL = ServerUrl.URL+"Android/Herbal/get_ObatSuplemen";
//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obat_herbal);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        paketList = new ArrayList<>();
        adapter = new SuplemenAdapter(this, paketList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        request_data();
        //prepareAlbums();

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
//    private void prepareAlbums() {
//        int[] covers = new int[]{
//                R.drawable.bantuan,
//                R.drawable.cari,
//                R.drawable.anak,
//                R.drawable.antibiotik,
//                R.drawable.kesehatan,
//                R.drawable.herbal,
//                R.drawable.resep
//        };
//
//        Herbal a = new Herbal("Paracetamol",  500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Bodrex",  500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Ultraflu",  500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Konimex",  500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Sangobion",500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Antimo",500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Komix",500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
////        a = new Anak("Saya", 120000, covers[7]);
////        paketList.add(a);
////
////        a = new Anak("Sayaka", 170000, covers[8]);
////        paketList.add(a);
////
////        a = new Anak("Hirasa", 190000, covers[9]);
////        paketList.add(a);
//
//        adapter.notifyDataSetChanged();
//    }

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
    public void request_data(){
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest strReq = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.hide();
                        try{
                            JSONObject jsObj = new JSONObject(response);
                            JSONArray suplemen = jsObj.getJSONArray("suplemen");
                            String beli="beli", detail="detail";
                            Suplemen obatsuplemen;
                            for (int i=0;i<suplemen.length();i++){
                                JSONObject p = suplemen.getJSONObject(i);
                                String name = p.getString("nm_barang");
                                Log.d("ObatHerbal",name);
                                int harga = p.getInt("harga");
                                String id = p.getString("kd_barang");
                                String url_gambar = p.getString("img");
                                obatsuplemen = new Suplemen(name,harga,url_gambar, beli,detail,id);
                                paketList.add(obatsuplemen);
                            }
                            adapter.notifyDataSetChanged();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }

                }
        );
        strReq.setRetryPolicy(new DefaultRetryPolicy(0,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(strReq);
    }
}
