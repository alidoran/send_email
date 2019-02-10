package alidoran.ir.emailsend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    EditText edtSubject;
    EditText edtAddress;
    EditText edtEmail;
    Button btnSend;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        edtSubject=findViewById ( R.id.edtsubject );
        edtAddress=findViewById ( R.id.edtaddress );
        edtEmail=findViewById ( R.id.edtemail );
        btnSend=findViewById ( R.id.btnsend );
        btnSend.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                sentemail ( edtSubject.getText ().toString (),edtAddress.getText ().toString (),edtEmail.getText ().toString () );
            }
        } );


    }

    public void sentemail(String subject,String to,String email ){
        String address[]={to};
        Intent intent=new Intent ( Intent.ACTION_SEND );
        intent.putExtra ( Intent.EXTRA_SUBJECT , subject );
        intent.putExtra ( Intent.EXTRA_EMAIL,address );
        intent.setType ( "plain/text" );
        intent.putExtra ( Intent.EXTRA_TEXT,email );
        startActivity ( intent );



    }
}
