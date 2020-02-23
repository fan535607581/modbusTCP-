package com.AppyKeepScreenOn;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;

@DesignerComponent(
    version = 1,
    description = "AppyKeepScreenOn Tool to keep screen on and turn off again ",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "https://static.wixstatic.com/media/64f6cf_16f4423a8dc041a79605de03d7d81f84~mv2.png?  dn=appyico.png"
)

@SimpleObject(external = true)
public class AppyKeepScreenOn extends AndroidNonvisibleComponent implements Component
{
    public static final int VERSION = 1;
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "AppyKeepScreenOn";
    private final Activity activity;
    private boolean keepScreenOn = false;
    private String result;
    
    public AppyKeepScreenOn(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        this.context = container.$context();
        Log.d("AppyKeepScreenOn", "AppyKeepScreenOn Created");
        this.activity = container.$context();
    }
    
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Result() { return this.result;}

    @DesignerProperty(editorType = "boolean",defaultValue = "False")
	
    @SimpleProperty(description = "Check Enable to keep screen active and awake when App has focus. default is FALSE")
    public void KeepScreenOn(boolean enable)
    {
        if(this.keepScreenOn != enable)
	{
            this.keepScreenOn = enable;
            if(enable) {this.container.$form().getWindow().addFlags(128);}
	    else {this.container.$form().getWindow().clearFlags(128);}
        }
   }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean KeepScreenOn() {return this.keepScreenOn;}
}
