package com.example.luis.nanochat;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.luis.nanochat.models.ChatMessage;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseListAdapter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ListActivity {
    private Firebase mFirebaseRef;
    FirebaseListAdapter<ChatMessage> mListAdapter;
    String mUsername;
    String email;
    ChatMessage data = new ChatMessage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        /**
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        **/
        Firebase.setAndroidContext(this); //Allows the Firebase client to keep its context
<<<<<<< HEAD
        mFirebaseRef = new Firebase("your fire base url"); //Firebase instance(initializes connection to remote db)
=======
        mFirebaseRef = new Firebase("https://nanochatlmr.firebaseio.com/"); //Firebase instance(initializes connection to remote db)
>>>>>>> b143824d4ab1ea16e0057f72c77972e83b68866c

        final EditText textEdit = (EditText) this.findViewById(R.id.text_edit);
        Button sendButton = (Button) this.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUsername != null) {
                    String text = textEdit.getText().toString();
                    data = new ChatMessage(MainActivity.this.email, text, MainActivity.this.mUsername);
                    mFirebaseRef.push().setValue(data);
                    textEdit.setText("");
                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Ooops!")
                            .setMessage("You must log in, before sending a message")
                            .create()
                            .show();
                }
            }
        });


        mListAdapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class,
                android.R.layout.two_line_list_item, mFirebaseRef) {
            @Override
            protected void populateView(View v, ChatMessage model) {
                ((TextView)v.findViewById(android.R.id.text1)).setText(model.getUserName());
                ((TextView)v.findViewById(android.R.id.text2)).setText(model.getText());
            }
        };
        setListAdapter(mListAdapter);

        Button createUser = (Button) findViewById(R.id.createUser);
        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Create User")
                        .setMessage("Enter your email and password")
                        .setView(MainActivity.this.getLayoutInflater().inflate(R.layout.dialog_create_user, null))
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Create User", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog dlg = (AlertDialog) dialog;
                                final String email = ((TextView) dlg.findViewById(R.id.emailCreate)).getText().toString();
                                final String password = ((TextView) dlg.findViewById(R.id.passwordCreate)).getText().toString();
                                final String userName = ((TextView) dlg.findViewById(R.id.userName)).getText().toString();
                                data.setUserName(userName);
                                data.setEmail(email);

                                //firebase auth
                                mFirebaseRef.createUser(email, password, new Firebase.ResultHandler() {
                                    @Override
                                    public void onSuccess() {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setTitle("Success!")
                                                .setMessage("User created, you've been automatically logged in")
                                                .create()
                                                .show();
                                        mFirebaseRef.authWithPassword(email, password, null);
                                    }

                                    @Override
                                    public void onError(FirebaseError firebaseError) {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setTitle("Create User")
                                                .setMessage("Sorry, there was an error, try again")
                                                .create()
                                                .show();
                                    }
                                });


                            }
                        })
                        .create()
                        .show();

            }
        });

        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Enter your email address and password")
                        .setTitle("Login")
                        .setView(MainActivity.this.getLayoutInflater().inflate(R.layout.dialog_signin, null))
                        .setNegativeButton("Cancel", null)
                        .setNeutralButton("Reset Password", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface d, int x) {
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("Password Reset")
                                        .setMessage("Enter your email address")
                                        .setView(MainActivity.this.getLayoutInflater().inflate(R.layout.dialog_reset, null))
                                        .setNegativeButton("Cancel", null)
                                        .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                AlertDialog dlg = (AlertDialog) dialog;
                                                final String email = ((TextView) dlg.findViewById(R.id.emailReset)).getText().toString();
                                                final String newPassword = ((TextView) dlg.findViewById(R.id.passwordReset)).getText().toString();
                                                final String oldPassword = ((TextView) dlg.findViewById(R.id.oldPassword)).getText().toString();

                                                mFirebaseRef.changePassword(email, oldPassword, newPassword, new Firebase.ResultHandler() {
                                                    @Override
                                                    public void onSuccess() {
                                                        new AlertDialog.Builder(MainActivity.this)
                                                                .setMessage("Your password has been reset, check your email")
                                                                .setTitle("Password Reset")
                                                                .create()
                                                                .show();
                                                    }

                                                    @Override
                                                    public void onError(FirebaseError error) {
                                                        new AlertDialog.Builder(MainActivity.this)
                                                                .setMessage("There was an error, try again please")
                                                                .setTitle("Password Reset")
                                                                .create()
                                                                .show();
                                                    }
                                                });
                                            }
                                        })
                                        .create()
                                        .show();
                            }
                        })
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                AlertDialog dlg = (AlertDialog) dialog;
                                final String email = ((TextView) dlg.findViewById(R.id.email)).getText().toString();
                                final String password = ((TextView) dlg.findViewById(R.id.password)).getText().toString();

                                //firebase auth
                                mFirebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {
                                    @Override
                                    public void onAuthenticated(AuthData authData) {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setTitle("Login")
                                                .setMessage("Login Successfully")
                                                .create()
                                                .show();
                                    }

                                    @Override
                                    public void onAuthenticationError(FirebaseError firebaseError) {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setTitle("Oops")
                                                .setMessage("Make sure that email and password are correct")
                                                .create()
                                                .show();
                                    }
                                });
                            }
                        })
                        .create()
                        .show();
            }
        });

        Button logoutButton = (Button) findViewById(R.id.logout);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Logout successfully")
                        .create()
                        .show();
                mFirebaseRef.unauth();
            }
        });

        mFirebaseRef.addAuthStateListener(new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    mUsername = data.getUserName();
                    email = data.getName();
                    findViewById(R.id.login).setVisibility(View.INVISIBLE);
                    findViewById(R.id.logout).setVisibility(View.VISIBLE);
                    findViewById(R.id.createUser).setVisibility(View.INVISIBLE);

                } else {
                    mUsername = null;
                    findViewById(R.id.login).setVisibility(View.VISIBLE);
                    findViewById(R.id.logout).setVisibility(View.INVISIBLE);
                    findViewById(R.id.createUser).setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mListAdapter.cleanup(); //Closes the connection to firebase when the app is not showing
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
