package sg.edu.np.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DBHandler db = new DBHandler(this);
        //db.deleteDatabase(this);

        /*for (int i = 1; i <= 20; i++)
        {
            User user = new User();
            Random randName = new Random();
            Random randDesc = new Random();
            boolean randFollowed = new Random().nextBoolean();

            String Nametext = String.valueOf(randName.nextInt());
            String Desctext = String.valueOf(randDesc.nextInt());

            user.setName("Name" + Nametext);
            user.setDescription("Description" + Desctext);
            user.setId(i);
            user.setFollowed(randFollowed);

            listUser.add(user);
            db.addUsers(user);
        }*/

        listUser = db.getUsers();
        RecyclerView rv = findViewById(R.id.rv);
        UserAdapter adapter = new UserAdapter(this, listUser);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        /*ImageView andriodBtn = findViewById(R.id.andriodBtn);
        andriodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile")
                        .setMessage("MADness");

                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Random rand = new Random();
                        int randNum = rand.nextInt();
                        Intent in = new Intent(ListActivity.this, MainActivity.class);
                        in.putExtra("Num",randNum);

                        startActivity(in);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();

                // Show the Alert Dialog box
                alertDialog.show();
            }
        });*/
    }
}