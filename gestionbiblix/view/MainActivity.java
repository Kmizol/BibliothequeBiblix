package com.example.millet.gestionbiblix.view;

import android.content.Intent;
import android.os.IInterface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.millet.gestionbiblix.MySQL.Downloader;
import com.example.millet.gestionbiblix.R;
import com.example.millet.gestionbiblix.modele.Livre;
import com.example.millet.gestionbiblix.modele.RetourneLivre;
import com.example.millet.gestionbiblix.modele.TestRtrLivre;
import com.example.millet.gestionbiblix.outil.GridViewAdapter;

public class MainActivity extends AppCompatActivity {

    String urlAddress="https://biblixbdd.000webhostapp.com/biblix/RecupLivre.php";
    TextView TitreL;


    GridView gridView;
    public static String[] ListeLivre = {
            "Fondation",
            "L'homme qui voulait être heureux"
    };
    public static int[] osImages = {
            R.drawable.fondation,
            R.drawable.l_homme_qui_voulait_etre_heureux
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TitreL = findViewById(R.id.textview);
        final ListView lv = (ListView) findViewById(R.id.lv);

        gridView = (GridView) findViewById(R.id.ListLivres);
        gridView.setAdapter(new GridViewAdapter(this, ListeLivre, osImages));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position ==0)
                {


                    String titre = TitreL.getText().toString();
                    String type = "titre";
                    TestRtrLivre testRtrLivre = new TestRtrLivre(this);
                    testRtrLivre.execute(type, titre);

                    //Downloader d=new Downloader(MainActivity.this,urlAddress,lv);
                    //d.execute();

                    //Intent Conn = new Intent(MainActivity.this, ListeLivreActivity.class);
                    //startActivity(Conn);
                }

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Toast.makeText(this, "Settings menu selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_login:
                Intent Conn = new Intent(this, LoginActivity.class);
                this.startActivity(Conn);

            // Toast.makeText(this, "Login menu selected", Toast.LENGTH_LONG).show();
            //return true;
            default:


    }return super.onOptionsItemSelected(item);
    }

}

