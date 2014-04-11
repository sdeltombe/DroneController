package DroneController.pkg;

import dronecontrollerlib.pkg.DCManager;
import DroneController.pkg.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import dronecontrollerlibandroid.pkg.*;

///test hyuffuyf

public class MainActivity extends Activity implements CustomEventActivity
{
   
    private SPListener myListener; 
    private AndroidUtility utility;
    private ControllerDialogFragment dialog = new ControllerDialogFragment();
    int nb=0;
     
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        utility = new AndroidUtility();
        utility.SetView(this);
        AndroidFactory factory = new AndroidFactory(utility);
        Object[] tab = new Object[1];
        tab[0] = (Activity)this;
        //creation du manager en passant en arg la factory et la classe d'utilité
        //DCManager manager = new DCManager(factory,StandardFactory.WIIMOTE_TYPE,tab);
        DCManager manager = new DCManager(factory,AndroidFactory.WIIMOTE_TYPE,tab);
        //Lancement du traitement d'ecoute du controller
        manager.run();
        
        
    }
    
    public void SetListener(SPListener listener)
    {
        this.myListener = listener;
    }
    
    public void TakeOff(View view)
    {
       if(myListener!=null)
            myListener.TakeOff();
    }
     public void Landing(View view)
    {
        if(myListener!=null)
            myListener.Landing();
    }
    public void refresh()
    {
        utility.printToastHisto();
    }
    
  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main_activity_actions, menu);
	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
         case R.id.action_refresh:
            refresh();
            return true;
          case R.id.action_settings:
            dialog.show(getFragmentManager(),"MyDF");
            //openSettings();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }

    }
    
     @Override
    protected void onDestroy()
    {
      utility.EndToast();
    }
    
    
    
    
}
