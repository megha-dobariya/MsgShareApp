package com.msgshareapp.Acitivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.msgshareapp.Constants
import com.msgshareapp.Extensions.showToast
import com.msgshareapp.R

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtUserMsg = findViewById<TextView>(R.id.txtUserMsg)
        //safe Call ?.
        //Safe call with let ?.{}

        val bundle: Bundle? = intent.extras
        bundle ?.let{
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            showToast(msg)
            txtUserMsg.text = msg
        }
    }
}