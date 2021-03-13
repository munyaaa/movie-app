package com.example.movieapp.services

import com.example.movieapp.utilities.JsonReader
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class ApiTest {
    lateinit var mockWebServer: MockWebServer

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start(8080)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testMovieSuccessResponse() {
        val mockedResponse = MockResponse()
        val response : String = JsonReader.readStringFromFile("movie_details_success_response.json")

        mockedResponse.setResponseCode(200)
        mockedResponse.setBody(response)

        mockWebServer.enqueue(mockedResponse)
    }

    @Test
    fun testMovieInvalidAPIKeyResponse() {
        val mockedResponse = MockResponse()
        val response : String = JsonReader.readStringFromFile("movie_details_invalid_api_key_response.json")

        mockedResponse.setResponseCode(401)
        mockedResponse.setBody(response)

        mockWebServer.enqueue(mockedResponse)
    }

    @Test
    fun testMovieNotFoundResponse() {
        val mockedResponse = MockResponse()
        val response : String = JsonReader.readStringFromFile("movie_details_not_found_response.json")

        mockedResponse.setResponseCode(404)
        mockedResponse.setBody(response)

        mockWebServer.enqueue(mockedResponse)
    }

}