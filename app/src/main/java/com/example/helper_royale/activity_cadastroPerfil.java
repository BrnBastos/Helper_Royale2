package com.example.helper_royale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_cadastroPerfil extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText tagPlayeredit, senhaPlayeredit, conSenhaedit;
    private Button Btncadastroperfil;
    private DBHandler dbhandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_perfil);

        tagPlayeredit = findViewById(R.id.editText_TelaCadastro_Tag);
        senhaPlayeredit = findViewById(R.id.editText_TelaCadastro_Senha);
        conSenhaedit = findViewById(R.id.editText_TelaCadastro_ConSenha);

                /*inserção de confirmação de senha
                    if (!user_password.getText().toString().equals(user_confirm_password.getText().toString()){

                       Toast.makeText(this, "Confirm password is not correct", Toast.LENGTH_SHORT).show();

                       where user_password and user_confirm_password is your edit text.
                 */
        // creating a new dbhandler class
        // and passing our context to it.
        dbhandler = new DBHandler(activity_cadastroPerfil.this);

        // below line is to add on click listener for our add course button.
        Btncadastroperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String tagplayer = tagPlayeredit.getText().toString();
                String senhaPlayer = senhaPlayeredit.getText().toString();
                String conSenha = conSenhaedit.getText().toString();

                // validating if the text fields are empty or not.
                if (tagplayer.isEmpty() && senhaPlayer.isEmpty() && conSenha.isEmpty()) {
                    Toast.makeText(activity_cadastroPerfil.this, "Preencha todos os campos, por favor ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!senhaPlayer.equals(conSenha)) {
                    Toast.makeText(activity_cadastroPerfil.this, "A senha está incorreta entre os dois campos, verifique novamente", Toast.LENGTH_SHORT).show();
                    return;

                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbhandler.addPerfil(tagplayer, senhaPlayer);

                // after adding the data we are displaying a toast message.
                Toast.makeText(activity_cadastroPerfil.this, "Cadastro feito com sucesso", Toast.LENGTH_SHORT).show();





            }
        });
  }


    }
}