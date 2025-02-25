package comviewaquahp.google.sites.youbimiku

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class TranslateUtil {
    companion object {
        private const val endpoint =
            "https://script.google.com/macros/s/AKfycbzEAPpoqrAgkIHyG1-ao2RmW4HxhLJgeVukZ6yBYMp58QvxaWA6eHvzfeBHiUd401SZVQ/exec"

        fun translateEnToJa(text: String): String {
            try {
                val url = URL("$endpoint?text=$text&target=ja")
                val urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.connect()

                val sb = StringBuilder()
                val br = BufferedReader(InputStreamReader(urlConnection.inputStream))
                br.readLines().forEach {
                    sb.append(it)
                }
                br.close()
                return sb.toString()
            } catch (ex: Exception) {
                return Application.instance.getString(R.string.message_error)
            }
        }

        fun translateJaToEn(text: String): String {
            try {
                val url = URL("$endpoint?text=$text&target=en")
                val urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.connect()

                val sb = StringBuilder()
                val br = BufferedReader(InputStreamReader(urlConnection.inputStream))
                br.readLines().forEach {
                    sb.append(it)
                }
                br.close()
                return sb.toString()
            } catch (ex: Exception) {
                return Application.instance.getString(R.string.message_error)
            }
        }
    }
}