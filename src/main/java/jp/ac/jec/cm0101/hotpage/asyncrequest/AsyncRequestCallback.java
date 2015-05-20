package jp.ac.jec.cm0101.hotpage.asyncrequest;

public interface AsyncRequestCallback {
    void onPreExecute();
    void onPostExecute(String result);
}
