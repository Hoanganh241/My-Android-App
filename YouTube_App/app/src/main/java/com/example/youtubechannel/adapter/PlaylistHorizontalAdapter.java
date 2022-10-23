package com.example.youtubechannel.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubechannel.R;
import com.example.youtubechannel.adapter.base.BaseRecyclerViewAdapter;
import com.example.youtubechannel.adapter.base.Releasable;
import com.example.youtubechannel.constant.Constant;
import com.example.youtubechannel.constant.GlobalFuntion;
import com.example.youtubechannel.injection.ActivityContext;
import com.example.youtubechannel.models.Playlist;
import com.example.youtubechannel.ui.video_playlist.VideoPlaylistActivity;
import com.example.youtubechannel.utils.GlideUtils;
import com.example.youtubechannel.utils.StringUtil;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

public class PlaylistHorizontalAdapter extends RecyclerView.Adapter<PlaylistHorizontalAdapter.PlaylistHorizontalViewHolder>
        implements Releasable {

    private Context context;
    private ArrayList<Playlist> listPlaylist;

    @Inject
    public PlaylistHorizontalAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public PlaylistHorizontalViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return PlaylistHorizontalViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(PlaylistHorizontalViewHolder holder, int position) {
        holder.bindData(context, listPlaylist.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listPlaylist ? 0 : listPlaylist.size();
    }


    public void setListData(ArrayList<Playlist> list) {
        this.listPlaylist = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class PlaylistHorizontalViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Playlist> {

        @BindView(R.id.layout_item)
        LinearLayout layoutItem;

        @BindView(R.id.img_playlist)
        ImageView imgPlaylist;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_date)
        TextView tvDate;

        public PlaylistHorizontalViewHolder(View itemView) {
            super(itemView);
        }

        public static PlaylistHorizontalViewHolder create(ViewGroup parent) {
            return new PlaylistHorizontalViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_playlist_horizontal, parent, false));
        }

        @Override
        public void bindData(Context context, Playlist playlist, int position) {
            if (playlist != null) {
                GlideUtils.loadUrl(playlist.getSnippet().getThumbnail().getThumbnailHigh().getUrl(), imgPlaylist);
                tvTitle.setText(playlist.getSnippet().getTitle());

                String date = playlist.getSnippet().getPublishedAt();
                if (!StringUtil.isEmpty(date)) {
                    tvDate.setVisibility(View.VISIBLE);
                    String[] temp;
                    temp = date.split("T");
                    tvDate.setText(context.getString(R.string.label_published) + " " + temp[0]);
                } else {
                    tvDate.setVisibility(View.GONE);
                }

                layoutItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(Constant.KEY_PLAYLIST, playlist);
                        GlobalFuntion.startActivity(context, VideoPlaylistActivity.class, bundle);
                    }
                });
            }
        }
    }
}