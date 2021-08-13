package sg.edu.np.practical2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView name;
    TextView description;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView);
        description = itemView.findViewById(R.id.textView2);
        img = itemView.findViewById(R.id.profpic);
    }
}

