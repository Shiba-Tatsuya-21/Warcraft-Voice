package fr.pisano.warcraftvoice.ui.orcs;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fr.pisano.warcraftvoice.R;

public class OrcsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private OrcsViewModel orcsViewModel;
    private ListView lv;
    private MediaPlayer mp = null;
    String INSONS[] = {
            "Arrrgh", "Bien", "Ca y est", "Encore du travail", "Il essaie de", "Il est bon",
            "Il pourrait", "Je m'en charge", "Je ne peux rien", "Je peux essayer",
            "Ne m'invitez", "Ouaaahhh", "Oui Messire", "Oui Monseigneur", "Pardon",
            "Prêt à travailler", "Qui y'a t'il ?", "Si vous le voulez", "Travail terminé",
            "Très bien", "Votre prénom", "Vous n'avez"
    };
    Integer[] IDSONS = {
            R.raw.arrrgh, R.raw.bien, R.raw.cayestjesuis, R.raw.encoredutravail,
            R.raw.ilessaiedefairede, R.raw.ilestboncest, R.raw.ilpourrait,
            R.raw.jemencharge, R.raw.jenepeuxrien,
            R.raw.jepeuxessayer, R.raw.neminvitez, R.raw.ouah, R.raw.ouimessire,
            R.raw.ouimonseigneur, R.raw.pardon, R.raw.pretatravailler, R.raw.quiyatil,
            R.raw.sivouslevoulez, R.raw.travailtermine, R.raw.tresbien, R.raw.votreprenom,
            R.raw.vousnavez
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orcsViewModel =
                ViewModelProviders.of(this).get(OrcsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_orcs, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        orcsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        ArrayAdapter adtr = new ArrayAdapter<String>(getActivity(), R.layout.listview, INSONS);
        lv = (ListView) root.findViewById(R.id.list);
        lv.setAdapter(adtr);
        lv.setOnItemClickListener(this);
        return root;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (mp != null) {
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(getActivity(), IDSONS[position]);
        mp.start();
    }
}