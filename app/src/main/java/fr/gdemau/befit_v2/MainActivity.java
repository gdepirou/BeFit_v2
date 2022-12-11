package fr.gdemau.befit_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import fr.gdemau.befit_v2.Fragment.AttaqueFragment;
import fr.gdemau.befit_v2.Fragment.DefiFragment;
import fr.gdemau.befit_v2.Fragment.HistoFragment;
import fr.gdemau.befit_v2.Fragment.HomeFragment;
import fr.gdemau.befit_v2.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    ImageView histo,attaque,muscle,defi,profile;

    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HomeFragment()).commit();
    }

    protected void replaceFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();
    }

    public void switchHisto(View v){
        selectedFragment=new HistoFragment();
        replaceFragment();
    }
    public void switchAttaque(View v){
        selectedFragment=new AttaqueFragment();
        replaceFragment();
    }
    public void switchHome(View v){
        selectedFragment=new HomeFragment();
        replaceFragment();
    }
    public void switchDefi(View v){
        selectedFragment=new DefiFragment();
        replaceFragment();
    }
    public void switchProfile(View v){
        selectedFragment=new ProfileFragment();
        replaceFragment();
    }




}