package csuf.cpsc411

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import com.google.gson.Gson
import csuf.cpsc411.Dao.Database
import csuf.cpsc411.Dao.Claim.ClaimDao
import csuf.cpsc411.Dao.Claim.Claim

import io.ktor.utils.io.readAvailable

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        // Test with: http://localhost:8080/ClaimService/add
        post("/ClaimService/add") {
            val contType = call.request.contentType()
            val data = call.request.receiveChannel()
            val dataLength = data.availableForRead
            var output = ByteArray(dataLength)
            data.readAvailable(output)
            val str = String(output)

            // Json deserialization
            var cObj1 : Claim
            cObj1 = Gson().fromJson(str, Claim::class.java)
            val dao = ClaimDao().addClaim(cObj1)
            val dbObj = Database.getInstance()

            println("${cObj1.toString()}")
            println("HTTP message is using POST method with /post ${contType} ${str}")
            call.respondText("The POST request was successfully processed.",
                    status= HttpStatusCode.OK, contentType = ContentType.Text.Plain)
        }

        // Test with: http://localhost:8010/ClaimService/getAll
        get("/ClaimService/getAll") {
            var cList = ClaimDao().getAllClaims()

            val respJsonStr = Gson().toJson(cList)

            call.respondText(respJsonStr, status= HttpStatusCode.OK, contentType=ContentType.Application.Json)
        }

        // Uses "claim service/get all" code as test code to see if android studio project connects with it to database
        // Test with: http://localhost:8010/SiteService/getCount
        get("/SiteService/getCount") {
            var cList = ClaimDao().getCount()

            val respJsonStr = Gson().toJson(cList)
            println("HTTP message is using POST method with /post")
            call.respondText(respJsonStr, status= HttpStatusCode.OK, contentType=ContentType.Application.Json)
        }
    }
}

//            println("HTTP message is using POST method with /post ${contType} ${str}")
//            call.respondText("The POST request was successfully processed. ",
//                    status = HttpStatusCode.OK, contentType = ContentType.Text.Plain)
//
//            // In postman, select 'POST' then input: http://localhost:8010/post then select 'text'
//            // In body then raw then in text box field input: FirstName=Ernesto&LastName=Hooghkirk
//            // Then hit 'send'
//            // returns:  HTTP message is using POST method with /post text/plain FirstName=Ernesto&LastName=Hooghkirk
//
//            // or in postman follow above steps except, select 'JSON' instead of 'text'
//            // in text box field input: {"FirstName":"Ernesto", "LastName":"Hooghkirk"}
//            // Then hit 'send'
//            // returns:  HTTP message is using POST method with /post application/json {"FirstName":"Ernesto", "LastName":"Hooghkirk"}

