package sg.edu.np.practical_3_jw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button followbutton = findViewById(R.id.following);
        User user = initial();
        followstatus(user, followbutton);
        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.followed == false)
                {
                    user.followed = true;
                }
                else
                {
                    user.followed = false;
                }
                followstatus(user,followbutton);
            }
        });
        Intent receivingend = getIntent();
        Integer geneInt = receivingend.getIntExtra("GeneInt",0);
        TextView txt = findViewById(R.id.randtext);
        txt.setText(String.format("MAD %s",geneInt));
        Button msgbutton = findViewById(R.id.message);
        msgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newact = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(newact);
            }
        });

    }
    public User initial()
    {
        User initialization = new User("name","description",0,false);
        return initialization;
    }

    public void followstatus (User user, Button button) {
        TextView txt = button;
        if (user.followed == false) {
            txt.setText("Follow");
            toastMsg("Unfollowed!!");
        } else {
            txt.setText("Unfollow");
            toastMsg("Followed!!");
        }
    }
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }




}