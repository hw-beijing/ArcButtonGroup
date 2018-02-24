package com.hw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hw.arcbutton.HwArcButtonGroup;
import com.hw.arcbutton.HwArcDataTypeBean;
import com.hw.arcbutton.R;

import java.util.ArrayList;

/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：郝乐涛 on
 * 邮箱：364320703@qq.com
 */
public class MainActivity extends Activity implements HwArcButtonGroup.MPAddButtonItemClick {

    protected RelativeLayout rlMainRoot;
    private HwArcButtonGroup hwArcButtonGroup;
    private ArrayList<HwArcDataTypeBean> mpAddDataTypeBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        rlMainRoot = (RelativeLayout) findViewById(R.id.rl_main_root);
        hwArcButtonGroup = new HwArcButtonGroup(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        hwArcButtonGroup.setLayoutParams(params);
        rlMainRoot.addView(hwArcButtonGroup);

        hwArcButtonGroup.setImageIds(getAddDataTypes());
        hwArcButtonGroup.setBackgroundView(findViewById(R.id.rl_main));
        hwArcButtonGroup.setMpAddButtonItemClick(this);
    }


    protected ArrayList<HwArcDataTypeBean> getAddDataTypes() {
        String type_code = "类型";
        mpAddDataTypeBeans = new ArrayList<>();
        HwArcDataTypeBean mpAddDataTypeBean;
        mpAddDataTypeBean = new HwArcDataTypeBean();
        mpAddDataTypeBean.setType(type_code);
        mpAddDataTypeBean.setName("按钮1");
        mpAddDataTypeBean.setResId(R.drawable.mp_add_button_group_sport);
        mpAddDataTypeBeans.add(mpAddDataTypeBean);

        mpAddDataTypeBean = new HwArcDataTypeBean();
        mpAddDataTypeBean.setType(type_code);
        mpAddDataTypeBean.setName("按钮2");
        mpAddDataTypeBean.setResId(R.drawable.mp_add_button_group_gps);
        mpAddDataTypeBeans.add(mpAddDataTypeBean);

        mpAddDataTypeBean = new HwArcDataTypeBean();
        mpAddDataTypeBean.setType(type_code);
        mpAddDataTypeBean.setName("按钮3");
        mpAddDataTypeBean.setResId(R.drawable.mp_add_button_group_voice);
        mpAddDataTypeBeans.add(mpAddDataTypeBean);

        mpAddDataTypeBean = new HwArcDataTypeBean();
        mpAddDataTypeBean.setType(type_code);
        mpAddDataTypeBean.setName("按钮4");
        mpAddDataTypeBean.setResId(R.drawable.mp_add_button_group_manual);
        mpAddDataTypeBeans.add(mpAddDataTypeBean);

        return mpAddDataTypeBeans;
    }

    @Override
    public void onAddButtonItemClick(View v, int position) {
        Toast.makeText(getApplicationContext(),
                "position :" + position +
                        " name:" + mpAddDataTypeBeans.get(position).getName(), Toast.LENGTH_LONG).show();
    }
}
