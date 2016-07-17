package ma.nse.sliderapp.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ma.nse.sliderapp.R;

/**
 * Created by admin on 16/07/2016.
 */
public class NotificationHolder extends RecyclerView.ViewHolder {

    public ImageView imageViewRecipientThumbnail;
    public TextView textViewChatRecipient;
    public TextView textViewChatMessage;

    public NotificationHolder(View itemView) {
        super(itemView);
        imageViewRecipientThumbnail = (ImageView)itemView.findViewById(R.id.chat_thumbnail);
        textViewChatMessage = (TextView)itemView.findViewById(R.id.chat_message);
        textViewChatRecipient = (TextView)itemView.findViewById(R.id.chat_recipient);
    }
}