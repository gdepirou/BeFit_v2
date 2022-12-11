package fr.gdemau.befit_v2.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import fr.gdemau.befit_v2.Adapter.ChallengeAdapter;
import fr.gdemau.befit_v2.Model.Challenge;
import fr.gdemau.befit_v2.R;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChallengeAdapter challengeAdapter;
    private List<Challenge> challengeList;

    private List<String> followList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_challenges);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        challengeList = new ArrayList<>();
        challengeAdapter = new ChallengeAdapter(getContext(), challengeList);
        recyclerView.setAdapter(challengeAdapter);
        Challenge challenge= new Challenge("abdo", "x20",R.mipmap.pompes_foreground,R.mipmap.pompes_foreground);
        challengeList.add(challenge);
        Challenge challenge2= new Challenge("Pompes", "x10",R.mipmap.pompes_foreground,R.mipmap.pompes_foreground);
        challengeList.add(challenge2);
        return view;

    }
}