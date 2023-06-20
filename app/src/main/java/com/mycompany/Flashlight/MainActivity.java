package com.mycompany.Flashlight;

import android.app.*;
import android.os.*;
import android.content.Context;
import android.view.View;
import android.widget.*;
import android.hardware.*;
import android.hardware.camera2.*;
public class MainActivity extends Activity 
{
	private ToggleButton toggleFlashLightOnOff;
    private CameraManager cameraManager;
    private String getCameraID;
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		setTitle("Flashlamp");
		toggleFlashLightOnOff=findViewById(R.id.toggle_flashlight);
		cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
		try{
			 getCameraID = cameraManager.getCameraIdList()[0];
		}
		catch(CameraAccessException e){
			e.printStackTrace();
		}
		}
		public void toggleFlashLight(View v){
			if(toggleFlashLightOnOff.isChecked()){
				try{
					cameraManager.setTorchMode(getCameraID, true);
					Toast.makeText(this,"Flashlight on",Toast.LENGTH_SHORT).show();
				}
				catch(CameraAccessException e){
					e.printStackTrace();
				}
			}else{
				try{
					cameraManager.setTorchMode(getCameraID, false);
					Toast.makeText(this,"Flashlight off",Toast.LENGTH_SHORT).show();
				}
				catch(CameraAccessException e){
					e.printStackTrace();
				}
			}
		}
}
