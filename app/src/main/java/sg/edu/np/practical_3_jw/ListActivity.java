package sg.edu.np.practical_3_jw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView mid = (ImageView) findViewById(R.id.mid);
        mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = Alertdialog();
                alert.show();
            }
        });
    }
    public AlertDialog Alertdialog(){

        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(ListActivity.this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Random random = new Random();
                Integer geneInt = Math.abs(random.nextInt());
                Intent act = new Intent(ListActivity.this,MainActivity.class);
                act.putExtra("GeneInt",geneInt);
                startActivity(act);
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
