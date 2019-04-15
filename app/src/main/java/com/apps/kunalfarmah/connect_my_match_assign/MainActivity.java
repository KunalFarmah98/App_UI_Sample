package com.apps.kunalfarmah.connect_my_match_assign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button upgrade;
    ImageView banner;
    BottomNavigationView mbottomNavigationView;

    public ArrayList<Integer> imglist = new ArrayList<>();
    public ArrayList<String> percentage = new ArrayList<>();
    public ArrayList<String> titlelist = new ArrayList<>();

    public ArrayList<Study> slist = new ArrayList<>();


    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upgrade = findViewById(R.id.upgradenow);
        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnavigation);

        // displaying Toasts right now.
        // different Fragments will open at each tab, I am using an activity for now
        mbottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                // the home fragment will open here, right now I am
                                // making the activity to be the home
                                Toast.makeText(getApplicationContext(), "This is Home Screen", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.navigation_tests:
                                // the test fragment will open here
                                Toast.makeText(getApplicationContext(), "Tests Appear here", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.navigation_analysis:
                                // the analysis fragment will open here
                                Toast.makeText(getApplicationContext(), "Performance is Analysed Here", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.navigation_doubts:
                                // the home doubts(chat like interface) will open here
                                Toast.makeText(getApplicationContext(), "Doubts Portal Opens Here", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.navigation_profile:
                                // the profile fragment will open here
                                Toast.makeText(getApplicationContext(), "Profile Appears Here", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });

         upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Payment Portal will open here", Toast.LENGTH_SHORT).show();
            }
        });

        rv = findViewById(R.id.subjects);

        banner = findViewById(R.id.banner);

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Banner Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        // right now hardcoding the values  :)

        imglist.add(R.drawable.mat);
        imglist.add(R.drawable.physics);
        imglist.add(R.drawable.chem);
        imglist.add(R.drawable.maths);

        titlelist.add("Mental Ability");
        titlelist.add("Physics");
        titlelist.add("Chemistry");
        titlelist.add("Mathematics");

        percentage.add("0%");
        percentage.add("0%");
        percentage.add("0.71%");
        percentage.add("0%");

        // adding values to the adapter

        for (int i = 0; i < imglist.size(); i++) {
            slist.add(new Study(imglist.get(i), titlelist.get(i), percentage.get(i)));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Handle navigation view item clicks here.
                int id = menuItem.getItemId();

                if (id == R.id.Help) {
                    Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.ContactUS) {
                    Toast.makeText(getApplicationContext(), "Contact: 9654211634", Toast.LENGTH_SHORT).show();
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        StudyAdapter mAdapter = new StudyAdapter(this, slist);
        mAdapter.notifyDataSetChanged();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_icons, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navigation_wallet) {
            Toast.makeText(this, "Available Wallet Balance is X Rs.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.navigation_trophy) {
            Toast.makeText(this, "Achievements Open Here", Toast.LENGTH_SHORT).show();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
