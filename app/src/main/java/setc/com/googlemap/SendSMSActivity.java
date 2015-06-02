package setc.com.googlemap;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends Activity {

    Button sendButton;
    EditText phoneTextField;
    EditText msgTextField;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // load the layout
        setContentView(R.layout.activity_send_sms);

        // make message text field object
        msgTextField = (EditText) findViewById(R.id.msgTextField);
        // make send button object
        sendButton = (Button) findViewById(R.id.sendButton);
        // make phone number field object
        phoneTextField = (EditText) findViewById(R.id.phoneTextField);

    }

    // this is the function that gets called when you click the button
    public void send(View v)
    {
        // get the phone number from the phone number text field
        String phoneNumber = phoneTextField.getText().toString();
        // get the message from the message text box
        String msg = msgTextField.getText().toString();

        // make sure the fields are not empty
        if (phoneNumber.length()>0 && msg.length()>0)
        {
            // call the sms manager
            PendingIntent pi = PendingIntent.getActivity(this, 0,
                    new Intent(this, SendSMSActivity.class), 0);
            SmsManager sms = SmsManager.getDefault();
            // this is the function that does all the magic
            sms.sendTextMessage(phoneNumber, null, msg, pi, null);
        }
        else
        {
            // display message if text fields are empty
            Toast.makeText(getBaseContext(),"All field are required",Toast.LENGTH_SHORT).show();
        }


    }
}