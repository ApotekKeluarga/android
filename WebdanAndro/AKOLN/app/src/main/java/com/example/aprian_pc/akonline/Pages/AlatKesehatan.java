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
import com.example.aprian_pc.akonline.TabAlkes.Alkes;
import com.example.aprian_pc.akonline.TabAlkes.AlkesAdapter;
import com.example.aprian_pc.akonline.TabAnak.Anak;
import com.example.aprian_pc.akonline.TabHerbal.Herbal;
import com.example.aprian_pc.akonline.TabHerbal.HerbalAdapter;
import com.example.aprian_pc.akonline.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class AlatKesehatan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AlkesAdapter adapter;
    private List<Alkes> paketList;
    private ProgressDialog pd;
    final String URL = ServerUrl.URL+"Android/Herbal/get_AlatKes";
//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obat_herbal);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        paketList = new ArrayList<>();
        adapter = new AlkesAdapter(this, paketList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        request_data();

//        prepareAlbums();

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
//        Herbal a = new Herbal("Personal",  500000, "covers[0]","Beli","Detail","jj");
//        paketList.add(a);
//
//        a = new Herbal("Couple",  200000, "covers[1]","Beli","Detail","bb");
//        paketList.add(a);
//
//        a = new Herbal("Maturity",  150000, "covers[2]","Beli","Detail","sada");
//        paketList.add(a);
//
//        a = new Herbal("Group",  155000, "covers[3]","Beli","Detail","asda");
//        paketList.add(a);
//
//        a = new Herbal("PreWeed",160000, "covers[4]","Beli","Detail","sadsa");
//        paketList.add(a);
//
//        a = new Herbal("Wisuda",145000, "covers[5]","Beli","Detail","asdsa");
//        paketList.add(a);
//
//        a = new Herbal("Weeding",135000, "covers[6]","Beli","Detail","asdas");
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
                            JSONArray anak = jsObj.getJSONArray("alkes");
                            String beli="beli", detail="detail";
                            Alkes alkes;
                            for (int i=0;i<anak.length();i++){
                                JSONObject p = anak.getJSONObject(i);
                                String name = p.getString("nm_barang");
                                Log.d("ObatHerbal",name);
                                int harga = p.getInt("harga");
                                String id = p.getString("kd_barang");
                                String url_gambar = p.getString("img");
                                alkes = new Alkes(name,harga,url_gambar, beli,detail,id);
                                paketList.add(alkes);
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
