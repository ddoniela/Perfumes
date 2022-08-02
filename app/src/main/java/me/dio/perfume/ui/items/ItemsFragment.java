package me.dio.perfume.ui.items;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import me.dio.perfume.databinding.FragmentItemsBinding;
import me.dio.perfume.ui.adapter.ItemsAdapter;

public class ItemsFragment extends Fragment {

    private FragmentItemsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ItemsViewModel itemsViewModel =
                new ViewModelProvider(this).get(ItemsViewModel.class);

        binding = FragmentItemsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rvItems.setLayoutManager(new LinearLayoutManager(getContext()));

        final TextView textView = binding.textItems;
        itemsViewModel.getItems().observe(getViewLifecycleOwner(), items -> {
            binding.rvItems.setAdapter(new ItemsAdapter(items));

        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}