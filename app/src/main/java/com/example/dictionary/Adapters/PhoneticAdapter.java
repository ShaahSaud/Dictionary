package com.example.dictionary.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.R;
import com.example.dictionary.models.phonetics;
import com.example.dictionary.viewHolders.PhoneticViewHolder;

public class PhoneticAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<phonetics> phonetics;

    public PhoneticAdapter(Context context, List<com.example.dictionary.models.phonetics> phonetics) {
        this.context = context;
        this.phonetics = phonetics;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetics_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvPhonetic.setText(phonetics.get(position).getText());
        holder.btn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = new MediaPlayer();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    player.setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                            .build());
                } else {
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                }
                try {
                    player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    player.setDataSource(phonetics.get(position).getAudio());
                    player.prepareAsync();
                } catch (Exception e) {
                    e.printStackTrace();

                    Toast.makeText(context, "Couldn't Play audio ☹", Toast.LENGTH_SHORT).show();
                }




















//                try {
//                    Uri uri = Uri.parse("http:"+phonetics.get(position).getAudio());
//                    player = new MediaPlayer();
//                    player.setAudioAttributes(new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build());
//                    player.setDataSource(context, uri);
//                    player.prepare();
//                    player.start();

                    //.setAudioAttributes(
                    //            new AudioAttributes
                    //               .Builder()
                    //               .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    //               .build());
//                } catch(Exception e) {
//                    System.out.println(e.toString());
//                }

//                try {
//                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    player.setDataSource("https:"+phonetics.get(position).getAudio());
//                    Log.d("url: ", "https:"+phonetics.get(position).getAudio());
//                    player.prepare();
//                    player.start();
//                } catch (Exception e){
//                    e.printStackTrace();
//                    Toast.makeText(context, "Couldn't play audio", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phonetics.size();
    }
}
