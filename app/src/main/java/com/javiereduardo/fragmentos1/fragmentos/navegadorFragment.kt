package com.javiereduardo.fragmentos1.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import com.javiereduardo.fragmentos1.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val DEFAULT_URL = "urlPorDefault"
lateinit var wvNavegador:WebView
lateinit var btnIr:Button
lateinit var etUrl:EditText

/**
 * A simple [Fragment] subclass.
 * Use the [navegadorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class navegadorFragment : Fragment() {
    private var url: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(DEFAULT_URL)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vistaNavegador = inflater.inflate(R.layout.fragment_navegador, container, false)

        wvNavegador = vistaNavegador.findViewById(R.id.wvNavegador)
        btnIr = vistaNavegador.findViewById(R.id.btnir)
        etUrl = vistaNavegador.findViewById(R.id.etUrl)


        val webSettings = wvNavegador.settings
        webSettings.javaScriptEnabled = true
        wvNavegador.loadUrl("https://google.com")

        wvNavegador.webViewClient = object : WebViewClient() {}
        btnIr.setOnClickListener {
            url = etUrl.text.toString().trim()
            if (!url!!.isEmpty()){
                url = "https://"+url
                wvNavegador.loadUrl(url!!)

            }
        }

        return vistaNavegador
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param url Por default.

         * @return A new instance of fragment navegadorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(urlPorDefault: String) =
            navegadorFragment().apply {
                arguments = Bundle().apply {
                    putString(DEFAULT_URL, urlPorDefault)
                }
            }
    }
}