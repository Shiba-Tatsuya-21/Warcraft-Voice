package fr.pisano.warcraftvoice.ui.orcs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrcsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrcsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}