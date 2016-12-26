import android.os.Bundle;
import android.widget.TextView;

import com.utrust.customer.base.BaseActivity;
import com.utrust.customer.splash.SplashContract;
import com.utrust.customer.splash.SplashPreseneter;

import butterknife.BindView;
#parse("File Header.java")
public class ${NAME} extends BaseActivity<SplashPreseneter> implements SplashContract.View {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        }}