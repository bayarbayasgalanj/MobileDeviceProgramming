package com.bright.sunriseset

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bright.sunriseset.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Locale

class PlanetInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * Called when the activity is first created. This function initializes the activity, inflates the layout,
     * retrieves the current time, and asynchronously fetches sunrise and sunset times from an API.
     * The fetched times are then dynamically localized and displayed in Chinese on TextViews.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // calling setLocate function to change Locale to Chinese
        setLocale(this, "zh", "CN")

        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the current time
        val currentTime = LocalDateTime.now()

        // Asynchronously fetch sunrise and sunset times
        GlobalScope.launch(Dispatchers.Main) {
            val sunriseDeferred = async(Dispatchers.IO) { fetchTime("sunrise") }
            val sunsetDeferred = async(Dispatchers.IO) { fetchTime("sunset") }

            // Await the results of asynchronous tasks
            val sunriseTime = sunriseDeferred.await()
            val sunsetTime = sunsetDeferred.await()

            // If both sunrise and sunset times are available, localize and display them in Chinese
            if (sunriseTime != null && sunsetTime != null) {
                // Localize sunrise and sunset times
                val localizedSunrise = getLocalizedTime(sunriseTime, this@PlanetInfoActivity)
                val localizedSunset = getLocalizedTime(sunsetTime, this@PlanetInfoActivity)

                // Display localized times on TextViews
                Log.i("Taaaag","+++++++++++++++"+getString(R.string.SunriseTime)+"    "+localizedSunrise)
                binding.textViewSunrise.text =
                    "${getString(R.string.SunriseTime)} $localizedSunrise"
                binding.textViewSunset.text =
                    "${getString(R.string.SunsetTime)} $localizedSunset"
            }
        }
    }
    // There is force change Locale to Chinese on attachBaseContext
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ContextWrapper(newBase).apply {
            applyOverrideConfiguration(Configuration().apply {
                setLocale(Locale("zh", "CN"))
            })
        })
    }

    /**
     * Retrieves a localized time string based on the user's preferred language.
     *
     * @param time The LocalDateTime to be formatted.
     * @param context The application context to access resources and preferences.
     * @return A string representation of the localized time.
     */
    private fun getLocalizedTime(time: LocalDateTime, context: Context): String {
        // Retrieve the user's preferred language from the device settings
        val userPreferredLanguage = Locale.getDefault().language

        // Create a SimpleDateFormat with the user's preferred language
        val sdf = SimpleDateFormat("hh:mm a", Locale(userPreferredLanguage))

        // Format the LocalDateTime into a string using the specified SimpleDateFormat
        return sdf.format(
            time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        )
    }




    // Coroutine function to fetch sunrise or sunset time from the Sunrise-Sunset API
    private suspend fun fetchTime(type: String): LocalDateTime? {
        return try {
            val apiUrl =
                URL("https://api.sunrise-sunset.org/json?lat=37.7749&lng=-122.4194&formatted=0")
            val urlConnection: HttpURLConnection = apiUrl.openConnection() as HttpURLConnection
            try {
                val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val response = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }

                val jsonResponse = JSONObject(response.toString())
                val timeUTC = jsonResponse.getJSONObject("results").getString(type)
                val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
                val dateTime = formatter.parse(timeUTC)
                LocalDateTime.ofInstant(dateTime.toInstant(), ZoneId.systemDefault())
            } finally {
                urlConnection.disconnect()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
// There is force change Locale to Chinese
fun setLocale(activity: Activity, languageCode: String, countryCode: String) {
    val locale = Locale(languageCode, countryCode)
    Locale.setDefault(locale)
    val resources: Resources = activity.resources
    val config: Configuration = resources.configuration

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        config.setLocale(locale)
    } else {
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}