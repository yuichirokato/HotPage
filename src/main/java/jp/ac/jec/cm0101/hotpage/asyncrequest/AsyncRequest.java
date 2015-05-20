package jp.ac.jec.cm0101.hotpage.asyncrequest;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AsyncRequest extends AsyncTask<String, Integer, String> {

    private AsyncRequestCallback mAsyncRequestCallback;
    private final String URL_SCHEME = "http://";
    private final String URL_AUTHORITY = "157.7.73.106";
    private final String URL_CURRICULUM_PATH = "/api/entries/category/1.json";
    private final String URL_ACT_PATH = "/api/entries/category/2.json";
    private final String URL_EVENT_PATH = "/api/entries/category/3.json";
    private final String URL_PEOPLE_PATH = "/api/entries/category/4.json";
    private final String URL_JOB_HUNTING_PATH = "/api/entries/category/5.json";

    public AsyncRequest(AsyncRequestCallback callback) {
        mAsyncRequestCallback = callback;
    }

    @Override
    protected String doInBackground(String... urls) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(urls[0]);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                httpResponse.getEntity().writeTo(outputStream);
                return outputStream.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "parse failed!";
        }
        return "parse failed!";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mAsyncRequestCallback.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mAsyncRequestCallback.onPostExecute(result);
    }

    public String getUrlByPagePosition(int position) {
        switch (position) {
            case 0:
                return URL_SCHEME + URL_AUTHORITY + URL_CURRICULUM_PATH;

            case 1:
                return URL_SCHEME + URL_AUTHORITY + URL_ACT_PATH;

            case 2:
                return URL_SCHEME + URL_AUTHORITY + URL_EVENT_PATH;

            case 3:
                return URL_SCHEME + URL_AUTHORITY + URL_PEOPLE_PATH;

            case 4:
                return URL_SCHEME + URL_AUTHORITY + URL_JOB_HUNTING_PATH;

            default:
                return URL_SCHEME + URL_AUTHORITY + URL_CURRICULUM_PATH;
        }
    }
}
