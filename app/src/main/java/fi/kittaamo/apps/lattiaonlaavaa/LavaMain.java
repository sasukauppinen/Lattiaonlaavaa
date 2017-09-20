package fi.kittaamo.apps.lattiaonlaavaa;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import java.util.Timer;
import java.util.TimerTask;

public class LavaMain extends AppCompatActivity {

    private TextView tvMin;
    private TextView tvMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lava_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button startBtn = (Button)findViewById(R.id.btnStart);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCountdown();
            }
        });

        tvMin = (TextView) findViewById(R.id.textMin1);
        tvMax = (TextView) findViewById(R.id.textMax1);

// get seekbar from view
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);

// get min and max text view

// set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });
    }

    private void startCountdown() {
        int min = Integer.parseInt(tvMin.getText().toString());
        int max = Integer.parseInt(tvMax.getText().toString());
        final TimeFrameRandomizer rndTime = new TimeFrameRandomizer(min, max);
        Timer tmr = new Timer("Laava-ajastin");
        tmr.schedule(
        new TimerTask() {
            @Override
            public void run() {
                createPlayer();
            }
        }, rndTime.GetNext());
    }

    private void createPlayer() {
        //int resID=getResources().getIdentifier( "lattiaonlaavaa.flac", "raw", getPackageName());
        MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.lattiaonlaavaa);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lava_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
