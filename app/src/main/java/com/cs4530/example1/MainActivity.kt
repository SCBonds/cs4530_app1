package com.cs4530.example1

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.Button


//Implement View.onClickListener to listen to button clicks. This means we have to override onClick().
class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Create variables to hold one string
    private var mFullName: String? = null
    private var mFirst_Name: String? = null
    private var mMiddle_Name: String? = null
    private var mLast_Name: String? = null


    //Create variables for the UI elements that we need to control
    private var mButtonSubmit: Button? = null

    //private var mEtFullName: EditText? = null
    private var mEtFirstName: EditText? = null
    private var mEtMiddleName: EditText? = null
    private var mEtLastName: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get the button
        mButtonSubmit = findViewById(R.id.button_submit)

        //Say that this class itself contains the listener.
        mButtonSubmit!!.setOnClickListener(this)
    }

    //Handle clicks for ALL buttons here
    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_submit -> {

                //First, get the string from the EditText
                //mEtFullName = findViewById(R.id.et_name)
                mEtFirstName = findViewById(R.id.first_name)
                mEtMiddleName = findViewById(R.id.middle_name)
                mEtLastName = findViewById(R.id.last_name)

                //mFullName = mEtFullName!!.text.toString()
                mFirst_Name = mEtFirstName!!.text.toString()
                mMiddle_Name = mEtMiddleName!!.text.toString()
                mLast_Name = mEtLastName!!.text.toString()


                //Check if the EditText string is empty
                if (mFirst_Name.isNullOrBlank()) {
                    //Complain that there's no text
                    Toast.makeText(this@MainActivity, "Enter a first name first!", Toast.LENGTH_SHORT)
                        .show()
                }
                else if (mMiddle_Name.isNullOrBlank()) {
                    //Complain that there's no text
                    Toast.makeText(this@MainActivity, "Enter a middle name first!", Toast.LENGTH_SHORT)
                        .show()
                }
                else if (mLast_Name.isNullOrBlank()) {
                    //Complain that there's no text
                    Toast.makeText(this@MainActivity, "Enter a last name first!", Toast.LENGTH_SHORT)
                        .show()
                }

                else {
                    //Reward them for submitting their names
                    Toast.makeText(this@MainActivity, "Good job!", Toast.LENGTH_SHORT).show()

                    //Start an activity and pass the EditText string to it.
                    mFullName = mFirst_Name + " " + mLast_Name
                    val messageIntent = Intent(this, DisplayActivity::class.java)
                    messageIntent.putExtra("ET_STRING", mFullName)
                    this.startActivity(messageIntent)
                }
            }
        }
    }
}
