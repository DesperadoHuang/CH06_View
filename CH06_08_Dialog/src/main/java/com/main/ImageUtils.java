package com.main;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ki264 on 2016/9/26.
 */

public class ImageUtils {
    public Bitmap getImage(String url) {
        try {
            InputStream inputStream = (InputStream) this.fetch(url);
            Drawable drawable = Drawable.createFromStream(inputStream, "src");
            return ((BitmapDrawable) drawable).getBitmap();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object fetch(String address) throws MalformedURLException, IOException {
        URL url = new URL(address);
        Object content = url.getContent();
        return content;
    }
}
