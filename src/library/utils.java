package library;



import trumplab.teacherapp.R;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class utils extends ActionBarActivity{
	public static Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
		  // TODO Auto-generated method stub
		  int targetWidth = scaleBitmapImage.getHeight();
		  int targetHeight = scaleBitmapImage.getWidth();
		  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, 
		                            targetHeight,Bitmap.Config.ARGB_8888);
		  
		                Canvas canvas = new Canvas(targetBitmap);
		  Path path = new Path();
		  path.addCircle(((float) targetWidth - 1) / 2,
		  ((float) targetHeight - 1) / 2,
		  (Math.min(((float) targetWidth), 
		                ((float) targetHeight)) / 2),
		          Path.Direction.CCW);
		  
		                canvas.clipPath(path);
		  Bitmap sourceBitmap = scaleBitmapImage;
		  canvas.drawBitmap(sourceBitmap, 
		                                new Rect(0, 0, sourceBitmap.getWidth(),
		    sourceBitmap.getHeight()), 
		                                new Rect(0, 0, targetWidth,
		    targetHeight), null);
		  return targetBitmap;
		 }
	
	public static void ls(String str)
	{
		System.out.println(str);
	}
	
	
	public void setFont(TextView textView) {
        Typeface tf = Typeface.createFromAsset(textView.getContext()
                .getAssets(), textView.getContext().getString(R.string.fontname));

        textView.setTypeface(tf);

    }
	
	
	
}
