package com.example.TestMe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubApiService {

    @GET("questions")
    Call<List<Question>> getAllQuestions();
}
