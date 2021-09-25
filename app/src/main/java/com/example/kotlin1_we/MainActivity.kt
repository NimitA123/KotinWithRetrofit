package com.example.kotlin1_we

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    private var responseList = listOf<ResponseDTO
            >();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //? means nullable
        // companion object everything is static inside class in network class
        btnPost.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getPost(etPostId.text.toString().toInt())
            .enqueue(object : retrofit2.Callback<List<ResponseDTO>> {
                override fun onResponse(
                    call: Call<List<com.example.kotlin1_we.ResponseDTO>>,
                    response: Response<List<com.example.kotlin1_we.ResponseDTO>>
                ) {
                    responseList =
                        response.body()!! //asserting non null but if the response.body() is null you will get NPE
                         setRecyclerView()

                }

                override fun onFailure(
                    call: Call<List<com.example.kotlin1_we.ResponseDTO>>,
                    t: Throwable
                ) {

                }

            })


        }

    private fun setRecyclerView() {
        val postAdapter = PostAdapter(responseList)
        val linearLayout = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager = linearLayout

    }
}






