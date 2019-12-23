package fr.pisano.warcraftvoice.ui.humains;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.pisano.warcraftvoice.R;

public class HumainsFragment extends Fragment {

    private HumainsViewModel humainsViewModel;
    private MediaPlayer mp = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        humainsViewModel =
                ViewModelProviders.of(this).get(HumainsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_humains, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        humainsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        final ImageView hp = root.findViewById(R.id.hp);
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playThatSound();
            }

            public void playThatSound() {
                if (mp != null) {
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getContext(), R.raw.jenepeuxrien);//on peut remplacer getContent() par getActivity()
                mp.start();
            }
        });
        return root;
    }
}