/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.InsectIdentification.fragment.trending;
import android.content.ContentResolver;
import android.content.Context;
import com.xuexiang.InsectIdentification.R;
import com.xuexiang.InsectIdentification.core.BaseFragment;
import com.xuexiang.InsectIdentification.fragment.other.AboutFragment;
import com.xuexiang.InsectIdentification.fragment.other.SettingsFragment;
import com.xuexiang.InsectIdentification.utils.XToastUtils;
import com.xuexiang.xaop.annotation.SingleClick;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.tencent.yolov5ncnn.YoloV5Ncnn;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.ExifInterface;

import com.xuexiang.xui.widget.imageview.RadiusImageView;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import butterknife.BindView;



/**
 * @author xuexiang
 * @since 2019-10-30 00:19
 */
@Page(anim = CoreAnim.none)
public class TrendingFragment extends BaseFragment implements SuperTextView.OnSuperTextViewClickListener {

    @BindView(R.id.imageView)
    RadiusImageView imageView;
    @BindView(R.id.btn_img)
    SuperTextView btn_img;
    @BindView(R.id.btn_cpu)
    SuperTextView btn_cpu;
    @BindView(R.id.btn_gpu)
    SuperTextView btn_gpu;

    private static final int SELECT_IMAGE = 1;

    private Bitmap bitmap = null;
    private Bitmap yourSelectedImage = null;

    private YoloV5Ncnn yolov5ncnn = new YoloV5Ncnn();

    public HashMap map;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        boolean ret_init = yolov5ncnn.Init(getResources().getAssets());
        if (!ret_init)
        {
            Log.e("MainActivity", "yolov5ncnn Init failed");
        }
        map=new HashMap(15);

        map.put("C15408105005","麻皮蝽");
        map.put("C15331005010","草履蚧");
        map.put("C22301090015","褐边绿刺蛾");
        map.put("C22301070005","黄刺蛾");
        map.put("C22345105005","美国白蛾");
        map.put("C22345170045","人纹污灯蛾");
        map.put("C22359050005","丝带凤蝶");
        map.put("C22341165010","霜天蛾");
        map.put("C22342015005","杨扇舟蛾");
        map.put("C22342135005","杨小舟蛾");
        map.put("C21301095005","日本脊吉丁");
        map.put("C21701080005","桑天牛");
        map.put("C21701445005","松墨天牛");
        map.put("C21701065010","星天牛");
        map.put("C21703280010","柳蓝叶甲");



    }


    /**
     * @return 返回为 null意为不需要导航栏
     */
    @Override
    protected TitleBar initTitle() {
        return null;
    }

    /**
     * 布局的资源id
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_trending;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initViews() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && null != data) {
            Uri selectedImage = data.getData();

            try
            {
                if (requestCode == SELECT_IMAGE) {
                    bitmap = decodeUri(selectedImage);

                    yourSelectedImage = bitmap.copy(Bitmap.Config.ARGB_8888, true);

                    imageView.setImageBitmap(bitmap);
                }
            }
            catch (FileNotFoundException e)
            {
                Log.e("TrendingFragment", "FileNotFoundException");
                return;
            }
        }


    }

    private void showObjects(YoloV5Ncnn.Obj[] objects)
    {
        if (objects == null)
        {
            XToastUtils.toast("objects是空的");
            imageView.setImageBitmap(bitmap);
            return;
        }

        // draw objects on bitmap
        Bitmap rgba = bitmap.copy(Bitmap.Config.ARGB_8888, true);

        final int[] colors = new int[] {
                Color.rgb( 54,  67, 244),
                Color.rgb( 99,  30, 233),
                Color.rgb(176,  39, 156),
                Color.rgb(183,  58, 103),
                Color.rgb(181,  81,  63),
                Color.rgb(243, 150,  33),
                Color.rgb(244, 169,   3),
                Color.rgb(212, 188,   0),
                Color.rgb(136, 150,   0),
                Color.rgb( 80, 175,  76),
                Color.rgb( 74, 195, 139),
                Color.rgb( 57, 220, 205),
                Color.rgb( 59, 235, 255),
                Color.rgb(  7, 193, 255),
                Color.rgb(  0, 152, 255),
                Color.rgb( 34,  87, 255),
                Color.rgb( 72,  85, 121),
                Color.rgb(158, 158, 158),
                Color.rgb(139, 125,  96)
        };

        Canvas canvas = new Canvas(rgba);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);

        Paint textbgpaint = new Paint();
        textbgpaint.setColor(Color.WHITE);
        textbgpaint.setStyle(Paint.Style.FILL);

        Paint textpaint = new Paint();
        textpaint.setColor(Color.BLACK);
        textpaint.setTextSize(26);
        textpaint.setTextAlign(Paint.Align.LEFT);

        for (int i = 0; i < objects.length; i++)
        {
            paint.setColor(colors[i % 19]);

            canvas.drawRect(objects[i].x, objects[i].y, objects[i].x + objects[i].w, objects[i].y + objects[i].h, paint);

            // draw filled text inside image
            {
                String text = objects[i].label + " = " + String.format("%.1f", objects[i].prob * 100) + "%";

                float text_width = textpaint.measureText(text);
                float text_height = - textpaint.ascent() + textpaint.descent();

                float x = objects[i].x;
                float y = objects[i].y - text_height;
                if (y < 0)
                    y = 0;
                if (x + text_width > rgba.getWidth())
                    x = rgba.getWidth() - text_width;

                canvas.drawRect(x, y, x + text_width, y + text_height, textbgpaint);

                canvas.drawText(text, x, y - textpaint.ascent(), textpaint);
            }
        }
        imageView.setImageBitmap(rgba);

    }


    private Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException
    {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(selectedImage), null, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 640;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        Bitmap bitmap = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(selectedImage), null, o2);

        // Rotate according to EXIF
        int rotate = 0;
        try
        {
            ExifInterface exif = new ExifInterface(getContext().getContentResolver().openInputStream(selectedImage));
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }
        }
        catch (IOException e)
        {
            Log.e("TrendingFragment", "ExifInterface IOException");
        }

        Matrix matrix = new Matrix();
        matrix.postRotate(rotate);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override
    protected void initListeners() {
        btn_img.setOnSuperTextViewClickListener(this);
        btn_cpu.setOnSuperTextViewClickListener(this);
        btn_gpu.setOnSuperTextViewClickListener(this);

    }
    @SingleClick
    @Override
    public void onClick(SuperTextView view) {
        switch(view.getId()) {
            case R.id.btn_img:
                    {
                        XToastUtils.toast("请选择图像");
                        Intent i = new Intent(Intent.ACTION_PICK);
                        i.setType("image/*");
                        startActivityForResult(i, SELECT_IMAGE);
                        break;
                    }
            case R.id.btn_cpu:
                    {
                        if (yourSelectedImage == null) {
                            XToastUtils.toast("输入了空的图像");
                            return;
                        }
                        YoloV5Ncnn.Obj[] objects = yolov5ncnn.Detect(yourSelectedImage, false);
                        showObjects(objects);

                        if(objects==null||objects.length<=0){
                            XToastUtils.toast("图中包含【"+objects.length+"】个昆虫， \n 请重新输入其他图像");
                        }
                        else {
                            XToastUtils.toast("图中包含【" + objects.length + "】个昆虫， \n 类别为【" + map.get(objects[0].label) + "】, \n 识别准确率为【" + String.format("%.1f", objects[0].prob * 100) + "%】");
                        }
                        break;
                    }
            case R.id.btn_gpu:
                    {
                        XToastUtils.toast("btn_gpu！");
                        if (yourSelectedImage == null) {
                            XToastUtils.toast("输入了空的图像");
                            return;
                        }
                        YoloV5Ncnn.Obj[] objects = yolov5ncnn.Detect(yourSelectedImage, true);
                        showObjects(objects);

                        if(objects==null||objects.length<=0){
                            XToastUtils.toast("图中包含【"+objects.length+"】个昆虫， \n 请重新输入其他图像");
                        }
                        else {
                            XToastUtils.toast("图中包含【" + objects.length + "】个昆虫， \n 类别为【" + map.get(objects[0].label) + "】, \n 识别准确率为【" + String.format("%.1f", objects[0].prob * 100) + "%】");
                        }
                        break;
                    }
            default:
                break;
        }
    }
}
