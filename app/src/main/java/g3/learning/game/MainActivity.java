package g3.learning.game;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSound();

    }

    private void initSound() {

//        if () {
//            AudioAttributes attrs = new AudioAttributes.Builder()
//                    .setUsage(AudioAttributes.USAGE_GAME)
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .build();
//            soundPool = new SoundPool.Builder()
//                    .setMaxStreams(10)
//                    .setAudioAttributes(attrs)
//                    .build();
//        } else {
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
//        }

        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            //create our three fx in memory ready for use
            descriptor = assetManager.openFd("blip_select.wav");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("hit_hurt.wav");
            sample2 = soundPool.load(descriptor, 0);


            descriptor = assetManager.openFd("powerup.wav");
            sample3 = soundPool.load(descriptor, 0);

            Button button = findViewById(R.id.button);
            Button button2 = findViewById(R.id.button2);
            Button button3 = findViewById(R.id.button3);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sample1, 1, 1, 0, 0, 1);
                }
            });


            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sample2, 1, 1, 0, 0, 1);
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    soundPool.play(sample3, 1, 1, 0, 0, 1);
                }
            });



        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}