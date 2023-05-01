package com.j0nathan550.multitoolapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherFragment extends Fragment {
    private SearchView weatherSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        weatherSearch = view.findViewById(R.id.searchViewWeather);
        weatherSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set focus on the SearchView
                weatherSearch.setFocusable(true);
                weatherSearch.setIconified(false);
                weatherSearch.requestFocusFromTouch();
            }
        });
        weatherSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                String url = "https://api.weatherapi.com/v1/current.json?key=0f7a905814c64fbe88d170927232904&q=" + query + "&aqi=no";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(JSONObject response) {
                        TextView cityLabel = view.findViewById(R.id.cityNameLabel);
                        TextView cityRegion = view.findViewById(R.id.cityRegionLabel);
                        TextView cityCountry = view.findViewById(R.id.cityCountryLabel);
                        TextView tzLabel = view.findViewById(R.id.cityTZLabel);
                        TextView localTimeLabel = view.findViewById(R.id.cityLocalTimeLabel);
                        TextView lastUpdatedLabel = view.findViewById(R.id.cityLastUpdatedWeatherLabel);
                        TextView temperatureLabel = view.findViewById(R.id.cityCurrentTemperatureLabel);
                        TextView conditionLabel = view.findViewById(R.id.cityConditionLabel);
                        TextView humidityLabel = view.findViewById(R.id.cityHumidityLabel);
                        TextView cloudyLabel = view.findViewById(R.id.cityCloudLabel);
                        try {
                            JSONObject locationObject = response.getJSONObject("location");
                            JSONObject currentObject = response.getJSONObject("current");
                            JSONObject conditionObject = currentObject.getJSONObject("condition");
                            String locationName = locationObject.getString("name");
                            String locationCountry = locationObject.getString("country");
                            String regionName = locationObject.getString("region");
                            String tzIDName = locationObject.getString("tz_id");
                            String localTime = locationObject.getString("localtime");
                            String lastUpdated = currentObject.getString("last_updated");
                            String temperature = currentObject.getString("temp_c");
                            String condition = conditionObject.getString("text");
                            String humidity = currentObject.getString("humidity");
                            String cloudy = currentObject.getString("cloud");
                            cityLabel.setText("City: " + locationName);
                            cityRegion.setText("Region: " + regionName);
                            tzLabel.setText("Timezone: " + tzIDName);
                            localTimeLabel.setText("Local Time: " + localTime);
                            lastUpdatedLabel.setText("Last Updated: " + lastUpdated);
                            temperatureLabel.setText("Temperature: " + temperature + " ℃");
                            humidityLabel.setText("Humidity: " + humidity + "%");
                            cloudyLabel.setText("Cloudy: " + cloudy + "%");
                            conditionLabel.setText("Condition: " + condition);
                            cityCountry.setText("Country: " + locationCountry);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Unknown country/city!", Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(request);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;
    }
}