package ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import ui.activityImpl.ExamPrincipleActivityImpl;
import ui.activityImpl.FinesActivityImpl;
import ui.activityImpl.LyThuyetActivityImpl;
import ui.activityImpl.SaHinhActivityImpl;
import ui.activityImpl.TopicActivityImpl;
import ui.activityImpl.TrafficSignsActivityImpl;

public class MainActivity extends AppCompatActivity {

    private Button btnFines;
    private Button btnThiThu;
    private Button btnLyThuyet;
    private Button btnHocSaHinh;
    private Button btnHocBienBao;
    private Button btnThucHanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lý thuyết bằng lái xe A1");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.toolbar2)));
        btnFines = findViewById(R.id.btnFines);
       btnThiThu = findViewById(R.id.btnThithu);
        btnLyThuyet = findViewById(R.id.btnLythuyet);
        btnHocSaHinh = findViewById(R.id.btnHocSaHinh);

        //ô mới khởi tạo nhưng chưa new đối tượng thì nó đang ở trạng thái null
//        , cái /find này như kiểu new đối tượng ấy, bọn ô bc rồi nhỉ, cho xin ít kinh nghiệm đi :))
        //chắc do mạng
        btnHocBienBao = findViewById(R.id.btnHocBienBao);
        btnThucHanh = findViewById(R.id.btnThuchanh);

        //set intent
        btnFines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FinesActivityImpl.class);
                startActivity(intent);
            }
        });
        btnHocBienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TrafficSignsActivityImpl.class);
                startActivity(intent);
            }
        });
        btnThucHanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ExamPrincipleActivityImpl.class);
                startActivity(intent);
            }
        });
        btnHocSaHinh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SaHinhActivityImpl.class);
                startActivity(intent);
            }
        });
        btnLyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), LyThuyetActivityImpl.class);
                startActivity(intent);
            }
        });
        btnThiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TopicActivityImpl.class);
                startActivity(intent);
            }
        });

    }

    // test commit 4
}
