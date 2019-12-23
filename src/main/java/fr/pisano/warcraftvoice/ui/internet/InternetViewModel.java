package fr.pisano.warcraftvoice.ui.internet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InternetViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InternetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}