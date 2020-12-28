package com.example.cpsc411_hw2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var cList : MutableList<Claim>
    lateinit var cService : ClaimService

//    fun refreshScreen(pObj : Person) {
//        //
//        Log.d("Person Service", "Refreshing the Screen. ")
//        val firstNameView : EditText = findViewById(R.id.claim_title)
//        val lastNameView : EditText = findViewById(R.id.date)
//        //val ssnView : EditText = findViewById(R.id.ssn)
//        //
//        firstNameView.setText(pObj.firstName)
//        firstNameView.setEnabled(false)
//        lastNameView.setText(pObj.lastName)
//        lastNameView.setEnabled(false)
//        //ssnView.setText(pObj.ssn)
//        //ssnView.setEnabled(false)
//        // Enable/ disable the button
//        val nBtn : Button = findViewById(R.id.add_btn)
//        nBtn.setEnabled(!pService.isLastObject())
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            val fldRowGenerator = ObjDetailScreenGenerator(this)
            val colView = fldRowGenerator.generate()
            setContentView(colView)

            val bView : Button = findViewById(R.id.add_btn)
            var boxClaimTitle = findViewById<EditText>(R.id.claim_title)
            //val boxDate = findViewById<EditText>(R.id.date)
            var statusMessage : TextView = findViewById(R.id.status)

            // Creating counter
            var BoxData = 0

            bView.setOnClickListener{
                ClaimService(this).getCount(Claim("test","test"))
                // feeding in test data, params are never used since intellj RESTful client is simply using
                // the old ClaimService/getAll code to test if server connection was successful

                // Incrementing Counter
                BoxData = BoxData + 1

                // Setting text data
                boxClaimTitle.setText(BoxData.toString())
                statusMessage.setText(BoxData.toString())

                // I had a lot of trouble trying to get the ListView to work below the button with this
                // HMW 2 skeleton code file, so instead I just connected the status view button
                // I am sorry that I was unable to complete this question, and was unable to begin
                // on question 2.

//              old/legacy code

//              Log.d("Claim", boxClaimTitle.text.toString())
//              Log.d("Date", boxDate.text.toString())
//
//                // == Steps ==
//                // Step 1: Convert the data/box fields into strings
                  //convertedBoxData = boxClaimTitle.text.toString();
//                val convertedDateData = boxDate.text.toString();
//
//                // Step 2: Check if converted data exists
//                if(convertedClaimData.isEmpty() || convertedDateData.isEmpty()){
//                    Log.d("Status Message", "One or more fields empty.")
//                    statusMessage.text = "One or more fields empty. \n Please Try again.";
//                }
//                else {
//                    // Step 3: Send data from boxClaimTitle and BoxDate to claim service
//                    Log.d("Status Message", "Sending data to database")
//                    println("Test")
//                    ClaimService(this).addClaim(Claim(convertedClaimData, convertedDateData))
//                    println("Test")
//                    statusMessage.text = "Claim " + convertedClaimData + "\n was successfully created.";
//                }
                //test = convertedBoxData.toInt()

                //test = convertedBoxData.toInt()
                //Log.d("test", convertedBoxData)
//                // Step 4: Clear text view fields
                //boxClaimTitle.text.clear()
//                boxDate.text.clear()
            }
        //@string/app_name
        //pService.getAll()

        //setContentView(R.layout.activity_main)
    }
}