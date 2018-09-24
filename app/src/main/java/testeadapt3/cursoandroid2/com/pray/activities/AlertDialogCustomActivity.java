package testeadapt3.cursoandroid2.com.pray.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import testeadapt3.cursoandroid2.com.pray.R;

public class AlertDialogCustomActivity extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;

    public AlertDialogCustomActivity(Activity a) {
        super( a );
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.activity_alert_dialog_custom );
        yes = (Button) findViewById( R.id.btn_yes );
        no = (Button) findViewById( R.id.btn_no );
        yes.setOnClickListener( this );
        no.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                Intent intent = new Intent( c,LoginActivity.class );
                c.startActivity( intent );
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
