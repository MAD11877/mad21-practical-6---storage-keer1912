package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView describe = findViewById(R.id.describe);
        Log.d("debug","create");

        User user = new User();
        user.name = "MAD";
        user.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
        user.id = 1;
        user.followed = false;

        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.describe);
        description.setText(user.description);

        Intent in = getIntent();
        //Log.i("ok", String.valueOf(in.getIntExtra("Num",1)));
        name.setText((in.getStringExtra("Name")));
        description.setText((in.getStringExtra("Description")));
        FollowClick(user);
    }

    public void FollowClick(User user){
        Button followBtn = findViewById(R.id.follow_btn);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!user.followed){ // If not followed , after i click Follow I am following
                    followBtn.setText("Unfollow"); // Thus text shows un-follow
                    user.followed = true;//Thus I am following

                    Toast toast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
                    // to show the toast
                    toast.show();
                }

                else{ // If I already following , After I click I will un-follow the user
                    followBtn.setText("Follow");//Thus ask to Follow
                    user.followed = false; //Thus setting boolean to false

                    Toast toast = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT);
                    // to show the toast
                    toast.show();
                }

            }
        });
        DBHandler db = new DBHandler(this);
        db.updateUser(user);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug","start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug","destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug","pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("debug","resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug","restart");
    }
}