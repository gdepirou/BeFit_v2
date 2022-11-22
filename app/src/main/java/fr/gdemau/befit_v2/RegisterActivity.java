    package fr.gdemau.befit_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

    public class RegisterActivity extends AppCompatActivity {

    EditText email,username,password;
    Button register;

    FirebaseAuth auth;
    DatabaseReference reference;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);

        auth= FirebaseAuth.getInstance();



    }

    public void onRegister(View v){
        pd = new ProgressDialog(RegisterActivity.this);
        pd.setMessage("Merci de patienter...");
        pd.show();

        String str_email=email.getText().toString();
        String str_username=username.getText().toString();
        String str_password=password.getText().toString();

        if(TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_username) || TextUtils.isEmpty(str_password)){
            Toast.makeText(RegisterActivity.this,"Merci de remplir tout les champs", Toast.LENGTH_SHORT).show();
        }else if(str_password.length()<6){
            Toast.makeText(RegisterActivity.this,"Le mot de passe doit contenir au moins 6 caractères", Toast.LENGTH_SHORT).show();
        }else{
            registerFirebase(str_email,str_username,str_password);
        }


    }

    private void registerFirebase(String email, String username, String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    String userid = firebaseUser.getUid();

                    reference= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);

                    HashMap<String,Object> hashMap = new HashMap<>();
                    hashMap.put("id",userid);
                    hashMap.put("username",username.toLowerCase());
                    hashMap.put("id",userid);
                    hashMap.put("bio","");
                    hashMap.put("image","");

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                pd.dismiss();
                                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });

                } else{
                    pd.dismiss();
                    Toast.makeText(RegisterActivity.this,"You can't register with this email or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}