package me.dio.perfume.data.remote;

import java.util.List;

import me.dio.perfume.domain.Items;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PerfumeApi {

    @GET("perfumes.json")
    Call<List<Items>> getItems();
}
