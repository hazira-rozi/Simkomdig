package com.hazira.simkomdig;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity{
//        implements NavigationView.OnNavigationItemSelectedListener

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomHomeNav = findViewById(R.id.bottom_home);
        bottomHomeNav.setOnNavigationItemSelectedListener(botNavListener);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_home);

        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener botNavListener =
            item -> {
                Fragment selectedFragment = null;
                int title = R.string.titleHome;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        title = R.string.titleHome;
                        break;
                    case R.id.about:
                        selectedFragment = new AboutFragment();
                        title = R.string.titleAbout;
                        break;
                    case R.id.help:
                        selectedFragment = new HelpFragment();
                        title = R.string.titleHelp;
                        break;
                    case R.id.bottomvideo:
                        selectedFragment = new VideoListFragment();
                        title = R.string.menuVideo;
                        break;
                    case R.id.evaluasi:
                        selectedFragment = new M1EvaluasiFragment();
                        title = R.string.titleMateriEvaluas;
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }

                return true;
            };


//    public void selectItem(int position) {
//        Intent intent = null;
//
//        switch (position) {
//            case R.id.nav_home:
//                intent = new Intent(this, MainActivity.class);
//                break;
//
//            case R.id.nav_materi_1:
//                intent = new Intent(this, M1Activity.class);
//                break;
//
//            case R.id.nav_materi_2:
//                intent = new Intent(this, M2Activity.class);
//                break;
//
//            case R.id.nav_materi_3:
//                intent = new Intent(this, M3Activity.class);
//                break;
//
////            case R.id.nav_materi_3:
////                intent = new Intent(this, M3Activity.class);
////                break;
//
////            case R.id.nav_chat:
//////                InterfaceManager.shared().a.startLoginActivity(this, false);
////                intent = getPackageManager().getLaunchIntentForPackage("com.hazira.chatsiskomdig");
////
//////
////                break;
//
//            default:
//                intent = new Intent(this, MainActivity.class);
//                break;
//
//        }
//
//        startActivity(intent);
//    }
//
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int position = item.getItemId();
//        selectItem(position);
//        drawer.closeDrawer(GravityCompat.START);
//
//        return true;
//    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //PDF Code Here (call the pdfContent)
    public void openMateri1(View view) {
        String materi = "bab1.pdf";
        String title = "Pendahuluan";
        String vid = "2TSirk50mqo";
        switch (view.getId()) {
            case R.id.buttonsimdig:
                materi = "bab1.pdf";
                title = "Pendahuluan";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttoninfo:
                materi = "bab2.pdf";
                title = "Perolehan Informasi";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonmind:
                materi = "mind.pdf";
                title = "Peta Minda";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttoninfo2:
                materi = "bab3.pdf";
                title = "Pengelolaan Informasi";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonparagraf:
                materi = "paragraph.pdf";
                title = "Pengenalan Paragraf";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonword:
                materi = "word.pdf";
                title = "Pengolah Kata";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonexcel:
                materi = "excel.pdf";
                title = "Pengolah Angka";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonpowerpoint:
                materi = "ppt.pdf";
                title = "Aplikasi Presentasi";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonpresentasi:
                materi = "teknikppt.pdf";
                title = "Teknik Presentasi";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonebook:
                materi = "ebook.pdf";
                title = "Naskah Digital";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonkikd:
                materi = "kikd.pdf";
                title = "KI - KD ";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonsilabus:
                materi = "silabus.pdf";
                title = "Silabus";
                vid = "2TSirk50mqo";
                break;
            case R.id.buttonrpp:
                materi = "rpp.pdf";
                title = "Rencana Pembelajaran";
                vid = "2TSirk50mqo";
                break;
        }
        Intent intentMateri_1 = new Intent(this, M1Content.class);
        intentMateri_1.putExtra("file", materi).putExtra("headTitle", title).putExtra("videoLink", vid);
        startActivity(intentMateri_1);
    }

    //End of PDF Code

    public void PlayYTVideo(View view) {

        String vid = "ji4DHA2RUFw";
        String vidTitle = "Daftar Isi Otomatis";

        switch (view.getId()) {
            case R.id.buttonVideoTOC:
                vid = "ji4DHA2RUFw";
                vidTitle = "Daftar Isi Otomatis";
                break;
            case R.id.buttonVideoChart:
                vid = "bIgHRbZDCBI";
                vidTitle = "Membuat Diagram dengan Excel";
                break;
        }

        Intent intentVideo = new Intent(this, YoutubePlayerActivity.class);
        intentVideo.putExtra("videoURI", vid).putExtra("videoTitle", vidTitle);
        startActivity(intentVideo);
    }


    //
    public void evaluasi(View viewQuiz) {
        switch (viewQuiz.getId()) {
            case R.id.button_evaluasi_word:
                Intent quizIntent_q1_1 = new Intent(this, Quiz1Activity.class);
                startActivity(quizIntent_q1_1);
                break;
            case R.id.button_evaluasi_excel:
                Intent quizIntent_q2_1 = new Intent(this, Quiz2Activity.class);
                startActivity(quizIntent_q2_1);
                break;
        }
    }
}

