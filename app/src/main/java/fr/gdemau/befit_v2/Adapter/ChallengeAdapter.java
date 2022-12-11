package fr.gdemau.befit_v2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import fr.gdemau.befit_v2.Model.Challenge;
import fr.gdemau.befit_v2.Model.User;
import fr.gdemau.befit_v2.R;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder>{

    public Context mContext;
    public List<Challenge> mChallenge;

    private FirebaseUser firebaseUser;

    public ChallengeAdapter(Context mContext, List<Challenge> mChallenge) {
        this.mContext = mContext;
        this.mChallenge = mChallenge;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.model_challenge, viewGroup, false);

        return new ChallengeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Challenge challenge = mChallenge.get(position);

        publisherInfo(holder.image_challenge, holder.difficulty_challenge, holder.challenge_name, holder.challenge_number, position);

    }

    @Override
    public int getItemCount() {
        return mChallenge.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image_challenge,difficulty_challenge;
        public TextView challenge_name,challenge_number;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_challenge = itemView.findViewById(R.id.image_challenge);
            difficulty_challenge = itemView.findViewById(R.id.difficulty_challenge);
            challenge_name = itemView.findViewById(R.id.challenge_name);
            challenge_number = itemView.findViewById(R.id.challenge_number);
        }


    }

    private void publisherInfo(ImageView image_challenge,ImageView difficulty_challenge, TextView challenge_name, TextView challenge_number, Integer position){
        String userid = firebaseUser.getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User user = snapshot.getValue(User.class);

                //Glide.with(mContext).load(user.getImageUrl()).load
                challenge_name.setText(mChallenge.get(position).getChallenge_name());
                challenge_number.setText(mChallenge.get(position).getChallenge_number());
                image_challenge.setImageResource(mChallenge.get(position).getChallenge_image());
                difficulty_challenge.setImageResource(mChallenge.get(position).getChallenge_difficulty());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
