package me.dio.perfume.ui.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.dio.perfume.databinding.PerfumeitemsBinding;
import me.dio.perfume.domain.Items;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private List<Items> items;

    public ItemsAdapter(List<Items> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PerfumeitemsBinding binding = PerfumeitemsBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Items items = this.items.get(position);
        holder.binding.tvTitle.setText(items.getTitle());
        holder.binding.tvDescription.setText(items.getDescription());
        Picasso.get().load(items.getImage())
                .into(holder.binding.ivThumbnail);
        holder.binding.btOpenLink.setOnClickListener(view -> {
            String url = "http://www.example.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(items.getLink()));
            holder.itemView.getContext().startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private final PerfumeitemsBinding binding;

        public ViewHolder(PerfumeitemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
