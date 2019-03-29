package gx.com.home;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Asus on 2019/3/29.
 */

public class FragmentTest extends Fragment {
    private TextView tx;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tablayout, container, false);
        tx = view.findViewById(R.id.testText);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void setTextView(String s){
        tx.setText(s);
    }
}
