package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.MovieAdapter;
import com.example.recyclerview.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class    MainActivity extends AppCompatActivity {
    MovieAdapter adapter;
    RecyclerView rv;
    List<MovieModel> listMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.profil){
            startActivity(new Intent(this, ProfilActivity.class));
        } else if (item.getItemId() == R.id.change) {
            startActivity(new Intent(this, ChangeActivity.class));
        }

        return true;
    }

    public void initRecyclerView(){
        adapter = new MovieAdapter(this);
        rv = findViewById(R.id.rv_movie);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();

        adapter.setOnItemClickListener(new
MovieAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(MainActivity.this,
             DetailMovieActivity.class);
                i.putExtra("judul",listMovie.get(position).getJudul());
                i.putExtra("tahun",listMovie.get(position).getTahun());
                i.putExtra("penulis",listMovie.get(position).getPenulis());
                i.putExtra("deskripsi",listMovie.get(position).getDesCription());
                startActivity(i);
            }
        });

        loadItem();
    }

    public void loadItem(){
        listMovie.add(new MovieModel("Judul : One Piece", "Tahun : 1999", "Penulis : Oda",
                "Bercerita tetang seorang laki-laki bernama Monkey D. Luffy,yang menentang arti dari gelar bajak laut. Daripada kesan nama besar, kejahatan, kekerasan, dia lebih terlihat seperti bajak laut rendahan yang suka bersenang-senang, alasan Luffy menjadi bajak laut adalah tekadnya untuk berpetualang di lautan yang menyenangkan dan bertemu orang-orang baru dan menarik, serta bersama mencari One Piece. Mengikuti jejak pahlawan masa kecilnya, Luffy dan krunya mengarungi Grand Line, melalui petualangan gila, misteri gelap dan memerangi musuh yang kuat, semua itu dilakukan untuk mendapatkan One Piece.,\n"
        ));
        listMovie.add(new MovieModel("Judul :Naruto", "Tahun : 2002", "Penulis : Masashi",
                "Naruto adalah sebuah serial manga karya Masashi Kishimoto yang diadaptasi menjadi serial anime. Manga Naruto bercerita seputar kehidupan tokoh utamanya, Naruto Uzumaki, seorang ninja yang hiperaktif, periang, dan ambisius yang ingin mewujudkan keinginannya untuk mendapatkan gelar Hokage, pemimpin dan ninja terkuat di desanya. Serial ini didasarkan pada komik one-shot oleh Kishimoto yang diterbitkan dalam edisi Akamaru Jump pada Agustus 1997.\n"));

        listMovie.add(new MovieModel("Judul : Bleach", "Tahun : 2005", "Penulis : Tite Kubo",
                "Ichigo Kurosaki adalah seorang siswa sekolah menengah biasa-sampai keluarganya diserang oleh Hollow, roh korup yang berusaha melahap jiwa manusia. Saat itulah ia bertemu dengan Soul Reaper bernama Rukia Kuchiki, yang terluka saat melindungi keluarga Ichigo dari penyerang. Untuk menyelamatkan keluarganya, Ichigo menerima tawaran Rukia untuk mengambil kekuatannya dan menjadi Soul Reaper sebagai hasilnya.\n" +
                        "Namun, karena Rukia tidak bisa mendapatkan kembali kekuatannya, Ichigo diberi tugas menakutkan untuk membungkam Hollows yang mengganggu kota mereka. Namun, dia tidak sendiri dalam pertarungannya, karena dia kemudian bergabung dengan teman-temannya - teman sekelas Orihime Inoue, Yasutora Sado, dan Uryuu Ishida - yang masing-masing memiliki kemampuan unik mereka sendiri. Saat Ichigo dan rekan-rekannya terbiasa dengan tugas baru mereka dan saling mendukung di dalam dan di luar medan perang, Soul Reaper muda segera mengetahui bahwa Hollows bukanlah satu-satunya ancaman nyata bagi dunia manusia." ));
        listMovie.add(new MovieModel("Judul : Black Clover", "Tahun : 2017", "Penulis : Kazuyuki Fudeyasu",
                "Asta dan Yuno ditinggalkan di gereja yang sama pada hari yang sama. Dibesarkan bersama sebagai anak-anak, mereka mengetahui tentang \"Raja Penyihir\" - sebuah gelar yang diberikan kepada penyihir terkuat di kerajaan - dan berjanji bahwa mereka akan bersaing satu sama lain untuk posisi Raja Penyihir berikutnya. Namun, saat mereka dewasa, perbedaan mencolok antara keduanya menjadi nyata. Sementara Yuno mampu menggunakan sihir dengan kekuatan dan kontrol yang luar biasa, Asta sama sekali tidak bisa menggunakan sihir dan dengan putus asa mencoba membangunkan kekuatannya dengan berlatih secara fisik. Ketika mereka mencapai usia 15 tahun, Yuno dianugerahi Grimoire yang spektakuler dengan semanggi empat daun, sementara Asta tidak menerima apapun. Namun, tak lama kemudian, Yuno diserang oleh seseorang bernama Lebuty, yang tujuan utamanya adalah untuk mendapatkan Grimoo dari Yuno. Asta mencoba untuk melawan Lebuty, tapi dia kalah bersaing. Meski tanpa harapan dan di ambang kekalahan, ia menemukan kekuatan untuk terus berlanjut saat ia mendengar suara Yuno. Melepaskan emosi batinnya dalam kemarahan, Asta menerima semanggi lima daun Grimoire, sebuah \"Clover Hitam\" yang memberinya cukup kekuatan untuk mengalahkan Lebuty. Beberapa hari kemudian, kedua teman itu menuju ke dunia, keduanya mencari tujuan yang sama-untuk menjadi Raja Penyihir."));

        adapter.addAll(listMovie);
    }
}