package gabriela.projeto;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserProfile extends Activity {
    private TextView textView;
    private ProgressDialog loading;
    EditText email;
    EditText assunto;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        email = (EditText)findViewById(R.id.email);
        assunto = (EditText)findViewById(R.id.assunto);
        texto = (EditText)findViewById(R.id.mensagem);
        textView = (TextView) findViewById(R.id.textViewUsername);

        Intent intent = getIntent();

        String user = intent.getStringExtra(MainActivity.KEY_USERNAME);
        textView.setText("Bem-vindo " + user);

    }

        public void ir(View view){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL, email.getText().toString());
            intent.putExtra(Intent.EXTRA_SUBJECT, assunto.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
}
