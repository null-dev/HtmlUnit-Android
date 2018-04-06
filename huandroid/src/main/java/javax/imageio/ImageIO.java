package javax.imageio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import xyz.nulldev.huandroid.ShimUtil;

// From: https://github.com/qhm123/POI-Android
public class ImageIO {

	public static BufferedImage read(InputStream byteArrayInputStream) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        
        if (options.outWidth < 0 || options.outHeight < 0) {
        	return null;
        }
        
        // Calculate inSampleSize
		options.inSampleSize = ShimUtil.calculateInSampleSize(options, 480, 800);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        
        try {
			byteArrayInputStream.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bitmap bm = BitmapFactory.decodeStream(byteArrayInputStream, null, options);
		return bm == null ? null : new BufferedImage(bm);
	}
	
	public static boolean canDecode(InputStream byteArrayInputStream) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
        	return false;
        }
        
        return true;
	}

}