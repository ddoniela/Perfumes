package me.dio.perfume.ui.items;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.perfume.data.remote.PerfumeApi;
import me.dio.perfume.databinding.PerfumeitemsBinding;
import me.dio.perfume.domain.Items;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemsViewModel extends ViewModel {

    private final MutableLiveData<List<Items>> items = new MutableLiveData<>();
    private final PerfumeApi api;

    public ItemsViewModel() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ddoniela.github.io/Perfumes-API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(PerfumeApi.class);
        this.findItems();
    }

    private void findItems() {
        api.getItems().enqueue(new Callback<List<Items>>() {
            @Override
            public void onResponse(Call<List<Items>> call, Response<List<Items>> response) {
                if (response.isSuccessful()){
                    items.setValue(response.body());
                } else {
                    //TODO pensar em estratégia de erros.
                }
            }

            @Override
            public void onFailure(Call<List<Items>> call, Throwable t) {
                //TODO pensar em estratégia de erros.

            }
        });
    }

    public LiveData<List<Items>> getItems() {
        return items;
    }
}