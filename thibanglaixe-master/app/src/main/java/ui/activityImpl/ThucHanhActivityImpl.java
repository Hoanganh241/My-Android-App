package ui.activityImpl;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.myapplication.R;

public class ThucHanhActivityImpl extends AppCompatActivity  {

    TextView txtKN1,txtKN2,txtKN3,txtKN4,txtKN5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.thuc_hanh_activity);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Giới thiệu thi thực hành");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.toolbar2)));
        loadTabs();

//        txtKN1=findViewById(R.id.txtKN1);
//        txtKN2=findViewById(R.id.txtKN2);
//        txtKN3=findViewById(R.id.txtKN3);
//        txtKN4=findViewById(R.id.txtKN4);
//        txtKN5=findViewById(R.id.txtKN5);
//
//
//        txtKN1.setText("1. Đầu tiên bạn dừng xe trước vạch xuất phát và chờ hiệu lệnh bắt đầu bài thi. Khi vào trong sa hình vòng số 8 thì lưu ý điều khiển bánh trước chạy áp sát mép ngoài của vòng số 8 khoảng 5 đến 10cm để đảm bảo cho bánh sau được nằm gọn trong vòng số 8. Làm như vậy khi ôm cua bánh xe không bị vượt ra ngoài vòng.");
//        txtKN2.setText("2. Khi ôm cua hãy giữ vững tay lái, loạng choạng hay lắc lư tay rất dễ dẫ đến mất điều khiển xe và cán vạch.");
//        txtKN3.setText("3. Giữa số 2 và số 3, số nào ổn định nhất thì bạn đi. Đừng đi số 1 vì máy sẽ rất bốc nếu lỡ tay quá ga xe sẽ lao ngay ra khỏi vòng. Với số 4 máy quá yếu nên khi đi qua khúc cua, xe không đủ tốc độ làm chết máy và bạn sẽ phải chống chân.");
//        txtKN4.setText("4. Hãy chú ý để chạy đúng hướng vòng số 8 và chạy đủ 1,5 vòng. Có rất nhiều trường hợp bị trượt do chỉ chạy nửa vòng đầu rồi sau đó chạy nhầm hướng. Hoặc chạy chưa đủ vòng mà đã vào lối ra cho bài thi số 2.");
//        txtKN5.setText("5. Nếu các bạn không tập trung được để nhìn hình thì hãy nhớ trong đầu là khi đến cửa thi vòng số 8 thì chạy theo chiều sau: rẽ phải -> rẽ trái -> rẽ phải -> rẽ trái -> rẽ phải. Chạy đủ 5 bước này là kết thúc bài thi vòng số 8 với đủ só lượng 1,5 vòng. Ở lần rẽ phải cuối cùng, bạn sẽ đến bài thi số 2. ");


    }
    public void loadTabs()
    {
        //Lấy Tabhost id ra trước (cái này của built - in android
        final TabHost tab=(TabHost) findViewById(android.R.id.tabhost);
        //gọi lệnh setup
        tab.setup();
        TabHost.TabSpec spec;
        //Tạo tab1
        spec=tab.newTabSpec("t1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Luật thi");
        tab.addTab(spec);
        //Tạo tab2
        spec=tab.newTabSpec("t2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Kinh nghiệm thi");
        tab.addTab(spec);
        //Thiết lập tab mặc định được chọn ban đầu là tab 0
        tab.setCurrentTab(0);
        //Ở đây Tôi để sự kiện này để các bạn tùy xử lý
        //Ví dụ tab1 chưa nhập thông tin xong mà lại qua tab 2 thì báo...
//        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
////            public void onTabChanged(String arg0) {
////                String s="Tab tag ="+arg0 +"; index ="+
////                        tab.getCurrentTab();
////                Toast.makeText(getApplicationContext(),
////                        s, Toast.LENGTH_LONG).show();}
//        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
