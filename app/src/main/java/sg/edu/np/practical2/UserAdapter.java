package sg.edu.np.practical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> listUser;
    Context context;

    public UserAdapter(Context c, ArrayList<User> List) {
        context = c;
        listUser = List;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userview,parent,false);

        View item = null;
        if(viewType == 0)
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.userwith7,parent,false);
        }
        else
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewusers,parent,false);
        }
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listUser.get(position);
        holder.name.setText(user.getName() );
        holder.description.setText(user.getDescription());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Profile")
                    .setMessage(user.name)
                    .setCancelable(false)

                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })

                    .setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context, MainActivity.class);
                            Bundle extras = new Bundle();
                            extras.putString("Name", user.getName());
                            extras.putString("Description", user.getDescription());
                            intent.putExtras(extras);
                            context.startActivity(intent);
                        }
                    });

                //To show the alert dialog
                AlertDialog alertDialog = alert.create();
                alertDialog.show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    @Override
    public int getItemViewType(int position) {
        String name = listUser.get(position).getName();
        int id = Integer.parseInt(name.substring(name.length() - 1));
        if(id == 7)
        {
            return 0;
        }
        return 1;
    }

}