package com.example.cpsc411_hw2

import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity

class ClaimService (val ctx : MainActivity){

    inner class AddServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Status Message", "Successfully utilized Async Http Client API")
                Log.d("Claim Service", "The add Claim Service response : ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            Log.d("Status Message", "Error in adding claim to database")
        }
    }

    fun addClaim(pObj : Claim) {
        Log.d("Status Message", "Adding Claim to Database")
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.56.1:8010/ClaimService/add"

        // 1. Convert the pObj into JSON string
        val pJsonString= Gson().toJson(pObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", AddServiceRespHandler())
    }

    fun getCount(pObj : Claim) {
        Log.d("Status Message", "Service Called")
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.56.1:8010/SiteService/getCount"

        // 1. Convert the pObj into JSON string
        val pJsonString= Gson().toJson(pObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", AddServiceRespHandler())
    }
}