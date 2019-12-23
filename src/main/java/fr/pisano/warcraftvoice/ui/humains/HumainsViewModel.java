package fr.pisano.warcraftvoice.ui.humains;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HumainsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HumainsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}