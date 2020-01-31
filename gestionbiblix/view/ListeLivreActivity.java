package com.example.millet.gestionbiblix.view;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.millet.gestionbiblix.MySQL.Downloader;
import com.example.millet.gestionbiblix.R;
import com.example.millet.gestionbiblix.modele.TestRtrLivre;


public class ListeLivreActivity extends AppCompatActivity {

    String urlAddress="https://biblixbdd.000webhostapp.com/biblix/RecupLivre.php";
    TextView TitreL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_livre);
        TitreL = findViewById(R.id.textview);

    }

    public void OnLogin(View view) {
        String titre = TitreL.getText().toString();
        String type = "titre";
        TestRtrLivre testRtrLivre = new TestRtrLivre((AdapterView.OnItemClickListener) this);
        testRtrLivre.execute(type, titre);
    }
}

        //final ListView lv=(ListView) findViewById(R.id.lv);

       // Downloader d=new Downloader(ListeLivreActivity.this,urlAddress,lv);
        //d.execute();
   // }
//}
