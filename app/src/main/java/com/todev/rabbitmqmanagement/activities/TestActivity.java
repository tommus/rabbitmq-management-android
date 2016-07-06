/*
 * Copyright (c) 2016. to-dev.com.
 *
 * Licensed under the GNU GPL, Version 3 (the "License").
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.todev.rabbitmqmanagement.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.services.RabbitMqService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class TestActivity extends AppCompatActivity {

    protected RabbitMqService mRabbitMqService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initRabbitMqService();
    }

    protected void initRabbitMqService() {

        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(RabbitMqService.TEST_URL)
            .addConverterFactory(JacksonConverterFactory.create());

        httpClient.addInterceptor(new Interceptor() {

            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                final Request original = chain.request();

                final Request.Builder requestBuilder = original
                    .newBuilder()
                    .header("Authorization", RabbitMqService.TEST_CREDENTIALS)
                    .header("Accept", "application/json")
                    .method(original.method(), original.body());

                return chain.proceed(requestBuilder.build());
            }
        });

        final OkHttpClient client = httpClient.build();

        final Retrofit retrofit = builder.client(client).build();

        mRabbitMqService = retrofit.create(RabbitMqService.class);
    }
}
