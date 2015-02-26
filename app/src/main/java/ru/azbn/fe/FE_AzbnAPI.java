package ru.azbn.fe;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Map;

public class FE_AzbnAPI {

	FE_ForEach FE;
	private RequestQueue rQ;

	public FE_AzbnAPI(FE_ForEach fe) {
		FE = fe;
		rQ = Volley.newRequestQueue(FE.appContext);
	}

	public void get(String url, Listener<String> listener) {
		StringRequest json = new StringRequest(Request.Method.GET,
				url,
				listener,
				new ErrorListener());
		rQ.add(json);
	}

	public void getAsJSON(String url, Listener<JSONObject> listener) {
		JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET,
				url,
				null,
				listener,
				new ErrorListener());
		rQ.add(json);
	}

	public void post(String url, final Map<String, String> map, Listener<String> listener) {
		StringRequest json = new StringRequest(Request.Method.POST,
				url,
				listener,
				new ErrorListener()) {
			@Override
			protected Map<String, String> getParams() {
				return map;
			}
		};
		rQ.add(json);
	}

	public class ErrorListener implements Response.ErrorListener {

		@Override
		public void onErrorResponse(VolleyError error) {
			Log.d("FE.AzbnAPI.error.volley", error.getMessage());
		}

	}

}