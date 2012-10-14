package com.example.test_github;

import android.app.Activity;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        TextView textView1 = (TextView)findViewById(R.id.textView);
        textView1.startAnimation(a);
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	static int pivotX;
	static int pivotY;
	static Camera camera =  new Camera();
	
	
    Animation a = new Animation()
    {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight){
    	super.initialize(width, height, parentWidth, parentHeight);
    	pivotX=width/2;
    	pivotX=width/2;
    	setDuration(1000L);
    	setFillAfter(true);
    	
    }
    
    
    protected void applyTransformation (float interpolatedTime, Transformation t){
    	Matrix matrix = t.getMatrix();
    	camera.save();
    	camera.rotateX(interpolatedTime*60);
    	camera.getMatrix(matrix);
    	
		matrix.preTranslate(-pivotX, -pivotY);
    	matrix.postTranslate(pivotX, pivotY);
    	camera.restore();
    }
    
    };
}
