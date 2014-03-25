/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DroneController.pkg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 *
 * @author Seb
 */
public class ControllerDialogFragment extends DialogFragment {
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setMessage(R.string.popup_titre);
        String[] controllers = getResources().getStringArray(R.array.controllers);

        builder.setTitle(R.string.popup_titre);
        builder.setSingleChoiceItems(controllers, -1,
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
              
        /*builder.setPositiveButton(R.string.popup_OK, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog,int id){
            //TODO
            }       
        });
         builder.setNegativeButton(R.string.popup_CANCEL, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog,int id){
            //TODO
            }       
        });*/
        
        
        return builder.create();
    }
}
