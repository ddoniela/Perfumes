package me.dio.perfume.ui.items;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.perfume.domain.Items;

public class ItemsViewModel extends ViewModel {

    private final MutableLiveData<List<Items>> items;

    public ItemsViewModel() {
        this.items = new MutableLiveData<>();

        //TODO remover mock de perfumes
        List<Items> items = new ArrayList<>();
        items.add(new Items("212", "Top notes are Orange Blossom, Cactus Flower, Bergamot and Mandarin Orange; middle notes are Lily, Freesia, Gardenia, Jasmine, White Camelia, Lily-of-the-Valley, Rose and Peony; base notes are Musk and Sandalwood."));
        items.add(new Items("Calvin Klein Be", "It is a subtle blend of musk, lavender, peach, and citrus provided by the bergamot."));
        items.add(new Items("Carolina Herrera", "CH Carolina Herrera opens with notes of bergamot, grapefruit and lemon, leading into a rose, jasmine heart with orange blossom. A lingering praline and patchouli base with a hint of soft, woody undertones make for an unmistakably feminine scent."));

        this.items.setValue(items);

    }

    public LiveData<List<Items>> getItems() {
        return items;
    }
}