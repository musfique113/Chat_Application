package com.labproject.chatapp.adapters;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.labproject.chatapp.databinding.ItemContainerReceivedMassageBinding;
import com.labproject.chatapp.databinding.ItemContainerSentMassageBinding;
import com.labproject.chatapp.models.ChatMassage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ChatMassage> chatMassage;
    private Bitmap receiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT =1;
    public static final int VIEW_TYPE_RECEIVED=2;

    public void setReceiverProfileImage(Bitmap bitmap){
        receiverProfileImage = bitmap;
    }


    public ChatAdapter(List<ChatMassage> chatMassage, Bitmap receiverProfileImage, String senderId) {
        this.chatMassage = chatMassage;
       this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_SENT){
            return new SentMassageViewerHolder(
                    ItemContainerSentMassageBinding.inflate(LayoutInflater.from(parent.getContext()),
                 parent,false   )
            );
        }else{
            return new ReceiveMassageViewHolder(
                    ItemContainerReceivedMassageBinding.inflate(LayoutInflater.from(parent.getContext()),
                            parent,false   )
            );
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
if (getItemViewType(position)==VIEW_TYPE_SENT){
    ((SentMassageViewerHolder)holder).setData(chatMassage.get(position));

}else{
    ((ReceiveMassageViewHolder)holder).setData(chatMassage.get(position), receiverProfileImage);
}
    }

    @Override
    public int getItemCount() {
        return chatMassage.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatMassage.get(position).senderId.equals(senderId)){
            return VIEW_TYPE_SENT;
        }else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    static class SentMassageViewerHolder extends RecyclerView.ViewHolder{
        private final ItemContainerSentMassageBinding binding;
        SentMassageViewerHolder(ItemContainerSentMassageBinding itemContainerSentMassageBinding){
            super(itemContainerSentMassageBinding.getRoot());
            binding=itemContainerSentMassageBinding;
        }

        void setData(ChatMassage chatMassage){
            binding.textMessage.setText(chatMassage.massage);
        binding.textDateTime.setText(chatMassage.dateTime);
        }
    }
    static class ReceiveMassageViewHolder extends RecyclerView.ViewHolder{
        private final ItemContainerReceivedMassageBinding binding;
        ReceiveMassageViewHolder(ItemContainerReceivedMassageBinding itemContainerReceivedMassageBinding){
            super (itemContainerReceivedMassageBinding.getRoot());
            binding= itemContainerReceivedMassageBinding;

        }
        void setData(ChatMassage chatMassage,Bitmap receiverProfileImage){
            binding.textMessage.setText(chatMassage.massage);
            binding.textDateTime.setText(chatMassage.dateTime);
            if (receiverProfileImage != null) {
                binding.imageProfile.setImageBitmap(receiverProfileImage);
            }
        }

    }
}
