package kr.hs.emirim.yejin.mirim_project_0728_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgName ={"문빈","차은우","송강","남주혁","로운","박서준","박보검","여진구","장기용"};
    ImageView[] imgv = new ImageView[imgName.length];
    int[] voteCount = new int[imgName.length];
    int[] imgId = {R.id.imgv01,R.id.imgv02,R.id.imgv03,R.id.imgv04,R.id.imgv05,R.id.imgv06,R.id.imgv07,R.id.imgv08,R.id.imgv09};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("선호하는 연예인 투표");
        Button btnFinish = findViewById(R.id.btn_vote_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity2.class);
                intent.putExtra("imgName",imgName);
                intent.putExtra("voteCount",voteCount);
            }
        });

        for(int i=0; i<voteCount.length; i++)
            voteCount[i] = 0;
        for(int i = 0; i<imgv.length; i++){
            final int index;
            index = i;
            imgv[index] = findViewById(imgId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+":총"+voteCount[index]+"표" +Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}