package com.msgshareapp.Acitivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.msgshareapp.Constants
import com.msgshareapp.Extensions.showToast
import com.msgshareapp.R

class MainActivity : ComponentActivity() {

    companion object {
        val TAG : String = MainActivity:: class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast = findViewById<Button>(R.id.btnShowToast)
        val btnShareToOtherApps = findViewById<Button>(R.id.btnShareToOtherApps)
        val btnRecyclerViewDemo = findViewById<Button>(R.id.btnRecyclerViewDemo)
        val edtUserMessage = findViewById<EditText>(R.id.edtUserMessage)
        // set on-click listener
        btnShowToast.setOnClickListener {
            // your code to perform when the user clicks on the button
            Log.i(TAG, "Button is clicked");
            showToast(resources.getString(R.string.button_was_clicked), Toast.LENGTH_LONG)
//            Toast.makeText(this, "Button show toast clicked", Toast.LENGTH_SHORT).show()
        }

        val btnSendMsgToActivity = findViewById<Button>(R.id.btnSendMsgToActivity)
        btnSendMsgToActivity.setOnClickListener {
            // your code to perform when the user clicks on the button

            val message: String = edtUserMessage.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {

            val message: String = edtUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT , message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Please Select The Apps :"))
        }

        btnRecyclerViewDemo.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

//        setContent {
//            MsgShareAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
////                    Greeting("Android")
//                }
//            }
//        }

    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//            text = "Hello $name!",
//            modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MsgShareAppTheme {
//        Greeting("Android")
//    }
//}