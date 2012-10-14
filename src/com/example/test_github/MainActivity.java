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
        
        
        final TextView textView = (TextView)findViewById(R.id.textView);
        textView.startAnimation(ani_start);
        textView.postDelayed(new Runnable() {
            
            public void run() {
            	textView.startAnimation(ani_loop);
            }
        }, 1000);
        
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    


	static int pivotX;
	static int pivotY;
	static Camera camera =  new Camera();
	
	
    Animation ani_start = new Animation()
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
    	camera.rotateX(interpolatedTime*-60);
    	camera.getMatrix(matrix);
    	
		matrix.preTranslate(-pivotX, -pivotY);
    	matrix.postTranslate(pivotX, pivotY);
    	camera.restore();
    }
    
    };
	
    Animation ani_loop = new Animation()
    {



	@Override
    public void initialize(int width, int height, int parentWidth, int parentHeight){
    	super.initialize(width, height, parentWidth, parentHeight);
    	pivotX=width/2;
    	pivotX=width/2;
    	setDuration(1000L);
    	setFillAfter(true);
    	setRepeatMode(REVERSE);
    	setRepeatCount(INFINITE);
    	
    	
    }
    
    
    protected void applyTransformation (float interpolatedTime, Transformation t){
    	Matrix matrix = t.getMatrix();
    	camera.save();
    	float rotazione = interpolatedTime-0.5f;
    	camera.rotateX( (rotazione*120));
    	camera.getMatrix(matrix);
    	
		matrix.preTranslate(-pivotX, -pivotY);
    	matrix.postTranslate(pivotX, pivotY);
    	camera.restore();
    }
    
    };
    
   
}
