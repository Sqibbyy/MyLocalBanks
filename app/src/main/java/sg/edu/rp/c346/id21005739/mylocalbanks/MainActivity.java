package sg.edu.rp.c346.id21005739.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvBank1;
    TextView tvBank2;
    TextView tvBank3;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBank1 = findViewById(R.id.textViewBank1);
        tvBank2 = findViewById(R.id.textViewBank2);
        tvBank3 = findViewById(R.id.textViewBank3);

        registerForContextMenu(tvBank1);
        registerForContextMenu(tvBank2);
        registerForContextMenu(tvBank3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvBank1.setText("DBS");
            tvBank2.setText("OCBC");
            tvBank3.setText("UOB");
            return true;
        } else if (id == R.id.italianSelection) {
            tvBank1.setText("星展银行");
            tvBank2.setText("华侨银行");
            tvBank3.setText("大华银行");
            return true;
        } else {
            tvBank1.setText("Error translation");
            tvBank2.setText("Error translation");
            tvBank3.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");

        if (v == tvBank1) {
            wordClicked = "DBS";
        } else if (v == tvBank2) {
            wordClicked = "OCBC";
        } else if (v == tvBank3) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
            else if (item.getItemId() == 2) {
                tvBank1.setTextColor(Color.parseColor("#FF0000"));

                return true;
            }


        }
        else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
            else if (item.getItemId() == 2) {
                tvBank2.setTextColor(Color.parseColor("#FF0000"));

                return true;
            }

        }
        else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            }
            else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
            else if (item.getItemId() == 2) {
                tvBank3.setTextColor(Color.parseColor("#FF0000"));

                return true;
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation

        }
        return true;
    }
}